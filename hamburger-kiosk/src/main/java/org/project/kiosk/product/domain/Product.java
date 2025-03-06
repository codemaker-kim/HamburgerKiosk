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

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }
}
