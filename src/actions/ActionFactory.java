package actions;

import exceptions.NoSuchActionException;
import exceptions.NoSuchPlantTypeException;

import java.util.Arrays;

public class ActionFactory {
    private static final String[] VALID_PLANTS = {"A", "B"};


    public Action getAction(String action) throws NoSuchActionException, NoSuchPlantTypeException {
        if (action == null) {
            throw new NoSuchActionException("null");
        }
        if (action.equals("HARVEST")) {
            return new HarvestAction();
        } else if (action.equals("FERTILIZE")) {
            return new FertilizeAction();
        } else if (action.startsWith("PLANT")) {
            String chosenPlant = action.substring(5);
            if (validPlant(chosenPlant)) {
                return new PlantAction(chosenPlant);
            } else {
                throw new NoSuchPlantTypeException(chosenPlant);
            }
        }
        throw new NoSuchActionException(action);
    }

    private boolean validPlant(String chosenPlant) {
        return Arrays.asList(VALID_PLANTS).contains(chosenPlant);
    }
}
