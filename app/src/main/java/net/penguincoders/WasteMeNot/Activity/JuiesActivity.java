package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import net.penguincoders.WasteMeNot.Adapter.breadAdpter;
import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.ActivityJuiesBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;

import java.util.ArrayList;

public class JuiesActivity extends AppCompatActivity {
    ActivityJuiesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityJuiesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initRecylerView();
        binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void initRecylerView() {
        ArrayList<PopularDemon> items = new ArrayList<>();
        items.add(new PopularDemon(R.drawable.jus1, "12", "ZE", "Juice kiwi", "jus1", 10,  "", "\"Date d'expiration:2024/06/19\"","","20DA",""));
        items.add(new PopularDemon(R.drawable.jus2, "22", "gh","Juice appel" , "jus2", 20,  "", "Date d'expiration:2024/06/19","","25DA",""));
        items.add(new PopularDemon(R.drawable.jus3, "32", "GH", "Juice mangue", "jus3", 10,  "", "\"Date d'expiration:2024/06/22\"","","20DA",""));
        items.add(new PopularDemon(R.drawable.jus4, "42", "JJ", "Juice D'ananas", "jus4", 8,  "", "\"Date d'expiration:2024/07/10\"","","14DA",""));
        items.add(new PopularDemon(R.drawable.jus5, "52", "KL","Juice D'orange " , "jus5", 5,  "", "Date d'expiration:2024/07/19","","10DA",""));
        items.add(new PopularDemon(R.drawable.jus6,"62", "IO", "Juice Lemon", "jus6", 5,  "", "Date d'expiration:2024/07/22","","10DA",""));
        binding.recy.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recy.setAdapter(new breadAdpter(items));

    }
}