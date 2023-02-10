package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import serial.CreateOrder;

import static constants.Urls.ORDERS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class OrderSteps {
    @Step("Создание нового заказа с использованием {order}")
    public Response createOrder(CreateOrder order) {
        return given()
                .header("Content-type", "application/json")
                .body(order)
                .when()
                .post(ORDERS);
    }

    @Step("Checking the response body contains a non-empty \"track\"")
    public void checkOrderTrackNotNullNew(Response response) {
        response.then()
                .statusCode(201).and().assertThat().body("track", notNullValue());
    }

    @Step("Request a list of orders")
    public Response getOrdersList() {
        return given()
                .header("Content-type", "application/json")
                .when()
                .get(ORDERS);
    }

    @Step("Check getting a list of orders is not empty")
    public void checkOrderListNotNullNew(Response response) {
        response.then()
                .statusCode(200).and().assertThat().body("orders", notNullValue());
    }

}
