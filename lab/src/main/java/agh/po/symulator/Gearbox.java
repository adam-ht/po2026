package agh.po.symulator;

public class Gearbox extends Component {
    int currentGear;
    int numberOfGears;
    Clutch clutch;

    public Gearbox(String maker, String model, int numberOfGears, Clutch clutch) {
        super(maker, model);
        this.numberOfGears = numberOfGears;
        this.currentGear = 0;
        this.clutch = clutch;
    }

    void shiftUp() {
        if (currentGear < numberOfGears) {
            currentGear++;
        }
    }

    void shiftDown(){
        if (currentGear > 0) {
            currentGear--;
        }
    }

    public int getCurrentGear() {
        return currentGear;
    }
}
