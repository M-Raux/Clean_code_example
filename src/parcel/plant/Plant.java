package parcel.plant;

public class Plant {
    private int growth;
    private final PlantType plantType;


    public Plant(PlantType plantType) {
        this.plantType = plantType;
        this.growth = 0;
    }

    public void grow() {
        growth++;
    }

    public int getNutrientNeedPercentage() {
        return plantType.getNutrientNeed();
    }

    public void kill() {
        growth = plantType.getLifespan();
    }

    public int getPlantValue() {
        if (isReady()) {
            return plantType.getValue();
        }
        return 0;
    }

    private boolean isReady() {
        return growth >= plantType.getNumberOfTurnToBeReady() && growth < plantType.getLifespan();
    }

    @Override
    public String toString() {
        return "Plant{" +
                "growth=" + growth +
                ", plantType='" + plantType + '\'' +
                '}';
    }
}
