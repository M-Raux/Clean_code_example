package actions;

import parcel.Parcel;
import parcel.plant.PlantType;

public class PlantAction extends Action{
    private final PlantType plantType;

    public PlantAction(PlantType plantType) {
        this.plantType = plantType;
    }

    @Override
    public int playAction(Parcel parcel) {
        parcel.plant(plantType);
        return 0;
    }

    @Override
    public boolean isActionPossible(Parcel parcel) {
        return !parcel.hasPlant();
    }
}
