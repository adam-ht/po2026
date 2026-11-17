package agh.po.sluza.model.ship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    void oppositeOfUpIsDown() {
        assertEquals(Direction.DOWN, Direction.UP.getOpposite());
    }

    @Test
    void oppositeOfDownIsUp() {
        assertEquals(Direction.UP, Direction.DOWN.getOpposite());
    }
}