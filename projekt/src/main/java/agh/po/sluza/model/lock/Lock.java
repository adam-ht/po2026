package agh.po.sluza.model.lock;

import agh.po.sluza.model.ship.Direction;

import java.util.Objects;

public class Lock {
    private final Gate upperGate;
    private final Gate lowerGate;
    private final Chamber chamber;
    private LockPhase phase = LockPhase.WAITING;
    private Direction currentDirection;

    public Lock(Gate lower, Gate upper, Chamber chamber) {
        this.lowerGate = Objects.requireNonNull(lower);
        this.upperGate = Objects.requireNonNull(upper);
        this.chamber = Objects.requireNonNull(chamber);

        if(lower.getSide() != GateSide.LOWER || upper.getSide() != GateSide.UPPER){
            throw new IllegalArgumentException();
        }
    }

    public LockPhase getPhase() {
        return phase;
    }

    private Gate entryGate() {
        if(currentDirection == Direction.UP){
            return lowerGate;
        }
        return upperGate;
    }

    private Gate exitGate() {
        if(currentDirection == Direction.UP){
            return upperGate;
        }
        return lowerGate;
    }

    public void startCycle(Direction direction){
        if(phase != LockPhase.WAITING){
            throw new IllegalStateException("Gate is not ready to startCycle");
        }
        this.currentDirection = Objects.requireNonNull(direction);
        this.phase = LockPhase.LEVELING_TO_ENTRY;
    }
}
