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

import static org.project.kiosk.util.parse.ElementIndex.*;

public class ProductFileParser {

    private final int ZERO = 0;
    private final String NO_QUANTITY = "재고없음";
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
            String name = productElements[NAME_INDEX.getIndex()];
            int price = Integer.parseInt(productElements[PRICE_INDEX.getIndex()]);
            int stockQuantity = parseQuantity(productElements[QUANTITY_INDEX.getIndex()]);
            String description = productElements[DESCRIPTION_INDEX.getIndex()]
                    .replaceAll(QUOTATION_MARK_REGEX, REPLACE_BLANK_REGEX);
            Category category = parseCategory(productElements[CATEGORY_INDEX.getIndex()]);

            return Product.makeProduct(name, price, stockQuantity, description, category);
        } catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new WrongFileFormatException();
        }
    }

    private int parseQuantity(String quantity) {
        if(quantity.equals(NO_QUANTITY))
            return ZERO;

        return Integer.parseInt(quantity);
    }

    private Category parseCategory(String category){
        return Arrays.stream(Category.values())
                .filter(c -> c.getCategory().equals(category))
                .findFirst()
                .orElseThrow(() -> new WrongCategoryException(category));
    }
}
