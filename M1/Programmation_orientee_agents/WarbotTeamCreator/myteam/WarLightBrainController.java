package myteam;

import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.agents.percepts.WarAgentPercept;
import edu.warbot.brains.brains.WarLightBrain;

public abstract class WarLightBrainController extends  WarLightBrain
{
    public WarLightBrainController()
    {
        super();
    }

    @Override
    public String action()
    {
        for (WarAgentPercept percept : getPerceptsEnemies())
        {

            if (!percept.getType().equals(WarAgentType.WarBase))
            {
                setHeading(percept.getAngle());
                
                if (isReloaded())
                    return ACTION_FIRE;
                else if (isReloading())
                    return ACTION_IDLE;
                else
                    return ACTION_RELOAD;
            }
        }

        if (isBlocked())
            setRandomHeading();

        return ACTION_MOVE;
    }
}
