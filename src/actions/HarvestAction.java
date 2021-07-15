package actions;


import parcel.Parcel;

public class HarvestAction extends Action{
    @Override
    public int getActionValue(Parcel parcel) {
        return parcel.getPlantValue();
    }

    @Override
    public void playAction(Parcel parcel) {
        parcel.removePlant();
    }

    @Override
    public boolean isActionPossible(Parcel parcel) {
        return parcel.hasPlant();
    }
}
