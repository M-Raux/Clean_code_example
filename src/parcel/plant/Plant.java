package parcel.plant;

public class Plant {
    private static final int TYPE_A_NUTRIENT_NEED_PERCENTAGE = 1;
    private static final int TYPE_B_NUTRIENT_NEED_PERCENTAGE = 2;
    private static final int TYPE_A_HARVEST_GAIN = 1;
    private static final int TYPE_B_HARVEST_GAIN = 2;
    private static final int PLANT_AGE_TO_BE_READY_TO_HARVEST = 10;
    private static final int PLANT_LIFESPAN = 14;

    private int growth;
    private final String plantType;

    public Plant(String plantType) {
        this.plantType = plantType;
        this.growth = 0;
    }

    public void grow() {
        growth++;
    }

    public int getNutrientNeedPercentage() {
        if (plantType.equals("A")) {
            return TYPE_A_NUTRIENT_NEED_PERCENTAGE;
        } else if (plantType.equals("B")) {
            return TYPE_B_NUTRIENT_NEED_PERCENTAGE;
        }
        return 0;
    }

    public void kill() {
        growth = PLANT_LIFESPAN;
    }

    public int getPlantValue() {
        int plantValue = 0;
        if (isReady()) {
            if (plantType.equals("A")) {
                plantValue = TYPE_A_HARVEST_GAIN;
            } else if (plantType.equals("B")) {
                plantValue = TYPE_B_HARVEST_GAIN;
            }
        }
        return plantValue;
    }

    private boolean isReady() {
        return growth >= PLANT_AGE_TO_BE_READY_TO_HARVEST && growth < PLANT_LIFESPAN;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "growth=" + growth +
                ", plantType='" + plantType + '\'' +
                '}';
    }
}
