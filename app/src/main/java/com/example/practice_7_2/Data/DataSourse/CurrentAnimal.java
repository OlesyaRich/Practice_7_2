package com.example.practice_7_2.Data.DataSourse;

import com.example.practice_7_2.Data.Model.Item;

public class CurrentAnimal {
    private final Item[] currentItem = new Item[1];
    public CurrentAnimal (Item good) {this.currentItem[0] = good;}

    public Item getCurrentAnimal() {
        return currentItem[0];
    }

    public void SetCurrentAnimal(Item good) {
        this.currentItem[0] = good;
    }
}
