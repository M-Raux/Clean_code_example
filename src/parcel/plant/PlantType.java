package parcel.plant;

import lombok.Getter;

public enum PlantType {
    CARROT(1, 10, 14, 10),
    SALAD(2, 10, 14, 20);

    @Getter
    private final int value;
    @Getter
    private final int numberOfTurnToBeReady;
    @Getter
    private final int lifespan;
    @Getter
    private final int nutrientNeed;

    PlantType(int value, int numberOfTurnToBeReady, int lifespan, int nutrientNeed) {
        this.value = value;
        this.lifespan = lifespan;
        this.numberOfTurnToBeReady = numberOfTurnToBeReady;
        this.nutrientNeed = nutrientNeed;
    }
}
