package agh.po.sluza.model.lock;

import agh.po.sluza.model.ship.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockTest {
    private Gate lowerGate;
    private Gate upperGate;
    private Chamber chamber;
    private Lock lock;

    @BeforeEach
    void setUp() {
        lowerGate = new Gate(GateSide.LOWER, 2);
        upperGate = new Gate(GateSide.UPPER, 2);
        chamber = new Chamber(0.0, 4.0, 0.5, 8, 5);
        lock = new Lock(lowerGate, upperGate, chamber);
    }

    @Test
    void constructorRejectsNullArguments() {
        assertThrows(NullPointerException.class, () -> new Lock(null, upperGate, chamber));
        assertThrows(NullPointerException.class, () -> new Lock(lowerGate, null, chamber));
        assertThrows(NullPointerException.class, () -> new Lock(lowerGate, upperGate, null));
    }

    @Test
    void constructorThrowsExceptionOnWrongSides(){
        assertThrows(IllegalArgumentException.class, () -> new Lock(upperGate, lowerGate, chamber));
    }

    @Test
    void newLockIsIdle() {
        assertEquals(LockPhase.WAITING, lock.getPhase());
    }

    @Test
    void startCycleRejectsNullDirection() {
        assertThrows(NullPointerException.class, () -> lock.startCycle(null));
        assertEquals(LockPhase.WAITING, lock.getPhase());
    }

    @Test
    void startCycleBeginsLevelingToEntry() {
        lock.startCycle(Direction.UP);

        assertEquals(LockPhase.LEVELING_TO_ENTRY, lock.getPhase());
        assertTrue(lowerGate.isClosed());
        assertTrue(upperGate.isClosed());
    }

    @Test
    void cannotStartCycleWhileAnotherIsRunning() {
        lock.startCycle(Direction.UP);

        assertThrows(IllegalStateException.class, () -> lock.startCycle(Direction.DOWN));
    }

}
