package org.project.kiosk.order.application;

import org.project.kiosk.order.error.OverStockOrderException;
import org.project.kiosk.order.error.WrongOrderFormatException;
import org.project.kiosk.order.storage.OrderStorage;
import org.project.kiosk.product.domain.Product;
import org.project.kiosk.product.storage.ProductStorage;
import org.project.kiosk.product.storage.dto.ProductInfo;

import static org.project.kiosk.util.Separator.COMMA;

public class OrderValidator {
    private final ProductStorage productStorage;

    private final String SET = "세트";
    private final String LEFT_SQUARE_BRACKET = "\\[";
    private final String RIGHT_SQUARE_BRACKET = "]";
    private final String HYPHEN = "-";
    private final String BLANK = "";
    private final int ITEM_INDEX = 0;
    private final int QUANTITY_INDEX = 1;

    OrderValidator(OrderStorage orderStorage, ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public void validate(String orderForm) {
        try{
            String[] orderItems = splitOrderForm(orderForm);
            checkItems(orderItems);
        } catch(NumberFormatException e) {
            throw new WrongOrderFormatException();
        }
    }

    private String[] splitOrderForm(String orderForm) {
        return orderForm.replaceAll(LEFT_SQUARE_BRACKET+RIGHT_SQUARE_BRACKET, BLANK)
                .split(COMMA.getSeparator());
    }

    private void checkItems(String[] orderItems) {
        for (String orderItem : orderItems) {
            String[] itemInfo = orderItem.split(HYPHEN);
            ProductInfo dto = productStorage.findByName(itemInfo[ITEM_INDEX]);

            notOverStockQuantity(dto.stockQuantity(), itemInfo[QUANTITY_INDEX]);

            // 세트의 갯수와 함께 어떻게 처리하지?
        }
    }

    private void notOverStockQuantity(int stockQuantity, String orderQuantity) {
        if(stockQuantity < Integer.parseInt(orderQuantity))
            throw new OverStockOrderException();
    }
}
