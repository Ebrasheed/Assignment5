package adoptme.adapter;

import adoptme.model.ExoticAnimal;
import adoptme.model.Pet;

/**
 * Adapts ExoticAnimal to behave like a Pet.
 */
public class ExoticPetAdapter extends Pet {
    private ExoticAnimal exotic;

    public ExoticPetAdapter(ExoticAnimal exotic) {
        super(0, exotic.getAnimalName(), exotic.getCategory(), exotic.getSubSpecies(), exotic.getYearsOld(), false);
        this.exotic = exotic;
    }
}