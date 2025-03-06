package org.project.kiosk.io.output;

import org.project.kiosk.order.domain.Order;
import org.project.kiosk.product.domain.Category;
import org.project.kiosk.product.storage.dto.ProductInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConsoleOutputPrinter {

    private final String EQUAL = "=";

    public void printRootMessage() {
        for(RootMessage message : RootMessage.values()){
            message.printMessage();
        }
    }

    public void printExitMessage() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void printJoinManagerMessage() {
        System.out.println("관리자의 정보를 입력해주세요 ex) 관리자1, 100000");
    }

    public void printJoinMemberMessage() {
        System.out.println("회원의 정보를 입력해주세요 ex) 1, 30000");
    }

    public void printWelcomeMessage(String managerId, String memberId) {
        System.out.println("=================================");
        System.out.printf("안녕하세요. %s님 햄버거 가게 입니다." +
                "\n현재 접속된 관리자는 %s입니다.\n", memberId, managerId);
    }

    public void printMenuList(List<ProductInfo> products) {
        Map<Category, String> categoryHeaders = new LinkedHashMap<>();
        categoryHeaders.put(Category.BURGER, "=햄버거=");
        categoryHeaders.put(Category.SET, "=햄버거=");
        categoryHeaders.put(Category.SIDE, "=사이드=");
        categoryHeaders.put(Category.DRINK, "=음료수=");

        for (Category category : categoryHeaders.keySet()) {
            System.out.println(categoryHeaders.get(category));
            products.stream()
                    .filter(product -> product.category() == category)
                    .forEach(product -> System.out.println(formatProduct(product)));
        }

        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [치킨버거-3],[불고기버거세트-2])");
    }

    private String formatProduct(ProductInfo product) {
        String stockStatus = product.stockQuantity() + "개";
        if(product.stockQuantity() == 0)
            stockStatus = "품절";

        return String.format("-%s, %d원, %s, %s", product.name(), product.price(), stockStatus, product.description());
    }

    public void printReceipt(Order order) {
    }

    public void printOrderAgainMessage() {
        System.out.println("감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)");
    }

}
