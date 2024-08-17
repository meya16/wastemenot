package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import net.penguincoders.WasteMeNot.Adapter.Newadpter;
import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.FragmentNewBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;

import java.util.ArrayList;

public class NewFragment extends Fragment {

    private FragmentNewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        initRecyclerView();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void initRecyclerView() {
        ArrayList<PopularDemon> items = new ArrayList<>();
        items.add(new PopularDemon(R.drawable.choc, "45", "LOV", "Cake With Fruits","cake" ,  70, "Cake with fruits:strawberry,banana,kiwi,mangue", "Date d'expiration:2024/04/19","","",""));
        items.add(new PopularDemon(R.drawable.salade, "89", "DF", "cake", "cake22_",  60, "After washing the ingredients, dry them well and store them in plastic bags or airtight containers in the refrigerator.", "\"Date d'expiration:2024/04/22\"","","",""));
        items.add(new PopularDemon(R.drawable.sansd, "68", "HJ", "Mamzouj", "milk7", 8, "Use insulated containers or ice packs to keep them at a safe temperature.", "\"Date d'expiration:2024/04/19\"","","",""));
        items.add(new PopularDemon(R.drawable.sansd, "69", "HJ", "Toast", "bread", 10, "Use insulated containers or ice packs to keep them at a safe temperature.", "\"Date d'expiration:2024/04/19\"","","",""));
        items.add(new PopularDemon(R.drawable.sansd, "65", "HJ", "Cake chocolate", "cake6", 70, "Use insulated containers or ice packs to keep them at a safe temperature.", "\"Date d'expiration:2024/04/19\"","","",""));
        items.add(new PopularDemon(R.drawable.sansd, "96", "HJ", "Toast", "bread4", 10, "Use insulated containers or ice packs to keep them at a safe temperature.", "\"Date d'expiration:2024/04/19\"","","",""));

        binding.rc.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.rc.setAdapter(new Newadpter(items));

    }

}

