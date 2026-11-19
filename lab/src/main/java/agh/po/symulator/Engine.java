package agh.po.symulator;

public class Engine extends Component {
    int maxRPM;
    int currentRPM;
    final int idleRPM = 800;
    boolean isOn;
    String name;

    public Engine(String maker, String model, String name, int maxRPM){
        super(maker, model);
        this.name = name;
        this.maxRPM = maxRPM;
    }

    public void turnOn(){
        currentRPM = idleRPM;
        isOn = true;
    }

    public void turnOff(){
        currentRPM = 0;
        isOn = false;
    }

    public void increaseRPM(int rpm){
        if(isOn){
            if(rpm < 0){
                throw new IllegalArgumentException("RPM cannot be negative");
            }
            if(currentRPM + rpm <= maxRPM){
                currentRPM += rpm;
            } else {
                currentRPM = maxRPM;
            }
        } else {
            throw new IllegalStateException("Engine is off");
        }
    }

    public void decreaseRPM(int rpm){
        if(isOn){
            if(currentRPM - rpm >= idleRPM){
                currentRPM -= rpm;
            } else {
                currentRPM = idleRPM;
            }
        } else {
            throw new IllegalStateException("Engine is off");
        }
    }

    public int getCurrentRPM(){
        return currentRPM;
    }
}
