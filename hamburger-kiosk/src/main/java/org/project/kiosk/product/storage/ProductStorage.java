package org.project.kiosk.product.storage;

import org.project.kiosk.product.domain.Product;

import java.util.List;

public class ProductStorage {
    private final List<Product> products;

    public ProductStorage(List<Product> products) {
        this.products = products;
    }
}
