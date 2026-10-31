package agh.po.sluza.model.lock;

public class Gate {

    private final GateSide side;
    private final int gateTicks;
    private GateState state = GateState.CLOSED;
    private int ticksLeft = 0;

    public Gate(GateSide side, int gateTicks) {
        if (gateTicks <= 0) {
            throw new IllegalArgumentException("Gate ticks must be positive");
        }
        this.side = side;
        this.gateTicks = gateTicks;

    }

    public GateSide getSide() {
        return side;
    }

    public GateState getState() {
        return state;
    }

    public void startOpening() {
        if (state == GateState.CLOSED) {
            state = GateState.OPENING;
            ticksLeft = gateTicks;
        } else {
            throw new IllegalStateException("Gate is not closed");
        }
    }

    public void startClosing() {
        if (state == GateState.OPEN) {
            state = GateState.CLOSING;
            ticksLeft = gateTicks;
        } else {
            throw new IllegalStateException("Gate is not opened");
        }
    }

    public void advance() {
        if (state != GateState.CLOSING && state != GateState.OPENING) {
            return;
        }
        ticksLeft--;
        if (ticksLeft == 0) {
            if (state == GateState.CLOSING) {
                state = GateState.CLOSED;
            } else {
                state = GateState.OPEN;
            }
        }
    }
}