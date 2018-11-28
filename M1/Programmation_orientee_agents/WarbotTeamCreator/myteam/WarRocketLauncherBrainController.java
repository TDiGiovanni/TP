package myteam;

import java.util.ArrayList;

import edu.warbot.agents.MovableWarAgent;
import edu.warbot.agents.agents.WarExplorer;
import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.agents.percepts.WarAgentPercept;
import edu.warbot.brains.WarBrain;
import edu.warbot.brains.brains.WarRocketLauncherBrain;
import edu.warbot.communications.WarMessage;

public abstract class WarRocketLauncherBrainController extends WarRocketLauncherBrain
{
	WTask ctask;
	private static final int maxDistance = 150; 

	static WTask searchForEnemyBase = new WTask()
	{
		String exec(WarBrain bc)
		{
			WarRocketLauncherBrainController me = (WarRocketLauncherBrainController) bc;

			// Si j'ai un message de la base je vais vers elle
			WarMessage m = me.getMessageFromBase();
			if (m != null && m.getDistance() < maxDistance)
			{
				me.setHeading(m.getAngle());
				me.ctask = protectBase;
			}
			
			String[] content;
			for (WarMessage message : me.getMessages())
				if (message.getMessage().equals("Enemy base here") && message.getDistance() < maxDistance)
				{
					content = message.getContent();
					me.setHeading(message.getAngle());
					return ACTION_MOVE;
				}
					
			for (WarAgentPercept percept : me.getPerceptsEnemies())
			{
				if (percept.getType().equals(WarAgentType.WarBase)) // Si on voit une base ennemie
				{
					me.setDebugString("Attacking enemy base");
					
					me.setHeading(percept.getAngle());

					if (me.isReloaded())
						return ACTION_FIRE;
					else if (me.isReloading())
						return ACTION_IDLE;
					else
						return ACTION_RELOAD;
				}
			}

			return ACTION_MOVE;
		}
	};


	static WTask protectBase = new WTask()
	{
		String exec(WarBrain bc)
		{
			WarRocketLauncherBrainController me = (WarRocketLauncherBrainController) bc;
			
			me.setDebugString("Protecting base");

			ArrayList<WarAgentPercept> basePercepts = (ArrayList<WarAgentPercept>) me.getPerceptsAlliesByType(WarAgentType.WarBase);
			
			// Si je ne vois pas de base alliée
			if (basePercepts == null | basePercepts.size() == 0)
			{	
				// Si j'ai un message de la base je vais vers elle
				WarMessage m = me.getMessageFromBase();
				if (m != null)
					me.setHeading(m.getAngle());

				return ACTION_MOVE;
			}
			else // Si je vois une base alliée
			{
				WarAgentPercept base = basePercepts.get(0);

				if (base.getDistance() > 10)
				{
					me.setHeading(base.getAngle());
					return MovableWarAgent.ACTION_MOVE;
				}
				
				me.ctask = searchForEnemyBase;
				return MovableWarAgent.ACTION_MOVE;
			}
		}
	};

	public WarRocketLauncherBrainController()
	{
		super();
		ctask = searchForEnemyBase;
	}

	@Override
	public String action()
	{
		String toReturn = ctask.exec(this); // Run de la FSM

		if (isBlocked())
			setRandomHeading();

		if (toReturn == null)
			return WarExplorer.ACTION_MOVE;
		else
			return toReturn;
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
