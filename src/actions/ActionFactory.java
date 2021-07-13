package actions;

import parcel.plant.PlantType;
import exceptions.NoSuchActionException;
import exceptions.NoSuchPlantTypeException;

import java.util.Arrays;

public class ActionFactory {

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
                return new PlantAction(PlantType.valueOf(chosenPlant));
            } else {
                throw new NoSuchPlantTypeException(chosenPlant);
            }
        }
        throw new NoSuchActionException(action);
    }

    private boolean validPlant(String chosenPlant) {
        return Arrays.stream(PlantType.values())
                .anyMatch(plantType -> plantType.name().equals(chosenPlant));
    }
}
