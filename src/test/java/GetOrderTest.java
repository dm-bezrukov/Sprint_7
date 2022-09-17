import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import steps.OrderSteps;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;


public class GetOrderTest {
    @Test
    @DisplayName("Возвращается список заказов")
    public void getOrderRequestReturnsNotEmptyList() {
        Response ordersList = OrderSteps.getOrdersList();
        ordersList.then()
                .statusCode(200)
                .and()
                .body("orders", hasSize(greaterThan(0)));
    }
}