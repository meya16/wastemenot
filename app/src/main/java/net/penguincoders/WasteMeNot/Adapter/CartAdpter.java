package net.penguincoders.WasteMeNot.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import net.penguincoders.WasteMeNot.databinding.ViewholderCartBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;
import net.penguincoders.WasteMeNot.helper.ChangeNumberItemListener;
import net.penguincoders.WasteMeNot.helper.ManagmentCart;

import java.util.ArrayList;

public class CartAdpter extends RecyclerView.Adapter<CartAdpter.ViewHolder> {
    ArrayList<PopularDemon> items;
    Context context;
    ViewholderCartBinding binding;
    ChangeNumberItemListener changeNumberItemListener;
    ManagmentCart managmentCart;

    public CartAdpter(ArrayList<PopularDemon> items, ChangeNumberItemListener changeNumberItemListener) {
        this.items = items;
        this.changeNumberItemListener = changeNumberItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding= ViewholderCartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        managmentCart = new ManagmentCart(context);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int numberOrder=2;
       binding.titletxt.setText(items.get(position).getTitle());
        binding.feeEchantny.setText(items.get(position).getPrice()+"DA");
       binding.totalechanty.setText(Math.round(items.get(position).getNumberInCart(numberOrder)*items.get(position).getPrice())+"DA");
        binding.numberOrder.setText(String.valueOf(items.get(position).getNumberInCart(numberOrder)));


        int drawableResources = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),
                "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResources)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(binding.picsdf);





        binding.pluscart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managmentCart.plusNumberItem(items, position, new ChangeNumberItemListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemListener.change();
                    }
                });
            }
        });
        binding.mincart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managmentCart.minusNumberItem(items, position, new ChangeNumberItemListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemListener.change();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(ViewholderCartBinding binding) {

            super(binding.getRoot());
        }
    }
}
