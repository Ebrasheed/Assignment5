package adoptme.adapter;

/**
 * Represents third-party exotic animal format (not a Pet).
 */
public class ExoticAnimal {
    private String uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private int yearsOld;

    public String getUniqueId() { return uniqueId; }
    public String getAnimalName() { return animalName; }
    public String getCategory() { return category; }
    public String getSubSpecies() { return subSpecies; }
    public int getYearsOld() { return yearsOld; }
}
