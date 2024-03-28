package com.example.practice_7_2.View_UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.practice_7_2.R;
import com.example.practice_7_2.ViewModel.AnimalViewModel;
import com.example.practice_7_2.ViewModel.AnimalsListViewModel;

import java.util.Objects;

public class FragmentC extends Fragment {
    public FragmentC() {
        super(R.layout.fragment_c);
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView catType = (TextView) getActivity().findViewById(R.id.t_type);
        TextView catName = (TextView) getActivity().findViewById(R.id.t_name);
        TextView catAge = (TextView) getActivity().findViewById(R.id.t_age);

        AnimalViewModel catViewModel = new ViewModelProvider(getActivity()).get(AnimalViewModel.class);
        catViewModel.getUIState().observe(getViewLifecycleOwner(), uiState -> {
            catType.setText("Тип: " + uiState.getAnimalType());
            catName.setText("Имя: " + uiState.getAnimalName());
            catAge.setText("Возраст: " + uiState.getAnimalAge());
        });

        Button button_recreate_random = requireView().findViewById(R.id.b_recreateRandom);
        button_recreate_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catViewModel.RandomCat();
            }
        });

        Button button_return = requireView().findViewById(R.id.b_return);
        button_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_CFragment_to_AFragment);
            }
        });

//        AnimalViewModel animalViewModel = new ViewModelProvider(getActivity()).get(AnimalViewModel.class);
        AnimalsListViewModel animalsListViewModel = new ViewModelProvider(getActivity()).get(AnimalsListViewModel.class);
        Button button_addToList = requireView().findViewById(R.id.b_addToList);
        button_addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animalsListViewModel.addGoodToOrder(Objects.requireNonNull(catViewModel.getUIState().getValue()).getAnimal());
                catViewModel.inputAnimalParameters(null, null, null);

                Navigation.findNavController(view).navigate(R.id.action_CFragment_to_FragmentList);
            }
        });

        //animal = (AnimalUIState) getArguments().getSerializable("Animal");

        /*TextView catName = requireView().findViewById(R.id.t_name);
        String cat_Name = "Имя: " + animal.getAnimalName();
        catName.setText(cat_Name);

        TextView catType = requireView().findViewById(R.id.t_type);
        String cat_Type = "Тип: " + animal.getAnimalType();
        catType.setText(cat_Type);

        TextView catAge = requireView().findViewById(R.id.t_age);
        catAge.setText("Возраст: " + animal.getAnimalAge() + " лет");*/
    }
}
