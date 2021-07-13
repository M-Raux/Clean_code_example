package actions;

import parcel.Parcel;

public class PlantAction extends Action{
    private final String plantType;

    public PlantAction(String plantType) {
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
