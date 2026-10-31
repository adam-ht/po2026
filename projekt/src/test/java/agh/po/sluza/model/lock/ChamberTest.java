package agh.po.sluza.model.lock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChamberTest {
    private Chamber chamber;

    @BeforeEach
    void setUp() {
        chamber = new Chamber(0, 4, 1);
    }

    @Test
    void waterStartsAtLowerLevel() {
        assertEquals(0, chamber.getWaterLevel());
        assertTrue(chamber.isLevelWith(GateSide.LOWER));
        assertFalse(chamber.isLevelWith(GateSide.UPPER));
    }

    @Test
    void fillStepRaisesWaterByRatePerStep() {
        chamber.fillStep();
        chamber.fillStep();
        assertEquals(2, chamber.getWaterLevel());
        assertFalse(chamber.isLevelWith(GateSide.LOWER));
        assertFalse(chamber.isLevelWith(GateSide.UPPER));
    }

    @Test
    void fillingStopsAtUpperLevel() {
        for (int i = 0; i < 10; i++) {
            chamber.fillStep();
        }
        assertEquals(4, chamber.getWaterLevel());
        assertFalse(chamber.isLevelWith(GateSide.LOWER));
        assertTrue(chamber.isLevelWith(GateSide.UPPER));
    }

    @Test
    void drainStepLowersWaterByRatePerStep() {
        for (int i = 0; i < 10; i++) {
            chamber.fillStep();
        }
        assertEquals(4, chamber.getWaterLevel());
        chamber.drainStep();
        assertEquals(3, chamber.getWaterLevel());
        assertFalse(chamber.isLevelWith(GateSide.LOWER));
        assertFalse(chamber.isLevelWith(GateSide.UPPER));
    }

    @Test
    void drainingStopsAtLowerLevel() {
        for (int i = 0; i < 10; i++) {
            chamber.drainStep();
        }
        assertEquals(0, chamber.getWaterLevel());
        assertTrue(chamber.isLevelWith(GateSide.LOWER));
        assertFalse(chamber.isLevelWith(GateSide.UPPER));
    }

    @Test
    void getLevelAtReturnsLevelOfGivenSide() {
        assertEquals(0, chamber.getLevelAt(GateSide.LOWER));
        assertEquals(4, chamber.getLevelAt(GateSide.UPPER));
    }

    @Test
    void constructorRejectsUpperLevelNotAboveLowerLevel() {
        assertThrows(IllegalArgumentException.class, () -> new Chamber(10, 10, 1));
        assertThrows(IllegalArgumentException.class, () -> new Chamber(10, 5, 1));
    }

    @Test
    void constructorRejectsNonPositiveLevelRate() {
        assertThrows(IllegalArgumentException.class, () -> new Chamber(0, 5, 0));
        assertThrows(IllegalArgumentException.class, () -> new Chamber(0, 5, -5));
    }
}
