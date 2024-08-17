package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.penguincoders.WasteMeNot.R;

public class LesinfomationuserActivity extends AppCompatActivity {
    Button save;
    EditText username, email, phonenumber, country;
    TextView Usernametext, Emailtext, Phonenumbertext, Countrytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesinfomationuser);

        save = findViewById(R.id.save);
        // Edit texts
        username = findViewById(R.id.editusername);
        email = findViewById(R.id.editemail);
        phonenumber = findViewById(R.id.editphone);
        country = findViewById(R.id.editcountry);

        // Textviews
        Usernametext = findViewById(R.id.textuserrname);
        Emailtext = findViewById(R.id.textemail);
        Phonenumbertext = findViewById(R.id.textphone);
        Countrytext = findViewById(R.id.textcountry);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passedUserName = getIntent().getStringExtra("currentUserName");
                if (passedUserName!= null) {
                 username = findViewById(R.id.editusername);

                    // Set the text of the EditText to the passed username
                    username.setText(passedUserName);
                }


            }
        });
    }




}
