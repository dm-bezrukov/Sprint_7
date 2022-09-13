import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import steps.OrderSteps;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetOrderTest {
    @Test
    @DisplayName("Возвращается список заказов")
    public void getOrderRequestReturnsNotEmptyList() {
        Response ordersList = OrderSteps.getOrdersList();
        ordersList.then()
                .statusCode(200)
                .and()
                .assertThat().body("orders", notNullValue());
    }
}
