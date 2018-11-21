package myteam;

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
	
	static WTask searchForEnemyBase = new WTask()
	{
		String exec(WarBrain bc)
		{
			WarRocketLauncherBrainController me = (WarRocketLauncherBrainController) bc;
			
			// Si j'ai un message de la base je vais vers elle
			WarMessage m = me.getMessageFromBase();
			if (m != null && m.getDistance() < 40)
			{
				me.setHeading(m.getAngle());
				me.ctask = protectBase;
			}

			for (WarAgentPercept percept : me.getPerceptsEnemies())
			{
				if (percept.getType().equals(WarAgentType.WarBase))
				{
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
			WarExplorerBrainController me = (WarExplorerBrainController) bc;
			
			return MovableWarAgent.ACTION_MOVE;
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
		{
			return WarExplorer.ACTION_MOVE;
		}
		else
		{
			return toReturn;
		}
	}

	private WarMessage getMessageFromBase()
	{
		for (WarMessage m : getMessages())
			if(m.getSenderType().equals(WarAgentType.WarBase))
				return m;

		return null;
	}
}
