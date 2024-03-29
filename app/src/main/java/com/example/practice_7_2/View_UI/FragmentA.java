package com.example.practice_7_2.View_UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.practice_7_2.ViewModel.AnimalViewModel;
import com.example.practice_7_2.R;

public class FragmentA extends Fragment {
    public FragmentA() {
        super(R.layout.fragment_a);
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText catType = (EditText) getActivity().findViewById(R.id.e_catType);
        EditText catName = (EditText) getActivity().findViewById(R.id.e_catName);
        EditText catAge = (EditText) getActivity().findViewById(R.id.e_age);

        AnimalViewModel catViewModel = new ViewModelProvider(getActivity()).get(AnimalViewModel.class);
        catViewModel.getUIState().observe(getViewLifecycleOwner(), uiState -> {
            if (uiState.getAnimalName() != null && uiState.getAnimalType() != null && uiState.getAnimalAge() != null) {
                catType.setText(uiState.getAnimalType());
                catName.setText(uiState.getAnimalName());
                catAge.setText(uiState.getAnimalAge());
            }
        });

        Button button_create = requireView().findViewById(R.id.b_create);
        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cat_type = catType.getText().toString();
                String cat_name = catName.getText().toString();
                String cat_age = catAge.getText().toString();

                catViewModel.inputAnimalParameters(cat_type, cat_name, cat_age);
                Navigation.findNavController(view).navigate(R.id.action_AFragment_to_CFragment);
            }
        });

        Button button_create_random = requireView().findViewById(R.id.b_createRandom);
        button_create_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catViewModel.RandomCat();
                Navigation.findNavController(view).navigate(R.id.action_AFragment_to_CFragment);
            }
        });
    }
}
