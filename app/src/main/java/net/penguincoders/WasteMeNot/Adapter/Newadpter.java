package net.penguincoders.WasteMeNot.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import net.penguincoders.WasteMeNot.Activity.DetailActivity;
import net.penguincoders.WasteMeNot.databinding.ItembreadBinding;
import net.penguincoders.WasteMeNot.databinding.ItemnewBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;

import java.util.ArrayList;
import java.util.List;

public class Newadpter extends RecyclerView.Adapter<Newadpter.Viewholder>  {
    ArrayList<PopularDemon> items;
    Context context;
    ItemnewBinding binding;


    public Newadpter(ArrayList<PopularDemon> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull Newadpter.Viewholder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @NonNull
    @Override
    public Newadpter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ItemnewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        context= parent.getContext();
        return new Newadpter.Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Newadpter.Viewholder holder, int position) {
        binding.textView9.setText(items.get(position).getTitle());
        binding.textView5.setText(items.get(position).getPrice()+"DA");

        int drawableResources=holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),
                "drawable",holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResources)
                .transform(new GranularRoundedCorners(25,25,0,0))
                .into(binding.imageView6);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("object",items.get(position));
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ItemnewBinding binding) {
            super(binding.getRoot());
        }
    }
}

