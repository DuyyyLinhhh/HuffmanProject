package compare;

import java.util.Comparator;

public class NameCompare implements Comparator<Person> {
    @Override
    public int compare(Person left, Person right) {
        return left.getName().compareTo(right.getName());
    }

}
