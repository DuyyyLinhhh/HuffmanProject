package compare;

import java.util.Comparator;

public class SortIdUsingImplement implements Comparator<Animal> {
    public int compare(Animal o1, Animal o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
