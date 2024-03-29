package com.example.practice_7_2.Data.Repository;

import com.example.practice_7_2.Data.DataSourse.AnimalsList;
import com.example.practice_7_2.Data.Model.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimalsListRepository {
    AnimalsList animalsList = null;
    public AnimalsListRepository(ArrayList<Item> values) {
        if (values != null) {
            this.animalsList = new AnimalsList(new HashMap<Integer, Item>());
            for (Item good : values) {
                animalsList.addAnimalToList(good);
            }
        }
    }
    public ArrayList<Item> getAnimalsPositions() {
        if (animalsList != null) return animalsList.getAnimals();
        return null;
    }
    public void setAnimalsPositions(ArrayList<Item> orderedPositions) {
        if (animalsList == null)
            animalsList = new AnimalsList(new HashMap<Integer, Item>());
        for (Item animal : orderedPositions) {
            animalsList.addAnimalToList(animal);
        }
    }
    public void putAnimal(Item animal) {
        if (animalsList != null)
            animalsList.addAnimalToList(animal);
        else {
            animalsList = new AnimalsList(new HashMap<Integer, Item>());
            animalsList.addAnimalToList(animal);
        }
    }
    public Item getAnimal(int position) {
        if (animalsList != null)
            return animalsList.getAnimalById(position);
        return null;
    }
}
