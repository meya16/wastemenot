package net.penguincoders.WasteMeNot.demon;

import java.io.Serializable;

public class PopularDemon implements Serializable {
    private int imageResourse;
    private String key_id;
    private String favStatus;
    private String title;
    private String picUrl;

    private double price;
    private int numberInCart;

    private String description;

    private String title2;
    private String title3;
    private String title4;
    private String title5;



    public PopularDemon(int imageResourse, String key_id, String favStatus, String title, String picUrl, double price, String description, String title2, String title3, String title4, String title5) {
        this.imageResourse = imageResourse;
        this.key_id = key_id;
        this.favStatus = favStatus;
        this.title = title;
        this.picUrl = picUrl;

        this.price= price;
        this.description=description;

        this.title2=title2;
        this.title3=title3;
        this.title4=title4;
        this.title5=title5;

    }

    public PopularDemon(String chocolateCake, String choc, int i, int i1, String picUrl, int price, String description, String title2, String title3) {
    }

    public int getImageResourse() {
        return imageResourse;
    }

    public void setImageResourse(int imageResourse) {
        this.imageResourse = imageResourse;
    }



    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }


public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }




    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getNumberInCart(int numberOrder) {
        return numberInCart;
    }

    public void setNumberInCart(int numberInChart) {
        this.numberInCart = numberInChart;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getTitle4() {
        return title4;
    }

    public void setTitle4(String title4) {
        this.title4 = title4;
    }
    public String getTitle5() {
        return title5;
    }

    public void setTitle5(String title5) {
        this.title5 = title5;
    }
}
