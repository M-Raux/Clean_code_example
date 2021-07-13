package parcel;

import actions.Action;

public class Parcel {
    private static final int MAX_SOIL_QUALITY = 1000;
    private static final int NO_PLANT_VALUE = -1;
    private static final int TYPE_A_NUTRIENT_NEED = 10;
    private static final int TYPE_B_NUTRIENT_NEED = 20;
    private static final int TYPE_A_HARVEST_GAIN = 1;
    private static final int TYPE_B_HARVEST_GAIN = 2;
    private static final int PLANT_AGE_TO_BE_READY_TO_HARVEST = 10;
    private static final int PLANT_LIFESPAN = 11;

    private int plantGrowth;
    private String plantType;

    private int soilQuality;

    public Parcel() {
        this.plantGrowth = -1;
        this.soilQuality = MAX_SOIL_QUALITY;
    }

    public int playNextTurn(Action action) {
        int pointsEarned = 0;
        if (action.isActionPossible(this)) {
            pointsEarned = action.playAction(this);
        }
        if (hasPlant()) {
            growPlant();
            alterSoilQualityFromPlant();
        }
        return pointsEarned;
    }

    public void plant(String plantType) {
        this.plantType = plantType;
        plantGrowth = 0;
    }

    private void alterSoilQualityFromPlant() {
        if (plantType.equals("A")) {
            soilQuality = Math.max(0, soilQuality - TYPE_A_NUTRIENT_NEED);
        } else if (plantType.equals("B")) {
            soilQuality = Math.max(0, soilQuality - TYPE_B_NUTRIENT_NEED);
        }
        if (soilQuality == 0) {
            killPlant();
        }
    }

    private void growPlant() {
        plantGrowth++;
    }

    private void killPlant() {
        plantGrowth = 110;
    }

    public int getPlantValue() {
        int plantValue = 0;
        if (plantIsReady()) {
            if (plantType.equals("A")) {
                plantValue = TYPE_A_HARVEST_GAIN;
            } else if (plantType.equals("B")) {
                plantValue = TYPE_B_HARVEST_GAIN;
            }
        }
        return plantValue;
    }

    private boolean plantIsReady() {
        return plantGrowth >= PLANT_AGE_TO_BE_READY_TO_HARVEST && plantGrowth <= PLANT_LIFESPAN;
    }

    public boolean hasPlant() {
        return plantGrowth != NO_PLANT_VALUE;
    }

    public void removePlant() {
        plantGrowth = NO_PLANT_VALUE;
    }

    public void increaseSoilQuality(int percentage) {
        soilQuality = Math.min(MAX_SOIL_QUALITY, soilQuality + MAX_SOIL_QUALITY * percentage / 100);
    }

    @Override
    public String toString() {
        return "parcel.Parcel{" +
                "plantGrowth=" + plantGrowth +
                ", plantType=" + plantType +
                ", soilQuality=" + soilQuality +
                '}';
    }
}
