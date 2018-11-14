package myteam;

import java.util.List;

import edu.warbot.agents.agents.WarExplorer;
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
		if (isBlocked())
			setRandomHeading();
		else
		{
			List<WarAgentPercept> resources = getPerceptsResources();

			if (!resources.isEmpty())
			{
				setHeading(resources.get(0).getAngle());
				if (resources.get(0).getDistance() == 0)
					return WarExplorer.ACTION_TAKE;
			}
		}

		return WarExplorer.ACTION_MOVE;
	}
}
