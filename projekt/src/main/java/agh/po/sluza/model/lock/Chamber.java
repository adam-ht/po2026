package agh.po.sluza.model.lock;

import agh.po.sluza.model.ship.Ship;

import java.util.ArrayList;
import java.util.List;

public class Chamber {
    private final double lowerLevel;
    private final double upperLevel;
    private final double levelRatePerTick;
    private final int capacity;
    private double waterLevel;

    private final List<Ship> occupants = new ArrayList<>(); // Lista statków znajdujących się w komorze

    public Chamber(double lowerLevel, double upperLevel, double levelRatePerTick, int capacity) {
        if (levelRatePerTick <= 0) {
            throw new IllegalArgumentException("Level rate per tick must be positive");
        }
        if (upperLevel <= lowerLevel) {
            throw new IllegalArgumentException("Upper level must be higher than lower level");
        }
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
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

    public int getCapacity() {
        return capacity;
    }

    public int getUsedCapacity() {
        int usedCapacity = 0;
        for(Ship ship:occupants){
            usedCapacity += ship.getLength();
        }
        return usedCapacity;
    }

    public int getRemainingCapacity() {
        return capacity - getUsedCapacity();
    }

    public boolean isEmpty(){
        return occupants.isEmpty();
    }

    public void add(Ship ship) {
        if(ship.getLength() > getRemainingCapacity()) {
            throw new IllegalStateException("Ship is too long for chamber");
        }
        occupants.add(ship);
    }

    public Ship removeNext() {
        if(isEmpty()) {
            throw new IllegalStateException("Chamber is empty");
        }

        return occupants.removeFirst();
    }

    public List<String> getOccupantDescriptions() {
        List<String> descriptions = new ArrayList<>();
        for(Ship ship : occupants) {
            descriptions.add(ship.getDescription());
        }
        return descriptions;
    }
}
