package actions;

import parcel.Parcel;

public class PlantAction extends Action{
    private final String plantType;

    public PlantAction(String plantType) {
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
