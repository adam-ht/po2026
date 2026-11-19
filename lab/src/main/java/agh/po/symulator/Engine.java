package agh.po.symulator;

public class Engine extends Component {
    int maxRPM;
    int currentRPM;
    final int idleRPM = 800;
    String name;

    public Engine(String maker, String model, String name, int maxRPM){
        super(maker, model);
        this.name = name;
        this.maxRPM = maxRPM;
    }

    public void turnOn(){
        currentRPM = idleRPM;
    }

    public void turnOff(){
        currentRPM = 0;
    }

    public void increaseRPM(int rpm){
        currentRPM += rpm;
    }
}
