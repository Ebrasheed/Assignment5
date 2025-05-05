package adoptme.model;

/**
 * Abstract base class for all pets.
 */
public abstract class Pet implements Comparable<Pet> {
    protected int id;
    protected String name;
    protected String type;
    protected String species;
    protected int age;
    protected boolean adopted;

    public Pet(int id, String name, String type, String species, int age, boolean adopted) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.species = species;
        this.age = age;
        this.adopted = adopted;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public boolean isAdopted() { return adopted; }
    public void adopt() { this.adopted = true; }

    @Override
    public int compareTo(Pet other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + type + ", " + species + ", age " + age + ")" + (adopted ? " [ADOPTED]" : "");
    }
}