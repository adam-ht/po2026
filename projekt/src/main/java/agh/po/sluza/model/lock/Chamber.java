package agh.po.sluza.model.lock;

public class Chamber {
    private final double lowerLevel;
    private final double upperLevel;
    private final double levelRatePerTick;
    private double waterLevel;

    public Chamber(double lowerLevel, double upperLevel, double levelRatePerTick) {
        if (levelRatePerTick <= 0) {
            throw new IllegalArgumentException("Level rate per tick must be positive");
        }
        if (upperLevel <= lowerLevel) {
            throw new IllegalArgumentException("Upper level must be lower than lower level");
        }
        this.lowerLevel = lowerLevel;
        this.waterLevel = lowerLevel;
        this.upperLevel = upperLevel;
        this.levelRatePerTick = levelRatePerTick;
    }

    public void fillStep() {
        waterLevel += levelRatePerTick;
        if (waterLevel > upperLevel) {
            waterLevel = upperLevel;
        }
    }

    public void drainStep() {
        waterLevel -= levelRatePerTick;
        if (waterLevel < lowerLevel) {
            waterLevel = lowerLevel;
        }
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public double getLevelAt(GateSide gateSide) {
        if(gateSide == GateSide.LOWER) {
            return lowerLevel;
        }
        return upperLevel;
    }

    public boolean isLevelWith(GateSide gateSide){
        return getLevelAt(gateSide) == waterLevel;
    }
}
