package com.example.practice_7_2.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practice_7_2.Data.Repository.AnimalRepository;

import java.util.Random;

public class AnimalViewModel extends ViewModel {
    String[] catNames = {"Барсик", "Месси", "Ива", "Луна", "Герда", "Цезарь"};
    String[] catTypes = {"Ирбис", "Леопард", "Рысь", "Пума", "Тигр", "Лев", "Пантера", "Гепард"};

    private final MutableLiveData<AnimalRepository> uiState =
            new MutableLiveData(new AnimalRepository(null, null, null));
    public LiveData<AnimalRepository> getUIState() {
        return uiState;
    }

    public void inputAnimalParameters(String AnimalName, String AnimalType, String AnimalAge){
        uiState.setValue(
                new AnimalRepository(AnimalName, AnimalType, AnimalAge)
        );
    }

    public void RandomCat() {
        Random random = new Random();
        uiState.setValue(
                new AnimalRepository(
                        catTypes[random.nextInt(8)],
                        catNames[random.nextInt(6)],
                        String.valueOf(random.nextInt(20))
                )
        );
    }
}
