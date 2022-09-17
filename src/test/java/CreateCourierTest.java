import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.CreateCourierRequest;
import steps.CourierSteps;
import utils.CourierGenerator;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateCourierTest {

    @Test
    @DisplayName("Можно создать нового курьера")
    public void createCourierWithValidDataReturns201AndTrue() {
        CreateCourierRequest request = CourierGenerator.getNewCourier();

        Response response = CourierSteps.createCourier(request);
        response.then().statusCode(201)
                .and()
                .assertThat().body("ok", equalTo(true));
    }

    @Test
    @DisplayName("Нельзя создать двух одинаковых курьеров")
    public void createTwoIdenticalCouriersReturns409() {
        CreateCourierRequest request = CourierGenerator.getNewCourier();
        Response response = CourierSteps.createCourier(request);
        response.then()
                .statusCode(201)
                .and()
                .assertThat().body("ok", equalTo(true));

        Response errorResponse = CourierSteps.createCourier(request);
        errorResponse.then()
                .statusCode(409)
                .and()
                .assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    @Test
    @DisplayName("Нельзя создать курьера без обязательных полей")
    public void createCourierWithoutPasswordReturns400() {
        CreateCourierRequest request = CourierGenerator.getNewCourier();
        request.setPassword(null);

        Response response = CourierSteps.createCourier(request);
        response.then()
                .statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}