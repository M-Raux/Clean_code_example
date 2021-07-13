package actions;


import parcel.Parcel;

public class HarvestAction extends Action{
    @Override
    public int playAction(Parcel parcel) {
        int pointsGained = parcel.getPlantValue();
        parcel.removePlant();
        return pointsGained;
    }

    @Override
    public boolean isActionPossible(Parcel parcel) {
        return parcel.hasPlant();
    }
}
