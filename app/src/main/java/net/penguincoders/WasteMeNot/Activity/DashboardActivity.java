package net.penguincoders.WasteMeNot.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.penguincoders.WasteMeNot.R;

public class DashboardActivity extends AppCompatActivity {
    String EmailHolder;
    TextView Email;
    Button LogOUT;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Email = (TextView) findViewById(R.id.textView1);
        LogOUT = (Button) findViewById(R.id.button1);

        Intent intent = getIntent();
        EmailHolder = intent.getStringExtra(LoginActivity.UserEmail);

        Email.setText(Email.getText().toString() + EmailHolder);

        LogOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(DashboardActivity.this, "Log Out Successful", Toast.LENGTH_LONG).show();
            }
        });
    }
}