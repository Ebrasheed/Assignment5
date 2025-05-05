package adpotme.controller;

import adoptme.model.*;
import adoptme.adapter.ExoticPetAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Controls loading, saving, and managing pets.
 */
public class PetController {
    private Shelter<Pet> shelter;

    public PetController(Shelter<Pet> shelter) {
        this.shelter = shelter;
    }

    public void loadPets(InputStream jsonStream) throws IOException {
        Gson gson = new Gson();
        Type petListType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        List<Map<String, Object>> data = gson.fromJson(new InputStreamReader(jsonStream), petListType);
        for (Map<String, Object> map : data) {
            String type = (String) map.get("type");
            int id = ((Double) map.get("id")).intValue();
            String name = (String) map.get("name");
            String species = (String) map.get("species");
            int age = ((Double) map.get("age")).intValue();
            boolean adopted = (boolean) map.get("adopted");

            Pet pet = null;
            if ("Dog".equalsIgnoreCase(type)) {
                pet = new Dog(id, name, species, age, adopted);
            } else if ("Cat".equalsIgnoreCase(type)) {
                pet = new Cat(id, name, species, age, adopted);
            } else if ("Rabbit".equalsIgnoreCase(type)) {
                pet = new Rabbit(id, name, species, age, adopted);
            }

            if (pet != null) {
                shelter.addPet(pet);
            }
        }
    }

    public void loadExotics(InputStream jsonStream) throws IOException {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<ExoticAnimal>>(){}.getType();
        List<ExoticAnimal> list = gson.fromJson(new InputStreamReader(jsonStream), listType);
        for (ExoticAnimal exotic : list) {
            shelter.addPet(new ExoticPetAdapter(exotic));
        }
    }

    public void savePets(File file) throws IOException {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(shelter.getAllPets(), writer);
        }
    }

    public void adoptPet(int id) {
        Pet pet = shelter.getPetById(id);
        if (pet != null && !pet.isAdopted()) pet.adopt();
    }

    public Shelter<Pet> getShelter() {
        return shelter;
    }
}
