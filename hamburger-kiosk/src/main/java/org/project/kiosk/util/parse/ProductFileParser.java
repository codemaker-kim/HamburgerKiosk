package org.project.kiosk.util.parse;

import org.project.kiosk.product.domain.Category;
import org.project.kiosk.product.domain.Product;
import org.project.kiosk.util.error.WrongCategoryException;
import org.project.kiosk.util.error.WrongFileFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductFileParser {

    private final int NAME_INDEX = 0;
    private final int PRICE_INDEX = 1;
    private final int QUANTITY_INDEX = 2;
    private final int DESCRIPTION_INDEX = 3;
    private final int CATEGORY_INDEX = 4;
    private final String QUOTATION_MARK_REGEX = "\"";
    private final String REPLACE_BLANK_REGEX = "";

    public List<Product> parseToProductList(BufferedReader reader) throws IOException {
        List<Product> products = new ArrayList<>();
        //첫째 줄 제거
        String productInfo = reader.readLine();

        while((productInfo = reader.readLine()) != null) {
            products.add(makeProduct(productInfo));
        }

        return products;
    }

    private Product makeProduct(String productInfo){
        String[] productElements = productInfo.split(",");

        try{
            String name = productElements[NAME_INDEX];
            int price = Integer.parseInt(productElements[PRICE_INDEX]);
            int stockQuantity = Integer.parseInt(productElements[QUANTITY_INDEX]);
            String description = productElements[DESCRIPTION_INDEX]
                    .replaceAll(QUOTATION_MARK_REGEX, REPLACE_BLANK_REGEX);
            Category category = parseCategory(productElements[CATEGORY_INDEX]);

            return Product.makeProduct(name, price, stockQuantity, description, category);
        } catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new WrongFileFormatException();
        }
    }

    private Category parseCategory(String category){
        return Arrays.stream(Category.values())
                .filter(c -> c.getCategory().equals(category))
                .findFirst()
                .orElseThrow(() -> new WrongCategoryException(category));
    }
}
