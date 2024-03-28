package com.example.practice_7_2.View_UI;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.practice_7_2.R;
import com.example.practice_7_2.ViewModel.AnimalViewModel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnimalViewModel catViewModel = new ViewModelProvider(this).get(AnimalViewModel.class);
    }
}