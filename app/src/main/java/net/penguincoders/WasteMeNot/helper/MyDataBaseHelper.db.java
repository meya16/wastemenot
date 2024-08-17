package net.penguincoders.WasteMeNot.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import net.penguincoders.WasteMeNot.Activity.Product;
import net.penguincoders.WasteMeNot.Activity.PurchasedProduct;
import net.penguincoders.WasteMeNot.Activity.User;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDataBaseHelper extends SQLiteOpenHelper {



    byte[] imageInBytes;
    private Object Context;
    Context context;
    private static final String DATABASE_NAME = "WasteMeNot.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS ="users" ;
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD ="password" ;
    private static final String KEY_PHONE_NUMBER = "phoneNumber";
    private static final String KEY_CONFIRM_PASSWORD = "confirmPassword";
    private static final String KEY_USER_TYPE = "type";






    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCT_NAME = "product_name";
    public static final String COLUMN_PRODUCT_DESCRIPTION = "product_description";
    public static final String COLUMN_PRODUCT_PRICE = "product_price";
    public static final String COLUMN_PRODUCT_QUANTITY= "product_quantity";
    public static final String COLUMN_PRODUCT_EXPIRATION_DATE = "product_expirationDate";
    public static final String COLUMN_PRODUCT_IMAGE_URL = "image_url";





    // Table for purchased products
    private static final String TABLE_PURCHASED_PRODUCTS = "purchased_products";
    private static final String COLUMN_PURCHASE_ID = "purchase_id";
    private static final String COLUMN_PRODUCT_ID = "product_id";
    private static final String COLUMN_PURCHASE_DATE = "purchase_date";





    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }






    @Override
    public void onCreate(SQLiteDatabase db) {
        // Table user
        // Table user
        String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS " + TABLE_USERS +
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_USERNAME + " TEXT," +
                KEY_EMAIL + " TEXT," +
                KEY_PASSWORD + " TEXT," +
                KEY_PHONE_NUMBER + " TEXT," +
                KEY_USER_TYPE + " TEXT," +

                KEY_CONFIRM_PASSWORD + " TEXT)";
        db.execSQL(CREATE_TABLE_USERS);

        //Table product

        String CREATE_TABLE = "CREATE TABLE " + TABLE_PRODUCTS +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COLUMN_PRODUCT_NAME + " TEXT NOT NULL  ," +
                COLUMN_PRODUCT_PRICE + " DOUBLE NOT NULL ," +
                COLUMN_PRODUCT_QUANTITY + " INTEGER NOT NULL , " +
                COLUMN_PRODUCT_EXPIRATION_DATE + " TEXT NOT NULL , " +
                COLUMN_PRODUCT_IMAGE_URL + " TEXT NOT NULL , " +
                COLUMN_PRODUCT_DESCRIPTION + " TEXT);";
        db.execSQL(CREATE_TABLE);

        String createPurchasedProductsTable = "CREATE TABLE " + TABLE_PURCHASED_PRODUCTS + "(" +
                COLUMN_PURCHASE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_PRODUCT_ID + " INTEGER," +
                COLUMN_PURCHASE_DATE + " TEXT," +
                "FOREIGN KEY(" + COLUMN_PRODUCT_ID + ") REFERENCES " + TABLE_PRODUCTS + "(" + COLUMN_ID + "))";
        db.execSQL(createPurchasedProductsTable);


        db.execSQL("Create table addpr(id1 integer primary key autoincrement ,image Blob , name text, descrition text , price Double , Location  String , category String , quantity Integer)");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PURCHASED_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS addpr " );

        onCreate(db);
    }

    public void addPurchasedProduct(int productId, String purchaseDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_ID, productId);
        values.put(COLUMN_PURCHASE_DATE, purchaseDate);
        db.insert(TABLE_PURCHASED_PRODUCTS, null, values);
        db.close();
    }

    public List<PurchasedProduct> getPurchasedProductsByDate(String date) {
        List<PurchasedProduct> purchasedProducts = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_PURCHASED_PRODUCTS + " WHERE " + COLUMN_PURCHASE_DATE + "=?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{date});

        if (cursor.moveToFirst()) {
            do {
                int productId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_PRODUCT_ID));
                String purchaseDate = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PURCHASE_DATE));
                purchasedProducts.add(new PurchasedProduct(productId, purchaseDate));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return purchasedProducts;
    }



    public Map<String, Double> getTotalPricePerDay() {
        Map<String, Double> totalPricePerDay = new HashMap<>();
        String query = "SELECT " + COLUMN_PURCHASE_DATE + ", SUM(" + COLUMN_PRODUCT_PRICE + ") as total_price FROM " + TABLE_PURCHASED_PRODUCTS +
                " INNER JOIN " + TABLE_PRODUCTS + " ON " + TABLE_PURCHASED_PRODUCTS + "." + COLUMN_PRODUCT_ID + " = " + TABLE_PRODUCTS + "." + COLUMN_ID +
                " GROUP BY " + COLUMN_PURCHASE_DATE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                String date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PURCHASE_DATE));
                double totalPrice = cursor.getDouble(cursor.getColumnIndexOrThrow("total_price"));
                totalPricePerDay.put(date, totalPrice);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return totalPricePerDay;
    }

    private boolean validateInputs(String username, String email, String phoneNumber, String password, String confirmPassword) {
        // Implement validation logic
        // Return true if valid, false otherwise
        return true; // Placeholder return value
    }

    // Method to insert user data into the database
    public void addUser(String username, String email, String password, String phoneNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USERNAME, username);
        contentValues.put(KEY_EMAIL, email);
        contentValues.put(KEY_PASSWORD, password); // Considérez de hacher le mot de passe avant de l'enregistrer
        contentValues.put(KEY_PASSWORD, phoneNumber);
        long result = db.insert(TABLE_USERS, null, contentValues);
        db.close();
    }
    public boolean loginUser(String usernameOrEmail, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE email=?", new String[]{usernameOrEmail});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            @SuppressLint("Range") String storedPassword = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            if (storedPassword.equals(password)) { // Consider using a secure comparison method if passwords are hashed
                return true;
            }
        }
        return false;
    }
    public void signup(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Existing code...
        values.put(KEY_USERNAME, user.getUsername()); // Add this line to store the username

        db.insert(TABLE_USERS, null, values);
        db.close();
    }



    // add product in the table
    public void addProduct(String productName, String productDescription , double productPrice ,int productQuantity , String produitExpirationDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase dbR = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDataBaseHelper.COLUMN_PRODUCT_NAME, productName);
        contentValues.put(MyDataBaseHelper.COLUMN_PRODUCT_DESCRIPTION, productDescription);
        contentValues.put(MyDataBaseHelper.COLUMN_PRODUCT_PRICE, productPrice);
        contentValues.put(MyDataBaseHelper.COLUMN_PRODUCT_QUANTITY, productQuantity);
        contentValues.put(MyDataBaseHelper.COLUMN_PRODUCT_EXPIRATION_DATE, produitExpirationDate);




        long result = db.insert(MyDataBaseHelper.TABLE_PRODUCTS, null, contentValues);

        if (result == -1) {
            // If insertion failed, handle error
        } else {
            // Insertion successful
        }
    }


    // it's for the products , when a user add a product

    public  List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(MyDataBaseHelper.TABLE_PRODUCTS,
                new String[]{MyDataBaseHelper.COLUMN_ID, MyDataBaseHelper.COLUMN_PRODUCT_NAME, MyDataBaseHelper.COLUMN_PRODUCT_DESCRIPTION,MyDataBaseHelper.COLUMN_PRODUCT_PRICE,MyDataBaseHelper.COLUMN_PRODUCT_QUANTITY,MyDataBaseHelper.COLUMN_PRODUCT_EXPIRATION_DATE},
                null, null, null, null, null);

        if (cursor.moveToFirst()) {
          /*  do {
                Product product = new Product(
                        cursor.getInt(cursor.getColumnIndexOrThrow(MyDataBaseHelper.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDataBaseHelper.COLUMN_PRODUCT_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDataBaseHelper.COLUMN_PRODUCT_DESCRIPTION)),
                        cursor.getDouble(cursor.getColumnIndexOrThrow(MyDataBaseHelper.COLUMN_PRODUCT_PRICE)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(MyDataBaseHelper.COLUMN_PRODUCT_QUANTITY)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDataBaseHelper.COLUMN_PRODUCT_EXPIRATION_DATE))



                        );
                productList.add(product);
            }*/ while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return productList;
    }


    public void deleteProduct(int id) {
        SQLiteDatabase database = null;
        database.delete(TABLE_PRODUCTS, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }



    public  boolean insertDetail(Bitmap image , String name ,String description ,Double price , String location , int quantity ,String category ){
        SQLiteDatabase db =getReadableDatabase();
        ByteArrayOutputStream objectByteOutputStream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG,100,objectByteOutputStream);
        imageInBytes =objectByteOutputStream.toByteArray();
        ContentValues values = new ContentValues();
        values.put("image",imageInBytes);
        values.put("name",name);
        values.put("description",description);
        values.put("price",price);
        values.put("location",location);
        values.put("quantity",quantity);
        values.put("category",category);
        long id1=db.insert("addpr",null,values);
        if (id1<=0){
            return false;
        }
           else {
               return true;
        }

    }


}
