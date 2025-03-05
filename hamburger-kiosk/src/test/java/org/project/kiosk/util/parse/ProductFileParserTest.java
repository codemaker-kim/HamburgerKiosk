package org.project.kiosk.util.parse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.project.kiosk.file.parse.ProductFileParser;
import org.project.kiosk.product.domain.Category;
import org.project.kiosk.product.domain.Product;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

class ProductFileParserTest {
    private ProductFileParser parser;

    @Test
    @DisplayName("정상적인 파일을 받았을 때 파일을 성공적으로 파싱하여 리스트로 반환한다.")
    void parserTest1() throws IOException {
        //given
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.txt"));
        ProductFileParser parser = new ProductFileParser();
        bos.write("name,price,quantity,description,category\n".getBytes());
        bos.write("치킨버거,7000,15,\"치킨으로 만든 햄버거\",햄버거\n".getBytes());
        bos.write("불고기버거,5000,6,\"불고기로 만든 햄버거\",햄버거\n".getBytes());
        bos.write("짜장면,5000,재고없음,\"안 팝니다.\",사이드\n".getBytes());
        bos.flush();

        File file = new File("test.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        //when
        List<Product> productList = parser.parseToProductList(reader);
        reader.close();
        file.delete();

        //then
        assertThat(productList)
                .extracting("name", "price", "stockQuantity", "description", "category")
                .containsExactlyInAnyOrder(
                        tuple("치킨버거", 7000, 15, "치킨으로 만든 햄버거", Category.BURGER),
                        tuple("불고기버거",5000,6,"불고기로 만든 햄버거", Category.BURGER),
                        tuple("짜장면",5000,0,"안 팝니다.", Category.SIDE)
                );
    }
}