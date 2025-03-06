package org.project.kiosk.product.storage;

import org.project.kiosk.product.domain.Category;
import org.project.kiosk.product.domain.Product;
import org.project.kiosk.product.error.ProductNotFoundException;
import org.project.kiosk.product.storage.dto.ProductInfo;

import java.util.List;
import java.util.stream.Collectors;

public class ProductStorage {
    private final List<Product> products;

    public ProductStorage(List<Product> products) {
        this.products = products;
    }

    public ProductInfo findByName(String name) {
        return ProductInfo.from(
                products.stream()
                        .filter(product -> product.getName().equals(name))
                        .findFirst()
                        .orElseThrow(ProductNotFoundException::new)
        );
    }

    public boolean isSet(String name) {
        return findByName(name).category() == Category.SET;
    }

    public List<ProductInfo> findAll() {
        return products.stream()
                .map(ProductInfo::from)
                .collect(Collectors.toList());
    }
}
