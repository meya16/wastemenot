package net.penguincoders.WasteMeNot.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.penguincoders.WasteMeNot.Adapter.ProductAdapter;
import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.helper.MyDataBaseHelper;

import java.util.List;

public class ProfilSellerFragment extends Fragment {
    TextView storename;
    EditText postaladdress;
    Button editProfil, analyse;
    private RecyclerView recyclerView;
    private MyDataBaseHelper db;
    private ProductAdapter productAdapter;
    private List<Product> productList; // Declare productList

    public ProfilSellerFragment() { // Default constructor
    }

    public ProfilSellerFragment(List<Product> productList) { // Parameterized constructor
        this.productList = productList; // Initialize productList
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil_seller, container, false);

        db = new MyDataBaseHelper(requireContext());
        recyclerView = view.findViewById(R.id.recyclerviewprofil);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Fetch or generate your productList here before instantiating the adapter
        // Example: productList = db.getAllProducts();

        // Instantiate the adapter
        productAdapter = new ProductAdapter(getContext(), productList);

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(productAdapter);

        storename = view.findViewById(R.id.storename);
        editProfil = view.findViewById(R.id.edit);
        editProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LesinfomationuserActivity.class));
            }
        });

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String userName = sharedPref.getString("userName", null);
        if (userName!= null) {
            storename.setText(userName);
        }

        analyse = view.findViewById(R.id.analyse);
        // Initialize postaladdress here if needed
        // Use db object for database operations

        return view; // Correctly returning the inflated view
    }
}
