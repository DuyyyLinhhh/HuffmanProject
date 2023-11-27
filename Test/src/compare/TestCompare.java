package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestCompare {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Linh",18));
        list.add(new Person("Tu",19));
        list.add(new Person("Ngoc",32));
        list.add(new Person("Hoa",14));
        list.add(new Person("Nga",23));
        System.out.println("Before sort\n");
        printInfo(list);
        System.out.println("After sort by name\n");
        list.sort(Comparator.comparing(Person :: getName));
        printInfo(list);
        System.out.println();
        System.out.println("After sort by age\n");
        list.sort(Comparator.comparing(Person::getName));
        printInfo(list);


    }

    public static void printInfo(ArrayList<Person> list) {
        for (Person person : list) {
            System.out.println(person);
        }
    }



}
