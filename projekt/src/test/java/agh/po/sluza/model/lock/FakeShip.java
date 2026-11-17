package agh.po.sluza.model.lock;

import agh.po.sluza.model.ship.Ship;

class FakeShip implements Ship {
    private final int length;
    private final int width;
    private final String description;

    FakeShip(int length, int width, String description) {
        this.length = length;
        this.width = width;
        this.description = description;
    }
    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getWidth() { return width; }

    @Override
    public String getDescription() {
        return description;
    }

}
