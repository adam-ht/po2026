package agh.po.symulator;

public class Car {
    Engine engine;
    Gearbox gearbox;
    Position position;
    String maker;
    String model;
    String licensePlate;
    int topSpeed;



    public Car(String maker, String model, Engine engine, Gearbox gearbox, String licensePlate, int topSpeed){
        this.engine = engine;
        this.gearbox = gearbox;
        this.position = new Position();
        this.topSpeed = topSpeed;
        this.licensePlate = licensePlate;
        this.maker = maker;
        this.model = model;
    }

    public void turnOn(){
        engine.turnOn();
    }

    public void turnOff(){
        engine.turnOff();
        gearbox.shiftNeutral();
    }

    public void printInfo(){
        System.out.println("Is on: " + engine.isOn);
        System.out.println("Maker: " + maker);
        System.out.println("Model: " + model);
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Current position: " + position.getPos());
        System.out.println("Current gear: " + gearbox.getCurrentGear());
        System.out.println("Clutch pressed: " + gearbox.clutch.isEngaged());
        System.out.println("Engine RPM: " + engine.getCurrentRPM());

    }

    public static void main(String[] args){
        Engine engine1 = new Engine("", "", "BXW", 6000);
        Clutch clutch1 = new Clutch("", "");
        Gearbox gearbox1 = new Gearbox("ZF", "8HP", 8, clutch1);


        Car car = new Car("Seat", "Ibiza", engine1, gearbox1, "SWD07527", 200);
        car.position.updatePos(5.2 , 4.7);
        car.turnOn();
        car.engine.increaseRPM(2220);
        car.gearbox.shiftUp();
        car.printInfo();

        car.turnOff();
        car.printInfo();
    }
}
