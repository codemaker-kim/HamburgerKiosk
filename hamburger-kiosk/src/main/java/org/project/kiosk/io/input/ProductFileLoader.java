package org.project.kiosk.io.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductFileLoader {

    private static final String PRODUCT_FILE_LOCATION = "./src/main/resources/products.md";

    public static BufferedReader productFileLoad() {
        try{
            return new BufferedReader(new FileReader(PRODUCT_FILE_LOCATION));
        } catch(IOException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
