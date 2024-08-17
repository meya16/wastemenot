package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ProfilSellerFragment())
                    .commit();
        }
    }
}