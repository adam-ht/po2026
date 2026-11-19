package agh.po.symulator;

public class Car {
    Engine engine;
    Gearbox gearbox;
    Clutch clutch;
    Component component;
    Position position;

    public Car(String maker, String model, Engine engine, Gearbox gearbox){
        this.engine = engine;
        this.gearbox = gearbox;
        this.position = new Position();
    }

    public void turnOn(){
        engine.turnOn();
    }

    public void turnOff(){
        engine.turnOff();
    }

    public void clutchIn(){
        clutch.engage();
    }

    public void clutchOut(){
        clutch.disengage();
    }

    public void shiftUp(){
        if(clutch.isEngaged()) {
            gearbox.shiftUp();
        } else {
            throw new RuntimeException("Clutch must be engaged to shift up");
        }
    }

    public void shiftDown(){
        if(clutch.isEngaged()) {
            gearbox.shiftDown();
        } else {
            throw new RuntimeException("Clutch must be engaged to shift down");
        }
    }

    public void printInfo(){
        System.out.println(position.getPos());
        System.out.print(component.getMaker() + " ");
        System.out.println(component.getModel());
        System.out.print(engine.getMaker() + " ");
        System.out.println(engine.getModel());
        System.out.print(gearbox.getMaker()+" ");
        System.out.println(gearbox.getModel());
        System.out.print(gearbox.getCurrentGear());
    }

    public static void main(String[] args){
        Engine engine1 = new Engine("VW", "BXW", "BJT", 6000);
        Clutch clutch1 = new Clutch("", "");
        Gearbox gearbox1 = new Gearbox("ZF", "8HP", 8, clutch1);


        Car car = new Car("Seat", "Ibiza", engine1, gearbox1);
        car.position.getPos();
        car.position.updatePos(5.2 , 4.7);
        car.position.getPos();
        car.turnOn();
        car.engine.increaseRPM(1000);
        car.gearbox.shiftUp();
        car.printInfo();
    }
}
