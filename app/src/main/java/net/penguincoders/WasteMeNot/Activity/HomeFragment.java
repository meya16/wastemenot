package net.penguincoders.WasteMeNot.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import net.penguincoders.WasteMeNot.Adapter.PopulAdpter;
import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.FragmentHomeBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        Bundle bundle = getArguments();
        if (bundle!= null) {
            String username = bundle.getString("username");

            // Utilisation du nom d'utilisateur récupéré
            binding.homeUsername.setText(username);}

        initRecyclerView();

        setButtonListeners();

        return rootView;
    }


    private void setButtonListeners() {
        binding.notificationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NotificationActivity.class));
            }
        });

        binding.brd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("hello ");
                startActivity(new Intent(getActivity(), BreadActivity.class));
            }
        });

        binding.cak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CakesActivity.class));
            }
        });

        binding.fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MilkActivity.class));
            }
        });

        binding.juc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), JuiesActivity.class));
            }
        });

        binding.veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SandwitchActivity.class));
            }
        });
    }


    private void initRecyclerView() {
        ArrayList<PopularDemon> items = new ArrayList<>();
        items.add(new PopularDemon(R.drawable.choc, "1", "LOV", "Chocolate Cake","choc" ,  200, "Opt for good quality cocoa powder or chocolate bars with a high cocoa content for rich flavor. Keep it at room temperature or in the refrigerator, depending on the recipe and climate conditions.", "Date d'expiration:2024/04/19","-50%","200DA",""));
        items.add(new PopularDemon(R.drawable.salade, "2", "DF", "Salade", "salade",  60, "After washing the ingredients, dry them well and store them in plastic bags or airtight containers in the refrigerator. Avoid leaving the salad out at room temperature for extended periods.", "\"Date d'expiration:2024/04/22\"","-40%","70DA",""));
        items.add(new PopularDemon(R.drawable.sansd, "3", "HJ", "Sandwich kabab", "sansd", 100, "Keep sandwiches refrigerated if they contain perishable ingredients like meats or cheeses. When transporting sandwiches, use insulated containers or ice packs to keep them at a safe temperature.", "\"Date d'expiration:2024/04/19\"","-30%","140DA",""));

        binding.popular.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        binding.popular.setAdapter(new PopulAdpter(items));

    }


}