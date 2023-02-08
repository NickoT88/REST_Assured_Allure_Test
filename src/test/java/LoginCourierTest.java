import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import steps.CourierSteps;

import static constants.RandomData.*;
import static constants.Urls.URL;

public class LoginCourierTest {
    CourierSteps courierSteps;

    @Before
    public void setUp() {
        RestAssured.baseURI = URL;
        courierSteps = new CourierSteps();
        courierSteps.createCourier(RANDOM_LOGIN, RANDOM_PASS, RANDOM_NAME);
    }

    @Test
    @DisplayName("Successful courier login")
    @Description("When entering a valid password and login, a successful request returns the id of the courier")
    public void loginCourierSuccess() {
        Response loginResponse = courierSteps.loginCourier(RANDOM_LOGIN, RANDOM_PASS);
        courierSteps.checkAnswerAndPresenceId(loginResponse);
        Response responseDelete = courierSteps.deleteCourier(RANDOM_LOGIN, RANDOM_PASS);
        courierSteps.checkAnswerThenValidDeleting(responseDelete);
    }

    @Test
    @DisplayName("Failed courier login with incorrect courierLogin")
    @Description("Creating new courier, login with incorrect courierLogin and Check the failed login courier, statusCode=404")
    public void loginCourierWithIncorrectLoginFailed() {
        Response wrongLoginResponse = courierSteps.loginCourier("wrongLogin", RANDOM_PASS);
        courierSteps.checkAnswerWithWrongData(wrongLoginResponse);
        Response responseDelete = courierSteps.deleteCourier(RANDOM_LOGIN, RANDOM_PASS);
        courierSteps.checkAnswerThenValidDeleting(responseDelete);
    }

    @Test
    @DisplayName("Failed courier login with incorrect courierPassword")
    @Description("Creating new courier, login with incorrect courierPassword and Check the failed login courier, statusCode=404")
    public void loginCourierWithIncorrectPassFailed() {
        Response wrongPassResponse = courierSteps.loginCourier(RANDOM_LOGIN, "987");
        courierSteps.checkAnswerWithWrongData(wrongPassResponse);
        Response responseDelete = courierSteps.deleteCourier(RANDOM_LOGIN, RANDOM_PASS);
        courierSteps.checkAnswerThenValidDeleting(responseDelete);
    }

    @Test
    @DisplayName("Failed courier login without courierLogin")
    @Description("Creating new courier, login without courierLogin and check the failed login courier, statusCode=400")
    public void loginCourierWithoutLoginFailed() {
        Response withoutLoginResponse = courierSteps.loginCourier("", RANDOM_PASS);
        courierSteps.checkAnswerWithoutData(withoutLoginResponse);
        Response responseDelete = courierSteps.deleteCourier(RANDOM_LOGIN, RANDOM_PASS);
        courierSteps.checkAnswerThenValidDeleting(responseDelete);
    }

    @Test
    @DisplayName("Failed courier login without courierPassword")
    @Description("Creating new courier, login without courierPassword and check the failed login courier, statusCode=400")
    public void loginCourierWithoutPassFailed() {
        Response withoutPassResponse = courierSteps.loginCourier(RANDOM_LOGIN, "");
        courierSteps.checkAnswerWithoutData(withoutPassResponse);
        Response responseDelete = courierSteps.deleteCourier(RANDOM_LOGIN, RANDOM_PASS);
        courierSteps.checkAnswerThenValidDeleting(responseDelete);
    }
}
