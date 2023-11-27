package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestSortAnimal {
    public static void main(String[] args) {
        SortIdUsingImplement sortID = new SortIdUsingImplement();
        SortSpeciesUsingImplement sortSp = new SortSpeciesUsingImplement();
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Chicken",11));
        animals.add(new Animal("Duck",9));
        animals.add(new Animal("Dog",5));
        animals.add(new Animal("Cat",4));
        animals.add(new Animal("Elephant",8));
        animals.add(new Animal("Tiger",7));
        animals.add(new Animal("Buffalo",10));
        animals.add(new Animal("Pig",23));
        animals.add(new Animal("Wolf",13));
        animals.add(new Animal("Lion",15));
        animals.add(new Animal("Mosquito",20));
        System.out.println("Before sort \n");
        printInfo(animals);
//        animals.sort(Comparator.comparing(Animal::getId));
        animals.sort(Comparator.comparing(Animal :: getSpecies));
        System.out.println("After sort\n");
        printInfo(animals);
    }

    public static void printInfo(ArrayList<Animal> list) {
        for (Animal animal : list) {
            System.out.println(animal);
        }
    }
}
