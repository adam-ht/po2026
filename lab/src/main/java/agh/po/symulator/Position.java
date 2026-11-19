package agh.po.symulator;

import java.util.Arrays;
import java.util.Vector;

public class Position {
    double x;
    double y;

    public Vector<Double> getPos() {
        return new Vector<>(Arrays.asList(x,y));
    }

    public void updatePos(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
    }
}
