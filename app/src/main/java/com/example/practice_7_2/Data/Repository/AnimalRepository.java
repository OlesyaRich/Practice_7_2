package com.example.practice_7_2.Data.Repository;

import com.example.practice_7_2.Data.DataSourse.CurrentAnimal;
import com.example.practice_7_2.Data.Model.Item;

public class AnimalRepository {
    private CurrentAnimal currentAnimal;
    private String AnimalName = "test";
    private String AnimalType = "test";
    private String AnimalAge = "0";

    public AnimalRepository() {}
    public AnimalRepository(String AnimalName) {
        this.AnimalName = AnimalName;
        currentAnimal = new CurrentAnimal(new Item(AnimalName, 0));
    }
    public AnimalRepository(String AnimalType, String AnimalName) {
        this.AnimalType = AnimalType;
        this.AnimalName = AnimalName;
        currentAnimal = new CurrentAnimal(new Item(AnimalName, 0));
    }
    public AnimalRepository(String AnimalType, String AnimalName, String AnimalAge) {
        this.AnimalType = AnimalType;
        this.AnimalName = AnimalName;
        this.AnimalAge = AnimalAge;
        currentAnimal = new CurrentAnimal(new Item(AnimalType + " " + AnimalName +
                " " + AnimalAge + " лет", 0));
    }

    public void setAnimalName(String animalName) {
        this.AnimalName = animalName;
        currentAnimal.SetCurrentAnimal(new Item(animalName, 0));
    }
    public void setAnimalType(String animalType) {
        this.AnimalType = animalType;
    }
    public void setAnimalAge(String animalAge) {
        this.AnimalAge = animalAge;
    }

    public String getAnimalName() {
        return AnimalName;
    }
    public String getAnimalType() {
        return AnimalType;
    }
    public String getAnimalAge() {
        return AnimalAge;
    }

    public Item getAnimal(){
        return currentAnimal.getCurrentAnimal();
    }
}
