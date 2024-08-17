package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import net.penguincoders.WasteMeNot.Adapter.breadAdpter;
import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.ActivitySandwitchBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;

import java.util.ArrayList;

public class SandwitchActivity extends AppCompatActivity {

    ActivitySandwitchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySandwitchBinding.inflate(getLayoutInflater());
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
        items.add(new PopularDemon(R.drawable.sand1, "10", "ZE", "Karantika", "sand1", 10,  "", "\"Date d'expiration:2024/06/19\"","","20DA",""));
        items.add(new PopularDemon(R.drawable.sand2, "20", "gh","Sandwich kabab" , "sand2", 70,  "", "Date d'expiration:2024/06/19","","100DA",""));
        items.add(new PopularDemon(R.drawable.sand3, "30", "CV", "Sandwich kabda", "sand3", 80, "", "\"Date d'expiration:2024/06/22\"","","120DA",""));
        items.add(new PopularDemon(R.drawable.sand4, "40", "DF", "Humburger", "sand4", 100,  "", "\"Date d'expiration:2024/07/10\"","","140DA",""));
        items.add(new PopularDemon(R.drawable.sand5, "50", "ZE","Sandwich chesse" , "sand5", 50,  "","Date d'expiration:2024/07/19","","70DA",""));
        items.add(new PopularDemon(R.drawable.sand6,"60", "LM", "Tacos", "sand6", 200,  "", "Date d'expiration:2024/07/22","","250DA",""));
        binding.recy.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recy.setAdapter(new breadAdpter(items));

    }

}