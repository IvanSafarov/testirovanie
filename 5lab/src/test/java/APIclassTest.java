import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class APIclassTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void test1() {
        String s = "{\"id\":13}";

        given().
                contentType("application/json").
                body(s).
                when().
                post("https://petstore.swagger.io/v2/pet").
                then().
                statusCode(200).
                body("id", equalTo(13));

    }

    @Test
    public void testGet() {
        RestAssured
                .get("https://petstore.swagger.io/v2/pet/13")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", equalTo(13  ));
    }

    @Test
    public void testGetNotFoundPet() {
        RestAssured
                .get("https://petstore.swagger.io/v2/pet/13")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testPut() {
        String s = "{\"id\":13}";
        given().
                contentType("application/json").
                body(s).
                when().
                put("https://petstore.swagger.io/v2/pet").
                then().
                statusCode(200).
                body("id", equalTo(13));
    }

    @Test
    public void testPutRequest() {

        String requestBody = "{\"id\": 13, \"name\": \"snake\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .body("name", equalTo("snake"))
                .extract()
                .response();
    }

    @Test
    public void testDeleteRequestError() {

        String requestBody = "{\"id\": 12, \"name\": \"snake123\"}";

        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/pet")
                .then()
                .statusCode(200);

        RestAssured.given()
                .when()
                .delete("/pet/12")
                .then()
                .statusCode(200);

        RestAssured.given()
                .when()
                .get("/pet/12")
                .then()
                .statusCode(404);

      /*Response response1 = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .body("name", equalTo("snake123"))
                .extract()
                .response();

        Response response = given()
                .when()
                .delete("https://petstore.swagger.io/v2/pet/10")
                .then()
                .statusCode(404)
                .extract()
                .response();*/
    }
}