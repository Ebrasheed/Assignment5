package adoptme.model;

import java.util.*;

/**
 * Generic class to store and manage pets.
 */
public class Shelter<T extends Pet> {
    private List<T> pets = new ArrayList<>();

    public void addPet(T pet) {
        pets.add(pet);
    }

    public void removePet(T pet) {
        pets.remove(pet);
    }

    public List<T> getAllPets() {
        return pets;
    }

    public void sortByName() {
        Collections.sort(pets);
    }

    public void sortByAge() {
        pets.sort(Comparator.comparingInt(Pet::getAge));
    }

    public void sortBySpecies() {
        pets.sort(Comparator.comparing(Pet::getSpecies));
    }

    public T getPetById(int id) {
        for (T pet : pets) {
            if (pet.getId() == id) return pet;
        }
        return null;
    }
}