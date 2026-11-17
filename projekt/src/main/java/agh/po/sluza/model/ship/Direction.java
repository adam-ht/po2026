package agh.po.sluza.model.ship;

public enum Direction {
    UP,
    DOWN;

    public Direction getOpposite(){
        if(this == UP){
            return DOWN;
        }
        return UP;
    }
}

