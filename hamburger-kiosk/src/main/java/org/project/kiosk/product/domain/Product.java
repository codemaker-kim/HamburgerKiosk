package org.project.kiosk.product.domain;

public class Product {
    private String name;
    private int price;
    private int stockQuantity;
    private String description;
    private Category category;

    private Product() {
    }

    public static Product makeProduct(String name, int price, int stockQuantity, String description, Category category) {
        Product product = new Product();
        product.name = name;
        product.price = price;
        product.stockQuantity = stockQuantity;
        product.description = description;
        product.category = category;

        return product;
    }

    void reduceQuantity(int purchaseQuantity){
        stockQuantity-=purchaseQuantity;
    }
}
