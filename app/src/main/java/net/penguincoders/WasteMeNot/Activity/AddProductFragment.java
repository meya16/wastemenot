package net.penguincoders.WasteMeNot.Activity;

import static android.app.Activity.RESULT_OK;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.penguincoders.WasteMeNot.databinding.FragmentAddProductBinding;
import net.penguincoders.WasteMeNot.helper.MyDataBaseHelper;

import java.util.ArrayList;
import java.util.Calendar;

public class AddProductFragment extends Fragment {

    private FragmentAddProductBinding binding;
    private Bitmap bitmap;
    private byte[] byteArray;
    private MyDataBaseHelper db;

    private static final int PICK_IMAGE = 1;
    private ImageView image;
    private Uri imageFilePath;
    private Bitmap imageToStore;

    int cYear, cMonth, cDay, cHour, cMinutes;

    public AddProductFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddProductBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), item + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Bread");
        arrayList.add("Juice");
        arrayList.add("Milk");
        arrayList.add("Cake");
        arrayList.add("Sandwich");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        binding.categorySpinner.setAdapter(arrayAdapter);

        db = new MyDataBaseHelper(requireContext());

        binding.publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if all fields are filled correctly
                if (TextUtils.isEmpty(binding.categorySpinner.getSelectedItem().toString())||
                TextUtils.isEmpty(binding.productname.getText().toString())||
                binding.productprice.getText().toString().isEmpty()||
                binding.productdescription.getText().toString().isEmpty()||
                binding.productexpirationDate.getText().toString().isEmpty()||
                binding.locationEdittext.getText().toString().isEmpty()||
                binding.quantity.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "All fields required and price, quantity should be > 0!", Toast.LENGTH_SHORT).show();
                } else {
                    // Create a Product object
                    double price = Double.parseDouble(binding.productprice.getText().toString());
                    int quantity = Integer.parseInt(binding.productqantity.getText().toString());

                    //Product product = new Product(bitmap, binding.productname.getText().toString(), binding.productdescription.getText().toString(), price, binding.locationEdittext.getText().toString(), quantity, binding.categorySpinner.getSelectedItem().toString(),1);
                    // Insert the product into your database
                    db.addProduct(binding.productname.getText().toString(),binding.productdescription.getText().toString(),price,quantity, binding.productexpirationDate.getText().toString());

                    Intent intent = new Intent(getContext(),MybarActivity.class);
                    startActivity(intent);
                    //startActivity(new Intent(getContext(), Profile2Fragment.class));


                }
            }
        });

        binding.image.setOnClickListener(v -> {
            Intent gallery = new Intent();
            gallery.setType("image/*");
            gallery.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(gallery, "Select picture"), PICK_IMAGE);
        });





        binding.productexpirationDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                cYear = calendar.get(Calendar.YEAR);
                cMonth = calendar.get(Calendar.MONTH);
                cDay = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        binding.productexpirationDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, cYear, cMonth, cDay);
                datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis() - 1000);
                datePickerDialog.show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @NonNull Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData()!= null) {
            Uri imageUri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), imageUri);
                binding.image.setImageBitmap(bitmap);
                SharedPreferences sharedPreferences = requireContext().getSharedPreferences("ImagePrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("selectedImageURI", imageUri.toString());
                editor.apply(); // Apply changes
            } catch (Exception e) {
                Toast.makeText(requireContext(), " " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }}