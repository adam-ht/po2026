package agh.po.sluza.model.lock;

import agh.po.sluza.model.ship.Ship;

class FakeShip implements Ship {
    private final int length;
    private final String description;

    FakeShip(int length, String description) {
        this.length = length;
        this.description = description;
    }
    @Override
    public int getLength() {
        return length;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
