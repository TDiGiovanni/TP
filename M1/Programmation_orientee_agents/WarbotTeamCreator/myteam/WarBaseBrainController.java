package myteam;

import edu.warbot.agents.agents.WarBase;
import edu.warbot.agents.enums.WarAgentCategory;
import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.agents.percepts.WarAgentPercept;
import edu.warbot.brains.brains.WarBaseBrain;
import edu.warbot.communications.WarMessage;

import java.util.ArrayList;
import java.util.List;

public abstract class WarBaseBrainController extends WarBaseBrain
{
    private boolean _alreadyCreated;
    private boolean _inDanger;

    public WarBaseBrainController()
    {
        super();
        _alreadyCreated = false;
        _inDanger = false;
    }

    @Override
    public String action()
    {
        if (!_alreadyCreated)
        {
            setNextAgentToCreate(WarAgentType.WarEngineer);
            _alreadyCreated = true;
            return WarBase.ACTION_CREATE;
        }

        if (getNbElementsInBag() >= 0 && getHealth() <= 0.8 * getMaxHealth())
            return WarBase.ACTION_EAT;

        if (getMaxHealth() == getHealth())
        {
            _alreadyCreated = true;
        }

        List<WarMessage> messages = getMessages();

        for (WarMessage message : messages)
        {
            if (message.getMessage().equals("Where is the base"))
                reply(message, "I'm here");
        }

        for (WarAgentPercept percept : getPerceptsEnemies())
        {
        	setDebugString("Under attack");
        	
            if (percept.getType().getCategory().equals(WarAgentCategory.Soldier))
                broadcastMessageToAgentType(WarAgentType.WarRocketLauncher,
                		"I'm under attack",
                        String.valueOf(percept.getAngle()),
                        String.valueOf(percept.getDistance())
                        );
        }

        for (WarAgentPercept percept : getFoodPercepts())
        {
            if (percept.getType().equals(WarAgentType.WarFood))
                broadcastMessageToAgentType(WarAgentType.WarExplorer,
                		"Food here",
                        String.valueOf(percept.getAngle()),
                        String.valueOf(percept.getDistance())
                        );
        }

        return WarBase.ACTION_IDLE;
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
}
