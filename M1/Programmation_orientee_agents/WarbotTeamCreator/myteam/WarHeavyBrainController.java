package myteam;

import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.agents.percepts.WarAgentPercept;
import edu.warbot.brains.brains.WarHeavyBrain;

public abstract class WarHeavyBrainController extends  WarHeavyBrain
{
    public WarHeavyBrainController()
    {
        super();
    }

    @Override
    public String action()
    {

        for (WarAgentPercept percept : getPerceptsEnemies()) {

            if (percept.getType().equals(WarAgentType.WarBase)
            		|| percept.getType().equals(WarAgentType.WarRocketLauncher)
            		|| percept.getType().equals(WarAgentType.WarHeavy))
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