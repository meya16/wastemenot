package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import net.penguincoders.WasteMeNot.Adapter.AnonAdpter;
import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.FragmentAnonceBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;

import java.util.ArrayList;

public class AnonceFragment extends Fragment {

    private FragmentAnonceBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnonceBinding.inflate(inflater, container, false);
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
        items.add(new PopularDemon(R.drawable.choc, "49", "LOV", "FRICO","frico" ,  60, "Savor the best cheeses from Frico. Order now and get 50% off on all products plus free delivery for orders over 100DA", "Enjoy the authentic flavor of cheese Frico- Spécial offer for a limited time!","100DA","-50%","Cheese benefits:\n" +
                "- Made from fresh and pure milk.\n" +
                "- Wide range of delicious varieties."));
        items.add(new PopularDemon(R.drawable.salade, "9", "DF", "TAZEJ", "justazj",  100, "Enjoy pure freshness with TAZAJ fruit juices ,Order now and get 40% off your first order plus free delivery for orders over 200DA", "Refresh Yourself with Tazej juice - Spécial summer offer!","200DA","-40%","Juice benefits:\n" +
                "- Pressed from fresh seasonal fruits.\n" +
                "- Wide range of delicious flavors."));
        items.add(new PopularDemon(R.drawable.sansd, "10", "HJ", "MAYONNAISE", "mayoni", 120, "Discover the rich and creamy taste of  Mayonnaise, made from the finest ingredients. Perfect for sandwiches, salads, and dips. Order now and get 30% off plus free delivery for orders over 100DA! Don't miss out on this delicious deal", "Enhance Your Meals with Creamy Mayonnaise - Spécial offer for a limited Time!","200DA","-30%","Mayonnaise benefits:\n" +
                "- Made from the finest ingredients.\n" +
                "- Ideal for sandwiches, salads, and dips."));
        binding.rc.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.rc.setAdapter(new AnonAdpter(items));

    }

}

