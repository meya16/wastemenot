package net.penguincoders.WasteMeNot.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import net.penguincoders.WasteMeNot.databinding.AddProductBinding;

public class Addpr  extends AppCompatActivity {
    public AddProductBinding binding;
    Bitmap bitmap;
    byte[] biying;
    //MyDataBaseHelper helper;
    private ImageView image;
    private Uri imageFilePath;
    private  Bitmap imageTostore;
    private static final int PICK_IMAGE=1;


    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        binding =AddProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
   //      helper = new MyDataBaseHelper(this);
       /* if (binding.categorySpinner.equals(" ")|| binding.productprice.equals(0)||binding.productname.equals(" ")||binding.productquantity.equals(0)||binding.productdescription.equals(" ")||binding.productexpirationDate.equals(" ")||binding.locationEdittext.equals(" ")){
            Toast.makeText(this, "All fields required and price , quantity should be > 0 !", Toast.LENGTH_SHORT).show();
        }
        else{
            final int price =getIntent().getIntExtra("price",0);
            final String name = getIntent().getStringExtra("productName");
            final String description = getIntent().getStringExtra("productDescription");
            final int quantity = getIntent().getIntExtra("quantity",0);
            final String category = getIntent().getStringExtra("category");

            binding.productname.setText(name);
            binding.productdescription.setText(description);
            binding.productprice.setText(String.format("%d"));
            binding.productquantity.setText(quantity);




            binding.publish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean valueinserted = helper.insertDetail(


                            imageTostore,
                            binding.productname.getText().toString(),
                            binding.productname.getText().toString(),
                            binding.productdescription.getText().toString(),
                            binding.productprice.getText().toString(),
                            binding.locationEdittext.getText().toString(),
                            binding.quantity.getText().toString()


                    );
                    if (valueinserted){
                        Toast.makeText(Addpr.this, "Data inserted successfully!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Addpr.this, "Error occured", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            binding.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent gallery = new Intent();
                    gallery.setType("image/*");
                    gallery.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(gallery,"Select picture"));
                }

                private void startActivityForResult(Intent selectPicture) {
                }
            });

        }*/

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode , @NonNull Intent data){
        try {
            super.onActivityResult(requestCode,resultCode,data);
            if (requestCode==PICK_IMAGE && resultCode==RESULT_OK && data.getData() !=null)
            {
                imageFilePath = data.getData();
                imageTostore = MediaStore.Images.Media.getBitmap(getContentResolver(),imageFilePath);
                binding.image.setImageBitmap(imageTostore);
            }
        }catch (Exception e){
            Toast.makeText(this, "" +e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
