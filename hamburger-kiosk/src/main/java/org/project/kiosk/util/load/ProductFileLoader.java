package org.project.kiosk.util.load;

import org.project.kiosk.util.load.error.ProductFileNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ProductFileLoader {

    private static final String PRODUCT_FILE_LOCATION = "./src/main/resources/products.md";

    public static BufferedReader productFileLoad() {
        try{
            return new BufferedReader(new FileReader(PRODUCT_FILE_LOCATION));
        } catch(FileNotFoundException e) {
            throw new ProductFileNotFoundException();
        }
    }
}
