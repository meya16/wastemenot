package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import net.penguincoders.WasteMeNot.databinding.ActivityMescoomandeBinding;

public class MescoomandeActivity extends AppCompatActivity {

    ActivityMescoomandeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMescoomandeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}