package game.parcel;

import game.parcel.plant.Plant;
import game.parcel.plant.PlantType;
import game.parcel.soil.Soil;

public class Parcel {
    private Plant plant;
    private final Soil soil;

    public Parcel() {
        this.plant = null;
        this.soil = new Soil();
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

    public int getPlantValue() {
        return plant.getPlantValue();
    }

    public void playPlantLifecycle() {
        if (soil.hasBadQuality()) {
            plant.kill();
        } else {
            plant.grow();
            soil.alterQuality(-plant.getNutrientNeedPercentage());
        }
    }

    public void alterSoilQuality(int percentage) {
        soil.alterQuality(percentage);
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "plant=" + plant +
                ", soil=" + soil +
                '}';
    }


}
