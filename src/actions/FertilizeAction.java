package actions;

import parcel.Parcel;

public class FertilizeAction extends Action{
    private static final int DEFAULT_SOIL_QUALITY_INCREASE_PERCENTAGE = 30;

    @Override
    public int playAction(Parcel parcel) {
        parcel.alterSoilQuality(DEFAULT_SOIL_QUALITY_INCREASE_PERCENTAGE);
        return 0;
    }

    @Override
    public boolean isActionPossible(Parcel parcel) {
        return true;
    }
}
