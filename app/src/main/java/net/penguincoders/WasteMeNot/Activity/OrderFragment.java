package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import net.penguincoders.WasteMeNot.Adapter.CartAdpter;
import net.penguincoders.WasteMeNot.databinding.FragmentOrderBinding;
import net.penguincoders.WasteMeNot.helper.ChangeNumberItemListener;
import net.penguincoders.WasteMeNot.helper.ManagmentCart;

public class OrderFragment extends Fragment {
    private ManagmentCart managmentCart;
    double tax;
    FragmentOrderBinding binding;
    Button orderNow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentOrderBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();
        managmentCart = new ManagmentCart(getActivity());
        initList();
        claculatorCart();
        return rootView;
    }

    private void initList() {
        if (managmentCart.getListCart().isEmpty()) {
            binding.emptyview.setVisibility(View.VISIBLE);
            binding.scr.setVisibility(View.GONE);
        } else {
            binding.emptyview.setVisibility(View.GONE);
            binding.scr.setVisibility(View.VISIBLE);
        }

        binding.cartview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.cartview.setAdapter(new CartAdpter(managmentCart.getListCart(), new ChangeNumberItemListener() {
            @Override
            public void change() {
                claculatorCart();
            }
        }));
    }

    private void claculatorCart() {
        double percentTxt = 0.19;
        tax = Math.round((managmentCart.getTotalFee() * percentTxt * 100.0)) / 100.0;
        double total = Math.round((managmentCart.getTotalFee() + tax ) * 100) / 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;
        binding.totalfeetxt.setText(itemTotal + "DA");
        binding.taxtxt.setText(tax + "DA");
        binding.totaltxt.setText(total + "DA");
        binding.orderNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

}



