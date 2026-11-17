package agh.po.sluza.model.lock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChamberTest {
    private Chamber chamber;

    @BeforeEach
    void setUp() {
        chamber = new Chamber(0, 4, 1, 5, 15);
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
        assertThrows(IllegalArgumentException.class, () -> new Chamber(10, 10, 1, 5, 15));
        assertThrows(IllegalArgumentException.class, () -> new Chamber(10, 5, 1, 5, 15));
    }

    @Test
    void constructorRejectsNonPositiveLevelRate() {
        assertThrows(IllegalArgumentException.class, () -> new Chamber(0, 5, 0, 5, 15));
        assertThrows(IllegalArgumentException.class, () -> new Chamber(0, 5, -5, 5, 15));
    }

    // Tests for ships
    @Test
    void newChamberIsEmptyWithFullCapacity() {
        assertTrue(chamber.isEmpty());
        assertEquals(0, chamber.getUsedCapacity());
        assertEquals(5, chamber.getRemainingCapacity());
    }

    @Test
    void addingShipsIncreasesUsedCapacity() {
        chamber.add(new FakeShip(2, 5, "Fake ship A"));
        chamber.add(new FakeShip(2, 5, "Fake ship B"));
        assertFalse(chamber.isEmpty());
        assertEquals(4, chamber.getUsedCapacity());
        assertEquals(1, chamber.getRemainingCapacity());
    }

    @Test
    void shipFillingRemainingSpaceExactlyIsAccepted() {
        chamber.add(new FakeShip(2, 5, "Fake ship A"));
        chamber.add(new FakeShip(2, 5, "Fake ship B"));
        chamber.add(new FakeShip(1, 5, "Fake ship C"));
        assertEquals(5, chamber.getUsedCapacity());
        assertEquals(0, chamber.getRemainingCapacity());
    }

    @Test
    void addShipThrowsExceptionIfShipIsTooLong() {
        assertThrows(IllegalStateException.class, () -> chamber.add(new FakeShip(6, 5, "Fake ship")));
        assertEquals(5, chamber.getRemainingCapacity());
        assertEquals(0, chamber.getUsedCapacity());
    }

    @Test
    void addShipThrowsExceptionWhenNotEnoughSpace() {
        chamber.add(new FakeShip(2, 5, "Fake ship A"));
        chamber.add(new FakeShip(2, 5, "Fake ship B"));
        assertThrows(IllegalStateException.class, () -> chamber.add(new FakeShip(2, 5, "Fake ship D")));
        assertEquals(4, chamber.getUsedCapacity());
    }

    @Test
    void removeNextReturnsInBoardingOrder() {
        FakeShip shipA = new FakeShip(2, 5, "Fake ship A");
        FakeShip shipB = new FakeShip(2, 5, "Fake ship B");
        FakeShip shipC = new FakeShip(1, 5, "Fake ship C");
        chamber.add(shipA);
        chamber.add(shipB);
        chamber.add(shipC);
        assertSame(shipA, chamber.removeNext());
        assertSame(shipB, chamber.removeNext());
        assertSame(shipC, chamber.removeNext());
        assertTrue(chamber.isEmpty());
    }

    @Test
    void removeNextFreesSpace() {
        chamber.add(new FakeShip(2, 5, "Fake ship A"));
        chamber.add(new FakeShip(2, 5, "Fake ship B"));
        chamber.removeNext();
        assertEquals(3, chamber.getRemainingCapacity());
        assertEquals(2, chamber.getUsedCapacity());
    }

    @Test
    void removeShipThrowsExceptionIfNoShipsInChamber() {
        assertThrows(IllegalStateException.class, () -> chamber.removeNext());
    }

    @Test
    void getOccupantDescriptionsReturnsListInAddOrder() {
        chamber.add(new FakeShip(2, 5, "Fake ship A"));
        chamber.add(new FakeShip(2, 5, "Fake ship B"));
        chamber.add(new FakeShip(1, 5, "Fake ship C"));
        assertEquals(List.of("Fake ship A", "Fake ship B", "Fake ship C"), chamber.getOccupantDescriptions());
    }

    @Test
    void modifyingReturnDoesntInterfereWithChamber() {
        chamber.add(new FakeShip(2, 5, "Fake ship A"));
        chamber.add(new FakeShip(2, 5, "Fake ship B"));
        chamber.add(new FakeShip(1, 5, "Fake ship C"));
        chamber.getOccupantDescriptions().clear();
        assertEquals(List.of("Fake ship A", "Fake ship B", "Fake ship C"), chamber.getOccupantDescriptions());
        assertFalse(chamber.isEmpty());
    }

    @Test
    void ConstructorRejectsCapacityLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> new Chamber(0,5,1,0, 15));
        assertThrows(IllegalArgumentException.class, () -> new Chamber(0,5,1,-1, 15));
    }

    @Test
    void addThrowsExceptionIfShipTooWide(){
        assertThrows(IllegalStateException.class, () -> chamber.add(new FakeShip(4, 20, "Fake ship A")));
    }
}
