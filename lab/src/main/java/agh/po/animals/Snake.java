package agh.po.animals;

public class Snake extends Animal {
    public Snake(String name) {
        super(name, 0);
    }

    @Override
    public String getDescription() {
        return "Snake with name: " + name + " and " + legs + " legs";
    }

    @Override
    public void makeSound() {
        System.out.println(name + " makes a SSSS sound");
    }
}
