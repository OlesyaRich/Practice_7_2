package com.example.practice_7_2.Data.DataSourse;

import com.example.practice_7_2.Data.Model.Item;

public class CurrentAnimal {
    private final Item[] currentItem = new Item[1];
    public CurrentAnimal (Item animal) {this.currentItem[0] = animal;}
    public Item getCurrentAnimal() {
        return currentItem[0];
    }
    public void SetCurrentAnimal(Item animal) {
        this.currentItem[0] = animal;
    }
}
