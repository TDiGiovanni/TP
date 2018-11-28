package myteam;


import java.util.ArrayList;
import java.util.List;

import edu.warbot.agents.MovableWarAgent;
import edu.warbot.agents.WarResource;
import edu.warbot.agents.agents.WarExplorer;
import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.agents.percepts.WarAgentPercept;
import edu.warbot.brains.WarBrain;
import edu.warbot.brains.brains.WarExplorerBrain;
import edu.warbot.communications.WarMessage;

public abstract class WarExplorerBrainController extends WarExplorerBrain
{
	WTask ctask;

	static WTask handleMsgs = new WTask()
	{ 
		String exec(WarBrain bc)
		{
			return "";
		}
	};

	static WTask returnFood = new WTask()
	{
		String exec(WarBrain bc)
		{
			WarExplorerBrainController me = (WarExplorerBrainController) bc;

			me.setDebugString("Returning Food");

			if(me.isBagEmpty())
			{
				me.setHeading(me.getHeading() + 180);

				me.ctask = explore;
				return ACTION_MOVE;
			}

			List<WarAgentPercept> basePercepts = me.getPerceptsAlliesByType(WarAgentType.WarBase);

			// Si je ne vois pas de base alliée
			if (basePercepts == null | basePercepts.size() == 0)
			{	
				// Si j'ai un message de la base je vais vers elle
				WarMessage m = me.getMessageFromBase();
				if (m != null)
					me.setHeading(m.getAngle());

				return MovableWarAgent.ACTION_MOVE;
			}
			else // Si je vois une base alliée
			{
				WarAgentPercept base = basePercepts.get(0);

				if (base.getDistance() > MovableWarAgent.MAX_DISTANCE_GIVE)
				{
					me.setHeading(base.getAngle());
					return MovableWarAgent.ACTION_MOVE;
				}
				else
				{
					me.setIdNextAgentToGive(base.getID());
					return MovableWarAgent.ACTION_GIVE;
				}
			}
		}
	};

	static WTask explore = new WTask()
	{
		String exec(WarBrain bc)
		{
			WarExplorerBrainController me = (WarExplorerBrainController) bc;
			
			me.setDebugString("Exploring");
			
			for (WarAgentPercept percept : me.getPerceptsEnemies())
			{
				if (percept.getType().equals(WarAgentType.WarBase)) // Si on voit une base ennemie
				{
					me.broadcastMessageToAgentType(WarAgentType.WarRocketLauncher,
							"Enemy base here",
							String.valueOf(percept.getAngle()),
							String.valueOf(percept.getDistance())
							);
				}
			}
			
			if (me.isBagFull())
			{
				me.ctask = returnFood;
				return ACTION_MOVE;
			}

			ArrayList<WarAgentPercept> foodPercepts = me.getFoodPercepts();

			// S'il y a de la nourriture
			if (foodPercepts != null && foodPercepts.size() > 0)
			{
				WarAgentPercept foodPercept = foodPercepts.get(0); // Le 0 est le plus proche

				if (foodPercept.getDistance() > WarResource.MAX_DISTANCE_TAKE)
				{
					me.setHeading(foodPercept.getAngle());
					return MovableWarAgent.ACTION_MOVE;
				}
				else
					return MovableWarAgent.ACTION_TAKE;
			}
			else
			{
				WarMessage foodMessage = me.getMessageAboutFood();
				if (foodMessage != null)
					;

				return MovableWarAgent.ACTION_MOVE;
			}
		}
	};

	public WarExplorerBrainController()
	{
		super();
		ctask = explore; // Initialisation de la FSM
	}

	@Override
	public String action()
	{
		String toReturn = ctask.exec(this); // Run de la FSM
		
		if (isBlocked())
			setRandomHeading();
		
		if (toReturn == null)
		{
			return WarExplorer.ACTION_MOVE;
		}
		else
		{
			return toReturn;
		}
	}

	private ArrayList<WarAgentPercept> getFoodPercepts()
	{
		ArrayList<WarAgentPercept> percepts = (ArrayList<WarAgentPercept>) getPercepts();
		ArrayList<WarAgentPercept> foodPercepts = new ArrayList<WarAgentPercept>();
		for (WarAgentPercept percept : percepts)
			if (percept.getType().equals(WarAgentType.WarFood))
				foodPercepts.add(percept);

		return foodPercepts;
	}

	private WarMessage getMessageAboutFood()
	{
		for (WarMessage m : getMessages())
			if(m.getMessage().equals("Food here"))
				return m;

		return null;
	}

	private WarMessage getMessageFromBase()
	{
		for (WarMessage m : getMessages())
			if(m.getSenderType().equals(WarAgentType.WarBase))
				return m;

		broadcastMessageToAgentType(WarAgentType.WarBase, "Where is the base", "");
		return null;
	}
}


