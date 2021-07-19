package parcel;

import actions.Action;
import parcel.plant.Plant;

public class Parcel {
    private static final int MAX_SOIL_QUALITY = 1000;

    private Plant plant;

    private int soilQuality;

    public Parcel() {
        this.plant = null;
        this.soilQuality = MAX_SOIL_QUALITY;
    }

    public int playNextTurn(Action action) {
        int pointsEarned = 0;
        if (action.isActionPossible(this)) {
            pointsEarned = action.getActionValue(this);
            action.playAction(this);
        }
        if (hasPlant()) {
            playPlantLifecycle();
        }
        return pointsEarned;
    }

    private void playPlantLifecycle() {
        plant.grow();
        alterSoilQualityFromPlant();
        if (soilQuality == 0) {
            plant.kill();
        }
    }

    public void plant(String plantType) {
        this.plant = new Plant(plantType);
    }

    private void alterSoilQualityFromPlant() {
        soilQuality = Math.max(0, soilQuality - plant.getNutrientNeedPercentage() * MAX_SOIL_QUALITY / 100);

    }

    public boolean hasPlant() {
        return plant != null;
    }

    public void removePlant() {
        plant = null;
    }

    public int getPlantValue() {
        return plant.getPlantValue();
    }

    public void increaseSoilQuality(int percentage) {
        soilQuality = Math.min(MAX_SOIL_QUALITY, soilQuality + MAX_SOIL_QUALITY * percentage / 100);
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "plant=" + plant +
                ", soilQuality=" + soilQuality +
                '}';
    }
}
