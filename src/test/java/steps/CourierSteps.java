package steps;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.CreateCourierRequest;
import pojos.LoginCourierRequest;

import static io.restassured.RestAssured.given;

public class CourierSteps {
    public static final RequestSpecification REQUEST_SPECIFICATION =
            new RequestSpecBuilder()
                    .setBaseUri("https://qa-scooter.praktikum-services.ru/api/v1")
                    .setBasePath("/courier")
                    .setContentType(ContentType.JSON)
                    .build();

    @Step("Create new courier")
    public static Response createCourier(CreateCourierRequest body) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(body)
                .when().post();
    }

    @Step("Login courier")
    public static Response loginCourier(LoginCourierRequest body) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(body)
                .when().post("/login");
    }
}
