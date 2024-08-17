package net.penguincoders.WasteMeNot.Activity;

import android.graphics.Bitmap;

public class Product {
    private int id;
    private static String name;
    private String description;
    private static String expirationDate;
    private int quantity;
    private static double price;
    private Bitmap image;
    private static String location;







    // Constructor
    public Product( Bitmap image , String name, String description,double price, String location ,int quantity, String expirationDate,int id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        this.price = price;
        this.location=location;
        this.image = image;

    }



    // Getters
    public int getId() {
        return id;
    }

    public static String getName() {
        return name;
    }
    public static String getLocation() {
        return location;
    }


    public String getDescription() {
        return description;
    }

    public static String getExpirationDate() {

        return expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public static double getPrice() {
        return price;
    }


    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public void setPrice(double price) {
        this.price = price;
    }



    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


   /* public Uri getImage(int index) {
        if (index >= 0 && index < image.length) {
            return image[index];
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public int getImageCount() {
        return image.length;
    }
    public void addImage(Uri newImageUri) {
        int currentSize = image.length;
        Uri[] newImages = new Uri[currentSize + 1]; // Crée un nouveau tableau plus grand
        System.arraycopy(image, 0, newImages, 0, currentSize); // Copie les anciennes images
        newImages[currentSize] = newImageUri; // Ajoute la nouvelle image
        image = newImages; // Met à jour le tableau d'images
    }*/


    public String getImage() {
        return image.toString();
    }
}
