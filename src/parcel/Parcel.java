package parcel;

import actions.Action;
import parcel.plant.Plant;
import parcel.plant.PlantType;
import parcel.soil.Soil;

public class Parcel {
    private Plant plant;
    private final Soil soil;

    public Parcel() {
        this.plant = null;
        this.soil = new Soil();
    }

    public int playNextTurn(Action action) {
        int pointsEarned = 0;
        if (action.isActionPossible(this)) {
            pointsEarned = action.playAction(this);
        }
        if (hasPlant()) {
            plant.grow();
            soil.alterQuality(plant.getNutrientNeedPercentage());
            if (soil.hasBadQuality()) {
                plant.kill();
            }
        }
        return pointsEarned;
    }

    public boolean hasPlant() {
        return plant != null;
    }

    public void removePlant() {
        plant = null;
    }

    public void plant(PlantType plantType) {
        this.plant = new Plant(plantType);
    }

    public void alterSoilQuality(int percentage) {
        soil.alterQuality(percentage);
    }

    public int getPlantValue() {
        return plant.getPlantValue();
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "plant=" + plant +
                ", soil=" + soil +
                '}';
    }
}
