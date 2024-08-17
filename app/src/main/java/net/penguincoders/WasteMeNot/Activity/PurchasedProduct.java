package net.penguincoders.WasteMeNot.Activity;

public class PurchasedProduct {
    private int productId;
    private String purchaseDate;

    public PurchasedProduct(int productId, String purchaseDate) {
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public int getProductId() {
        return productId;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }
}
