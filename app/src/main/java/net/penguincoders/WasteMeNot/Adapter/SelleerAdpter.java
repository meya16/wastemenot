apackage net.penguincoders.WasteMeNot.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import net.penguincoders.WasteMeNot.Activity.DetailActivity;
import net.penguincoders.WasteMeNot.Activity.DetailProduct;
import net.penguincoders.WasteMeNot.databinding.ViewholderPupListBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;

import java.util.ArrayList;
import java.util.List;

public class SeeAlladpter2 extends RecyclerView.Adapter<SeeAlladpter2.Viewholder> implements Filterable {
    private ArrayList<PopularDemon> items;
    private ArrayList<PopularDemon> itemsFull; // A copy of the full list for filtering
    private Context context;
    private ViewholderPupListBinding binding;

    public SeeAlladpter2(ArrayList<PopularDemon> items) {
        this.items = items;
        this.itemsFull = new ArrayList<>(items); // Make a copy of the full list
    }

    @Override
    public Filter getFilter() {
        return productFilter;
    }

    private Filter productFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<PopularDemon> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(itemsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (PopularDemon item : itemsFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            Log.d("PopulAdpter", "Filtered list size: " + ((List<PopularDemon>) results.values).size());
            items.clear();
            items.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    @NonNull
    @Override
    public SeeAlladpter2.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderPupListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        return new SeeAlladpter2.Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SeeAlladpter2.Viewholder holder, int position) {
        binding.textView9.setText(items.get(position).getTitle());
        binding.textView5.setText(items.get(position).getPrice() + "DA");
        binding.textView4.setText(items.get(position).getTitle4());
        int drawableResources = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),
                "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResources)
                .transform(new GranularRoundedCorners(25, 25, 0, 0))
                .into(binding.imageView6);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailProduct.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderPupListBinding binding) {
            super(binding.getRoot());
        }
    }
}