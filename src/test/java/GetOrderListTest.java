import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import steps.OrderSteps;

import static constants.Urls.URL;


public class GetOrderListTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = URL;
    }

    @Test
    @DisplayName("A list of orders is returned in the response body")
    @Description("Список всех заказов системы как файл json")
    public void getOrderListNotNull() {
        OrderSteps orderStep = new OrderSteps();
        Response response = orderStep.getOrdersList();
        orderStep.checkOrderListNotNullNew(response);
    }
}
