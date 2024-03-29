package com.example.practice_7_2.Data.DataSourse;

import com.example.practice_7_2.Data.Model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnimalsList {
    private Map<Integer, Item> animals;
    public AnimalsList(Map<Integer, Item> animals) {
        this.animals = animals;
    }
    public ArrayList<Item> getAnimals() {
        return new ArrayList<Item>(animals.values());
    }

    public int addAnimalToList(Item item) {
        if (animals != null) {
            Set<Integer> set = animals.keySet();
            if (set.size() > 0) {
                int maxId = Collections.max(set);
                animals.put(maxId + 1, item);
                return maxId + 1;
            } else {
                int index = 0;
                animals.put(index, item);
                return index;
            }
        } else {
            animals = new HashMap<Integer, Item>();
            int index = 0;
            animals.put(index, item);
            return index;
        }
    }

    public Item getAnimalById(int id) {return animals != null ? animals.get(id) : null;}

    public boolean updateAnimalById(int id, Item animal) {
        if (animals == null || animals.get(id) == null) return false;
        animals.put(id, animal);
        return true;
    }

    public boolean deleteAnimalById(int id) {
        if (animals == null || animals.get(id) == null) return false;
        animals.remove(id);
        return true;
    }
}
