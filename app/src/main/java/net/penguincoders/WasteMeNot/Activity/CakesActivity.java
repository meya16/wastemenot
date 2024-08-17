package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import net.penguincoders.WasteMeNot.Adapter.breadAdpter;
import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.ActivityCakesBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;

import java.util.ArrayList;

public class CakesActivity extends AppCompatActivity {
    ActivityCakesBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityCakesBinding.inflate(getLayoutInflater());
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
        items.add(new PopularDemon(R.drawable.cake1, "18", "ZE", "Cake Fruits", "cake1", 90,  "", "\"Date d'expiration:2024/06/19\"","","100DA",""));
        items.add(new PopularDemon(R.drawable.cake2, "28", "gh","Cake" , "cake2", 70,  "", "Date d'expiration:2024/06/19","","90DA",""));
        items.add(new PopularDemon(R.drawable.milk3, "38", "FG", "Cake Fruits", "cake3", 100, "", "\"Date d'expiration:2024/06/22\"","","150DA",""));
        items.add(new PopularDemon(R.drawable.milk4, "48", "GH", "Cake Vannilla", "cake4", 200,  "", "\"Date d'expiration:2024/07/10\"","","250DA",""));
        items.add(new PopularDemon(R.drawable.milk5, "58", "IK","Cake Caramel" , "cake5", 200,  "", "Date d'expiration:2024/07/19","","300DA",""));
        items.add(new PopularDemon(R.drawable.milk6, "68", "IO", "Chocolat Cake", "cake6", 100,  "", "Date d'expiration:2024/07/22","","150DA",""));
        binding.recy.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recy.setAdapter(new breadAdpter(items));

    }
}
