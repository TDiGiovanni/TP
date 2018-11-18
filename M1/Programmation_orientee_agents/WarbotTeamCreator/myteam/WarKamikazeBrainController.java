package myteam;

import edu.warbot.agents.agents.WarExplorer;
import edu.warbot.agents.percepts.WarAgentPercept;
import edu.warbot.brains.brains.WarKamikazeBrain;

import java.util.List;

public abstract class WarKamikazeBrainController extends WarKamikazeBrain
{
	public WarKamikazeBrainController()
	{
		super();
	}

	@Override
	public String action()
	{
		List <WarAgentPercept> percepts = getPercepts();

		for (WarAgentPercept percept : percepts)
			switch (percept.getType())
			{
			case WarBase:
				if (isEnemy(percept))
					broadcastMessageToAll("Enemy base found", String.valueOf(percept.getAngle()), String.valueOf(percept.getDistance()));
				break;

			default:
				break;
			}

		if (isBlocked())
			setRandomHeading();
		
		return WarExplorer.ACTION_MOVE;
	}
}
