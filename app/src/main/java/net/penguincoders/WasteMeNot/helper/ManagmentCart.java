package net.penguincoders.WasteMeNot.helper;

import android.content.Context;
import android.widget.Toast;


import net.penguincoders.WasteMeNot.demon.PopularDemon;

import java.util.ArrayList;

public class ManagmentCart {

    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(PopularDemon item) {
        int numberOrder=2;
        ArrayList<PopularDemon> listfood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int y = 0; y < listfood.size(); y++) {
            if (listfood.get(y).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = y;
                break;
            }
        }
        if (existAlready) {
            listfood.get(n).setNumberInCart(item.getNumberInCart(numberOrder));
        } else {
            listfood.add(item);
        }
        tinyDB.putListObject("CartList", listfood);
        Toast.makeText(context, "Added to your Order", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<PopularDemon> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public void minusNumberItem(ArrayList<PopularDemon> listfood, int position, ChangeNumberItemListener changeNumberItemsListener) {
        int numberOrder=2;
        if (listfood.get(position).getNumberInCart(numberOrder) >= 1) {
           numberOrder --;
        } else if (listfood.get(position).getNumberInCart(numberOrder) == 0){
            Toast.makeText(context.getApplicationContext(), "Product deleted !!", Toast.LENGTH_SHORT).show();
            listfood.remove(position);

        }
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListener.change();
    }

    public void plusNumberItem(ArrayList<PopularDemon> listfood, int position, ChangeNumberItemListener changeNumberItemsListener) {
        int numberOrder=2;
        listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart(numberOrder) + 1);
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListener.change();
    }

    public Double getTotalFee() {
        int numberOrder=2;
        ArrayList<PopularDemon> listfood2 = getListCart();
        double fee = 0;
        for (int i = 1; i < listfood2.size(); i++) {
            fee = fee + (listfood2.get(i).getPrice() * listfood2.get(i).getNumberInCart(numberOrder));
        }
        return fee;
    }
}