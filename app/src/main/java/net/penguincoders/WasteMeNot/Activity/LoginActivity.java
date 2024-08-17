package net.penguincoders.WasteMeNot.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.helper.MyDataBaseHelper;

//import com.google.android.material.bottomnavigation.BottomNavigationView;
public class LoginActivity extends AppCompatActivity {
    public static String UserEmail;
    Button LogInButton;
    EditText Email, Password;
    TextView RegisterButton;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    MyDataBaseHelper db;
    Cursor cursor;
    String TempPassword = "NOT_FOUND";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);





        LogInButton = (Button)findViewById(R.id.login);
        RegisterButton = findViewById(R.id.signupText);
        Email = (EditText)findViewById(R.id.Email);
        Password = (EditText)findViewById(R.id.password);
        db = new MyDataBaseHelper(this);

        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                    Toast.makeText(LoginActivity.this, "Please enter your informations !!", Toast.LENGTH_SHORT).show();
             db.loginUser(email,password);


                // Dans votre activité de signup
                SharedPreferences sharedPref = getPreferences(Signup.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("userName", email); // Remplacez "username" par la variable contenant le nom d'utilisateur inscrit
                editor.apply(); // Ou editor.commit() si vous préférez
                Intent intent = new Intent(LoginActivity.this,MybarActivity.class);
                startActivity(intent);


            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Signup.class);
                startActivity(intent);
            }
        });
    }


        }






