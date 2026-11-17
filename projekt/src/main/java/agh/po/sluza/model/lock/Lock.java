package agh.po.sluza.model.lock;

public class Lock {
    private final Gate upperGate;
    private final Gate lowerGate;
    private final Chamber chamber;
    private LockPhase phase = LockPhase.WAITING;

    public Lock(Gate lower, Gate upper, Chamber chamber) {
        this.upperGate = upper;
        this.lowerGate = lower;
        this.chamber = chamber;
    }

    public Enum<LockPhase> getPhase() {
        return phase;
    }
}
