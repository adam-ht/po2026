package agh.po.symulator;

public class Component {
    String maker;
    String model;

    public Component(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }
}
