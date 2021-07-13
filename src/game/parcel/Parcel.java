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

    public void alterSoilQuality(int percentage) {
        soil.alterQuality(percentage);
    }

    public int getPlantValue() {
        return plant.getPlantValue();
    }

    public void growPlant() {
        if (hasPlant()) {
            plant.grow();
        }
    }

    public void feedPlantWithNutrient() {
        if (hasPlant()){
            if (soil.hasBadQuality()) {
                plant.kill();
            } else {
                soil.alterQuality(-plant.getNutrientNeedPercentage());
            }
        }
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "plant=" + plant +
                ", soil=" + soil +
                '}';
    }
}
