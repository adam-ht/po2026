package agh.po.sluza.model.lock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LockPhaseTest {
    private Lock lock;

    @BeforeEach
    void setUp() {
        Gate lowerGate = new Gate(GateSide.LOWER, 2);
        Gate upperGate = new Gate(GateSide.UPPER, 2);
        Chamber chamber = new Chamber(0.0, 4.0, 0.5, 8, 5);
//        lock = new Lock(lowerGate, upperGate, chamber);
    }

    @Test
    void newLockIsIdle() {
//        assertEquals(LockPhase.WAITING, lock.getPhase());
    }
}
