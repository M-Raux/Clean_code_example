package actions;

import parcel.Parcel;

public class FertilizeAction extends Action{
    private static final int DEFAULT_SOIL_QUALITY_INCREASE_PERCENTAGE = 30;

    @Override
    public int getActionValue(Parcel parcel) {
        return 0;
    }

    @Override
    public void playAction(Parcel parcel) {
        parcel.increaseSoilQuality(DEFAULT_SOIL_QUALITY_INCREASE_PERCENTAGE);
    }

    @Override
    public boolean isActionPossible(Parcel parcel) {
        return true;
    }
}
