package net.penguincoders.WasteMeNot.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import net.penguincoders.WasteMeNot.Activity.Product;
import net.penguincoders.WasteMeNot.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.recyclerview_products, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getName());
        double price = product.getPrice();
       String pricestr = String.valueOf(price);

        holder.productPrice.setText(pricestr);
        // Load image using Glide
        Glide.with(context)
                .load(product.getImage())
                .into(holder.imageProduct);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productPrice;
        ImageView imageProduct;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productname);
            productPrice = itemView.findViewById(R.id.productprice);
            imageProduct = itemView.findViewById(R.id.imageproduct);
        }
        public void bind(Product product) {
            // Assuming you have converted the Bitmap to a drawable resource ID for simplicity

        }
    }
}
