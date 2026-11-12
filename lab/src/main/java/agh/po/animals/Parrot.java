package agh.po.animals;

public class Parrot extends Animal {
    public Parrot(String name) {
        super(name, 2);
    }

    @Override
    public String getDescription() {
        return "Parrot with name: " + name + " and " + legs + " legs";
    }

    @Override
    public void makeSound() {
        System.out.println(name + " makes a squawk sound");
    }
}
