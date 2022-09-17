import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pojos.CreateCourierRequest;
import pojos.LoginCourierRequest;
import steps.CourierSteps;
import utils.CourierGenerator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginCourierTest {
    @Test
    @DisplayName("Курьер может авторизоваться")
    public void loginCourierWithValidDataReturns200AndId() {
        CreateCourierRequest request = CourierGenerator.getNewCourier();

        Response response = CourierSteps.createCourier(request);
        response.then()
                .statusCode(201)
                .and()
                .assertThat().body("ok", equalTo(true));

        Response loginResponse = CourierSteps.loginCourier(new LoginCourierRequest(request.getLogin(),
                request.getPassword()));

        loginResponse.then()
                .statusCode(200)
                .and()
                .assertThat().body("id", notNullValue());
    }

    @Test
    @DisplayName("Невозможно авторизоваться c несуществующей парой логин-пароль")
    public void loginCourierWithWrongCredentialsReturns404() {
        Response loginResponse = CourierSteps.loginCourier(new LoginCourierRequest(
                RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10)));

        loginResponse.then()
                .statusCode(404)
                .and()
                .assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Невозможно авторизоваться без заполнения обязательных полей")
    public void loginCourierWithoutPasswordReturns400() {
        Response loginResponse = CourierSteps.loginCourier(new LoginCourierRequest(
                RandomStringUtils.randomAlphabetic(10),null));

        loginResponse.then()
                .statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }
}
