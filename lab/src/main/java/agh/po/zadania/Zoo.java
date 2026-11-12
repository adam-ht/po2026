package agh.po.zadania;

import agh.po.animals.Animal;
import agh.po.animals.Dog;
import agh.po.animals.Parrot;
import agh.po.animals.Snake;

import java.util.Random;

public class Zoo {
    private final Animal[] animals = new Animal[100];

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.fillZoo();
        System.out.println(zoo.getAnimalsLegs());
        zoo.runZoo();
    }

    public void fillZoo() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int animalType = rand.nextInt(3);
            switch (animalType){
                case 0:
                    animals[i] = new Dog("Dog #" + i);
                    break;
                case 1:
                    animals[i] = new Snake("Snake #" + i);
                    break;
                case 2:
                    animals[i] = new Parrot("Parrot #" + i);
                    break;
            }
        }
    }

    public int getAnimalsLegs() {
        int legs = 0;
        for (Animal animal : animals) {
            legs += animal.getLegs();
        }
        return legs;
    }

    public void runZoo() {
        for(Animal animal:animals){
            String descr = animal.getDescription();
            System.out.println(descr);
            animal.makeSound();
        }
    }
}
