package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.helper.MyDataBaseHelper;

public class Sellerprofil extends AppCompatActivity {
    TextView storename;
    EditText postaladdress;
    Button editProfil, addProduct;
    private RecyclerView recyclerView;
    private MyDataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellerprofil);

        db = new MyDataBaseHelper(this);
        recyclerView = findViewById(R.id.recyclerviewprofil);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





        // Your existing logic for replacing fragments and other UI elements
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }



}
