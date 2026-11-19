package agh.po.symulator;

public class Clutch extends Component {
    boolean engaged;

    public Clutch(String maker, String model) {
        super(maker, model);
    }

    public void engage(){
        engaged = true;
    }

    public void disengage(){
        engaged = false;
    }

    public boolean isEngaged(){
        return engaged;
    }
}
