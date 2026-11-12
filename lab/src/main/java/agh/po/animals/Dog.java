package agh.po.animals;

public class Dog extends Animal {
    public Dog(String name) {
        super(name, 4);
    }

    @Override
    public String getDescription() {
        return "Dog with name: " + name + " and " + legs + " legs";
    }

    @Override
    public void makeSound() {
        System.out.println(name + " makes a Woof Woof sound");
    }
}
