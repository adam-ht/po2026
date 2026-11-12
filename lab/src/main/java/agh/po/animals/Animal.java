package agh.po.animals;

import java.io.Serial;

public abstract class Animal {
    String name;
    int legs;

    public Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;
    }

    public abstract String getDescription();

    public int getLegs() {
        return legs;
    }

    public void makeSound(){
        System.out.println(name + " makes a sound");
    }
}
