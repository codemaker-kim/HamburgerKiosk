package org.project.kiosk.product.storage.dto;

import org.project.kiosk.product.domain.Category;
import org.project.kiosk.product.domain.Product;

public record ProductInfo(
        String name,
        int price,
        int stockQuantity,
        String description,
        Category category
) {
    public static ProductInfo from(Product product) {
        return new ProductInfo(
                product.getName(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getDescription(),
                product.getCategory()
        );
    }
}
