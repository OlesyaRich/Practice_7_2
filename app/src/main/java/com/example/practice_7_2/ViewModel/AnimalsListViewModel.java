package com.example.practice_7_2.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practice_7_2.Data.Model.Item;
import com.example.practice_7_2.Data.Repository.AnimalRepository;
import com.example.practice_7_2.Data.Repository.AnimalsListRepository;

import java.util.ArrayList;

public class AnimalsListViewModel extends ViewModel {
    private final MutableLiveData<AnimalsListRepository> uiState =
            new MutableLiveData(new AnimalsListRepository(null));
    public LiveData<AnimalsListRepository> getUIState() {
        return uiState;
    }

    public void addGoodToOrder(Item item) {
        AnimalsListRepository animalList;
        animalList = uiState.getValue();
        if (animalList != null)
            animalList.putAnimal(item);
        else {
            ArrayList<Item> items = new ArrayList<>();
            items.add(item);
            animalList = new AnimalsListRepository(items);
        }

        uiState.setValue(animalList);
    }
}
