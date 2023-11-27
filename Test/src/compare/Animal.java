package compare;

public class Animal {
    private String species;
    private int id;

    public Animal(String species, int id) {
        this.species = species;
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Animal["+ species  + " - " + id + ']';
    }
}
