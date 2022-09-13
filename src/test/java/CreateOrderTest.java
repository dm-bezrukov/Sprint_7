import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import steps.OrderSteps;
import utils.OrderGenerator;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateOrderTest {

    @Test
    @DisplayName("Можно создать заказ указав оба цвета")
    public void createOrderWithBothColorsReturns201AndTrack() {
        Response response = OrderSteps.createOrder(OrderGenerator.getOrderWithBothColors());
        response
                .then()
                .statusCode(201)
                .and().assertThat().body("track", notNullValue());

    }

    @Test
    @DisplayName("Можно создать заказ указав чёрный цвет")
    public void createOrderWithBlackColorReturns201AndTrack() {
        Response response = OrderSteps.createOrder(OrderGenerator.getOrderWithBlackColor());
        response
                .then()
                .statusCode(201)
                .and().assertThat().body("track", notNullValue());
    }

    @Test
    @DisplayName("Можно создать заказ указав серый цвет")
    public void createOrderWithGreyColorReturns201AndTrack() {
        Response response = OrderSteps.createOrder(OrderGenerator.getOrderWithGreyColor());
        response
                .then()
                .statusCode(201)
                .and().assertThat().body("track", notNullValue());
    }

    @Test
    @DisplayName("Можно создать заказ не указав цвет")
    public void createOrderWithoutColorsReturns201AndTrack() {
        Response response = OrderSteps.createOrder(OrderGenerator.getOrderWithoutColors());
        response
                .then()
                .statusCode(201)
                .and().assertThat().body("track", notNullValue());
    }
}