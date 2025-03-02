package org.project.kiosk.product.storage;

import org.project.kiosk.product.domain.Product;

import java.util.List;

public class ProductFileStorage {
    private final List<Product> products;

    public ProductFileStorage(List<Product> products) {
        this.products = products;
    }
}
