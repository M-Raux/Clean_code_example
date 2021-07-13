package game.parcel.soil;

public class Soil {
    private static final int MAX_SOIL_QUALITY = 1000;

    private int quality;

    public Soil() {
        quality = MAX_SOIL_QUALITY;
    }

    public void alterQuality(int percentage) {
        quality = Math.min(MAX_SOIL_QUALITY, Math.max(0, quality + percentage * MAX_SOIL_QUALITY / 100));
    }

    public boolean hasBadQuality() {
        return quality == 0;
    }

    @Override
    public String toString() {
        return "Soil{" +
                "quality=" + quality +
                '}';
    }
}
