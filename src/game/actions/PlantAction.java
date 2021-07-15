package game.actions;

import game.parcel.Parcel;
import game.parcel.plant.PlantType;

public class PlantAction extends Action{
    private final PlantType plantType;

    public PlantAction(PlantType plantType) {
        this.plantType = plantType;
    }

    @Override
    public int getActionValue(Parcel parcel) {
        return 0;
    }

    @Override
    public void playAction(Parcel parcel) {
        parcel.plant(plantType);
    }

    @Override
    public boolean isActionPossible(Parcel parcel) {
        return !parcel.hasPlant();
    }
}
