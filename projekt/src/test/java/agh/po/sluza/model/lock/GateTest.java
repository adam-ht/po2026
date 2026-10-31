package agh.po.sluza.model.lock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GateTest {

    @Test
    void newGateIsClosed() {
        Gate gate = new Gate(GateSide.LOWER, 2);

        assertEquals(GateState.CLOSED, gate.getState());
    }

    @Test
    void getSide() {
        Gate gate = new Gate(GateSide.LOWER, 2);
        assertEquals(GateSide.LOWER, gate.getSide());
    }

    @Test
    void startOpeningSetsStateToOpening() {
        Gate gate = new Gate(GateSide.LOWER, 2);

        gate.startOpening();

        assertEquals(GateState.OPENING, gate.getState());
    }

    @Test
    void gateIsOpenAfterGateTicksAdvances() {
        Gate gate = new Gate(GateSide.LOWER, 2);
        gate.startOpening();

        gate.advance();
        assertEquals(GateState.OPENING, gate.getState());

        gate.advance();
        assertEquals(GateState.OPEN, gate.getState());
    }

    @Test
    void gateIsClosedAfterClosing() {
        Gate gate = new Gate(GateSide.LOWER, 2);
        gate.startOpening();
        gate.advance();
        gate.advance();

        gate.startClosing();
        gate.advance();
        gate.advance();

        assertEquals(GateState.CLOSED, gate.getState());
    }

    @Test
    void startOpeningOnOpenGateThrows() {
        Gate gate = new Gate(GateSide.LOWER, 2);
        gate.startOpening();
        gate.advance();
        gate.advance();

        assertThrows(IllegalStateException.class, gate::startOpening);
    }

    @Test
    void constructorRejectsNonPositiveGateTicks() {
        assertThrows(IllegalArgumentException.class, () -> new Gate(GateSide.LOWER, 0));
        assertThrows(IllegalArgumentException.class, () -> new Gate(GateSide.LOWER, -1));
    }
}