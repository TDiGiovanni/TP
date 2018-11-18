package myteam;

import java.util.List;

import edu.warbot.agents.agents.WarExplorer;
import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.agents.percepts.WarAgentPercept;
import edu.warbot.brains.brains.WarExplorerBrain;

public abstract class WarExplorerBrainController extends WarExplorerBrain
{
	public WarExplorerBrainController()
	{
		super();
	}

	@Override
	public String action()
	{
		List<WarAgentPercept> enemyBase = getPerceptsEnemiesByType(WarAgentType.WarBase);
		if (!enemyBase.isEmpty())
			broadcastMessageToAgentType(WarAgentType.WarBase, "Enemy base detected", "");

		List<WarAgentPercept> resources = getPerceptsResources();

		if (!resources.isEmpty())
		{
			broadcastMessageToAgentType(WarAgentType.WarBase, "Food detected", "");
			
			setHeading(resources.get(0).getAngle());
			
			if (resources.get(0).getDistance() == 0)
				return WarExplorer.ACTION_TAKE;
		}

		if (isBlocked())
			setRandomHeading();

		return WarExplorer.ACTION_MOVE;
	}
}
