import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static listeners.CustomAllureListener.withCustomTemplates;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class Homework {
    @Test
    void addToWishListCustomTest() {
        given()
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("addtocart_51.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/51/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"))
//                .body("updatetopcartsectionhtml", is("\"(1)\""));
                .body("updatetopwishlistsectionhtml", is(notNullValue()));
    }
}
