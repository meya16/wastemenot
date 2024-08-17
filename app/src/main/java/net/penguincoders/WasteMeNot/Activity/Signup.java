package net.penguincoders.WasteMeNot.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.helper.MyDataBaseHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Signup extends AppCompatActivity {

    EditText username , email , password , confirmPassword , phoneNumber;
    Button Signupbtn , hasacc;

   MyDataBaseHelper db;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
        db = new MyDataBaseHelper(this);

        username = findViewById(R.id.storename);
        email = findViewById(R.id.selleremail);
        password = findViewById(R.id.sellerpassword);
        confirmPassword = findViewById(R.id.sellerconfirmpassword);
        hasacc = findViewById(R.id.hasacc);
        phoneNumber=findViewById(R.id.Phonenumber);

        Signupbtn = findViewById(R.id.sellersignupbtn);


        Signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Username = username.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String ConfirmPassword = confirmPassword.getText().toString();
                String PhoneNumber = phoneNumber.getText().toString();
                if (TextUtils.isEmpty(Email)||TextUtils.isEmpty(Username)||TextUtils.isEmpty(Password)||TextUtils.isEmpty(ConfirmPassword))
                    Toast.makeText(Signup.this, "All fields required ", Toast.LENGTH_SHORT).show();

                        // Validation de l'email et du nom d'utilisateur
                       else if (!isValidEmail(Email)) {
                            Toast.makeText(Signup.this, "Please enter a valid email address.", Toast.LENGTH_SHORT).show();
                        } else if (!isValidUsername(Username)) {
                            Toast.makeText(Signup.this, "Invalid username. Must contain at least 5 characters.", Toast.LENGTH_SHORT).show();
                        } else if (!isValidPhoneNumber(PhoneNumber)) {
                           Toast.makeText(Signup.this, " Please enter a valid phone number.", Toast.LENGTH_SHORT).show();
                        }
                            else  if (Password.equals(ConfirmPassword)) {
                    db.addUser(Username, Email, Password, PhoneNumber);


                            Toast.makeText(Signup.this, " Regestration succefull", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Signup.this,HomeFragment.class);
                    intent.putExtra("username",Username);
                    startActivity(intent);

                } else {
                    Toast.makeText(Signup.this, "Passwords are not matching !! ", Toast.LENGTH_SHORT).show();

                }


            }

        });
    }





    /*sqlite */


    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneNumberPattern = "^\\+?[0-9]?[-. ]?[0-9]{2,3}[-. ]?[0-9]{2,4}[-. ]?[0-9]{2,4}$";
        Pattern pattern = Pattern.compile(phoneNumberPattern);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }


    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


    private boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        Pattern pat = Pattern.compile(passwordRegex);
        if (password == null)
            return false;
        return pat.matcher(password).matches();
    }

    public static boolean isValidUsername(final String username) {
        String userRegex = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        Pattern pattern = Pattern.compile(userRegex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }




}






