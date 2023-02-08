package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import serial.CreateCourier;
import serial.LoginCourier;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static constants.Urls.*;

public class CourierSteps {

    @Step("Create courier")
    public Response createCourier(String login, String pass, String name) {
        CreateCourier courier = new CreateCourier(login, pass, name);
        return given()
                .header("Content-type", "application/json")
                .body(courier)
                .when()
                .post(CREATE_COURIER);
    }

    @Step("Create login courier")
    public Response loginCourier(String login, String pass) {
        LoginCourier loginCourier = new LoginCourier(login, pass);
        return given()
                .header("Content-type", "application/json")
                .body(loginCourier)
                .when()
                .post(LOGIN_COURIER);
    }

    @Step("Get id courier")
    public Integer getCourierId(String login, String pass) {
        return loginCourier(login, pass)
                .body()
                .as(CreateCourier.class).getId();
    }

    @Step("Delete courier")
    public Response deleteCourier(String login, String pass) {
        return  given()
                .header("Content-type", "application/json")
                .when()
                .delete(courierDeletePreparingToString(getCourierId(login, pass)));
    }

    @Step("Preparing a deletion request")
    public String courierDeletePreparingToString(Integer courierID) {
        return DELETE_COURIER + courierID;
    }

    @Step("Check body - (ok: true) and server response status on first valid registration - 201")
    public void checkAnswerValidRegistration(Response response) {
        response
                .then()
                .statusCode(201)
                .and().assertThat().body("ok", equalTo(true));
    }

    @Step("Check body - (ok: true) and server response status on deletion - 200")
    public void checkAnswerThenValidDeleting(Response response) {
        response
                .then()
                .statusCode(200)
                .and().assertThat().body("ok", equalTo(true));
    }

    @Step("Checking the body and status of the server response when re-registering - 409")
    public void checkAnswerReuseRegistrationData(Response response) {
        response.then()
                .statusCode(409)
                .and().assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    @Step("Checking the body and status of the server response with incomplete data - 400")
    public void checkAnswerWithNotEnoughRegData(Response response) {
        response.then()
                .statusCode(400)
                .and().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
    @Step("Checking the presence of the courier id number by his login and password")
    public void checkAnswerAndPresenceId(Response response) {
        response.then()
                .statusCode(200).and().assertThat().body("id", notNullValue());
    }

    @Step("The system will return an error if the username or password is incorrect")
    public void checkAnswerWithWrongData(Response response) {
        response.then()
                .statusCode(404).assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    @Step("The system will return an error if the username or password is incorrect")
    public void checkAnswerWithoutData(Response response) {
        response.then()
                .statusCode(400).assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }
}

