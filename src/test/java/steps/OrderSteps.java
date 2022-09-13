package steps;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.CreateOrderRequest;

import static io.restassured.RestAssured.given;

public class OrderSteps {
    public static final RequestSpecification REQUEST_SPECIFICATION =
            new RequestSpecBuilder()
                    .setBaseUri("https://qa-scooter.praktikum-services.ru/api/v1")
                    .setBasePath("/orders")
                    .setContentType(ContentType.JSON)
                    .build();

    @Step("Create order")
    public static Response createOrder(CreateOrderRequest request) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(request)
                .when()
                .post();
    }

    @Step("Get orders list")
    public static Response getOrdersList() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .when()
                .get();
    }
}