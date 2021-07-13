public class Parcel {
    private static final int MAX_SOIL_QUALITY = 1000;
    private static final int FERTILIZER_BONUS = 300;
    private static final int NO_PLANT_VALUE = -1;
    private static final int TYPE_A_NUTRIENT_NEED = 10;
    private static final int TYPE_B_NUTRIENT_NEED = 20;
    private static final int TYPE_A_HARVEST_GAIN = 1;
    private static final int TYPE_B_HARVEST_GAIN = 2;
    private static final int PLANT_AGE_TO_BE_READY_TO_HARVEST = 10;
    private static final int PLANT_LIFESPAN = 11;

    public static final int INVALID_PLANT_ERROR = -1;
    public static final int INVALID_ACTION_ERROR = -2;

    private int plantGrowth;
    private String plantType;
    private int soilQuality;

    public Parcel() {
        this.plantGrowth = NO_PLANT_VALUE;
        this.soilQuality = MAX_SOIL_QUALITY;
        this.plantType = "";
    }

    public int playNextTurn(String action) {
        int pointsEarned = 0;
        if (action != null) {
            if (action.equals("FERTILIZE")) {
                soilQuality = Math.min(MAX_SOIL_QUALITY, soilQuality + FERTILIZER_BONUS);
            } else if (action.equals("HARVEST")) {
                if (plantGrowth != NO_PLANT_VALUE) {
                    if (plantGrowth >= PLANT_AGE_TO_BE_READY_TO_HARVEST && plantGrowth < PLANT_LIFESPAN) {
                        if (plantType.equals("A")) {
                            pointsEarned = TYPE_A_HARVEST_GAIN;
                        } else if (plantType.equals("B")) {
                            pointsEarned = TYPE_B_HARVEST_GAIN;
                        }
                    }
                    plantGrowth = NO_PLANT_VALUE;
                }
            } else if (action.startsWith("PLANT")) {
                if (plantGrowth == NO_PLANT_VALUE) {
                    String chosenPlantType = action.substring(5);
                    if (chosenPlantType.equals("A") || chosenPlantType.equals("B")) {
                        plantType = chosenPlantType;
                        plantGrowth = 0;
                    } else {
                        return INVALID_PLANT_ERROR;
                    }
                }
            } else {
                return INVALID_ACTION_ERROR;
            }
        }
        if (plantGrowth >= 0) {
            plantGrowth++;
            if (plantType.equals("A")) {
                soilQuality = Math.max(0, soilQuality - TYPE_A_NUTRIENT_NEED);
            } else if (plantType.equals("B")) {
                soilQuality = Math.max(0, soilQuality - TYPE_B_NUTRIENT_NEED);
            }
            if (soilQuality == 0) {
                plantGrowth = PLANT_LIFESPAN;
            }
        }
        return pointsEarned;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "plantGrowth=" + plantGrowth +
                ", plantType=" + plantType +
                ", soilQuality=" + soilQuality +
                '}';
    }
}
