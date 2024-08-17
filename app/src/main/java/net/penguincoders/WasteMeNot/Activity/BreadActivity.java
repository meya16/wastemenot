package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import net.penguincoders.WasteMeNot.Adapter.breadAdpter;
import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.ActivityBreadBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;

import java.util.ArrayList;


public class BreadActivity extends AppCompatActivity {
    ActivityBreadBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBreadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initRecyclerView();

        binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<PopularDemon> items = new ArrayList<>();
        items.add(new PopularDemon(R.drawable.bread1, "14", "2", "Egg bread", "bread1", 10,  "",  "Date d'expiration:2024/06/19", "", "20DA",""));
        items.add(new PopularDemon(R.drawable.bread2, "24", "8", "Soft bread", "bread2", 15,  "",  "Date d'expiration:2024/06/19", "", "25DA",""));
        items.add(new PopularDemon(R.drawable.bread_3, "34", "5", "French bread", "bread_3", 10,  "", "Date d'expiration:2024/06/22", "", "20DA",""));
        items.add(new PopularDemon(R.drawable.bread4, "44", "9", "Toast", "bread4", 7, "", "Date d'expiration:2024/07/10", "", "14DA",""));
        items.add(new PopularDemon(R.drawable.bread5, "54", "3", "Bread", "bread5", 5, "", "Date d'expiration:2024/07/19", "", "10DA",""));
        items.add(new PopularDemon(R.drawable.bread_6, "99", "4", "Matloue", "bread_6", 5, "",  "Date d'expiration:2024/07/22", "", "10DA",""));

        binding.recy.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recy.setAdapter(new breadAdpter(items));
    }
}
