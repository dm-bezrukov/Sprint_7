import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.OrderSteps;
import utils.OrderGenerator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;

@AllArgsConstructor
@RunWith(Parameterized.class)
public class CreateOrderTest {

    private final List<String> orderColors;
    private final int expectedStatus;

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {Arrays.asList("GREY", "BLACK"), 201},
                {List.of("GREY"), 201},
                {List.of("BLACK"), 201},
                {Collections.emptyList(), 201}
        };
    }

    @Test
    @DisplayName("Параметризованный тест создания заказа с разными цветами")
    public void createOrderWithoutColorsReturns201AndTrack() {
        Response response = OrderSteps.createOrder(OrderGenerator.getOrder(orderColors));
        response
                .then()
                .statusCode(expectedStatus)
                .and().assertThat().body("track", notNullValue());
    }
}