package compare;

import java.util.Comparator;

public class SortSpeciesUsingImplement implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getSpecies().compareTo(o2.getSpecies());
    }
}
