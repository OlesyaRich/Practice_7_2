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
        if (animalsList != null)
            return animalsList.getAnimals();
        return null;
    }
    public void setAnimalsPositions(ArrayList<Item> orderedPositions) {
        if (animalsList == null)
            animalsList = new AnimalsList(new HashMap<Integer, Item>());
        for (Item good : orderedPositions) {
            animalsList.addAnimalToList(good);
        }
    }
    public void putAnimal(Item good) {
        if (animalsList != null)
            animalsList.addAnimalToList(good);
        else {
            animalsList = new AnimalsList(new HashMap<Integer, Item>());
            animalsList.addAnimalToList(good);
        }
    }
    public Item getAnimal(int position) {
        if (animalsList != null)
            return animalsList.getAnimalById(position);
        return null;
    }
}
