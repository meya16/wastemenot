package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import net.penguincoders.WasteMeNot.Adapter.breadAdpter;
import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.ActivityMilkBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;

import java.util.ArrayList;

public class MilkActivity extends AppCompatActivity {
    ActivityMilkBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMilkBinding.inflate(getLayoutInflater());
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
        items.add(new PopularDemon(R.drawable.milk1, "11", "ZE", "Banana Milk", "milk1", 15,  "", "\"Date d'expiration:2024/06/19\"","","20DA",""));
        items.add(new PopularDemon(R.drawable.milk2, "21", "gh","Chocolate Milk" , "milk2", 20,  "", "Date d'expiration:2024/06/19","","25DA",""));
        items.add(new PopularDemon(R.drawable.milk3, "31", "qs", "Coffee Milk", "milk3", 10,  "", "\"Date d'expiration:2024/06/22\"","","20DA",""));
        items.add(new PopularDemon(R.drawable.milk4, "41", "qs", "Strawberry Milk", "milk4", 10,  "", "\"Date d'expiration:2024/07/10\"","","14DA",""));
        items.add(new PopularDemon(R.drawable.milk5, "51", "df","Cappuccino" , "milk5", 5,  "", "Date d'expiration:2024/07/19","","10DA",""));
        items.add(new PopularDemon(R.drawable.milk6,"61", "gh", "Milk with oat", "milk6", 5,  "", "Date d'expiration:2024/07/22","","10DA",""));
        binding.recy.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recy.setAdapter(new breadAdpter(items));
    }
}