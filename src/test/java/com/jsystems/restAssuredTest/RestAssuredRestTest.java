package com.jsystems.restAssuredTest;

import com.jsystems.models.ErrorResponse;
import com.jsystems.models.MyObj;
import com.jsystems.models.User;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;


//@RunWith(JUnitPlatform.class)
public class RestAssuredRestTest extends ConfigRestAssured {

    @Test
    @DisplayName("======================Testy z wykorzystaniem biblioteki Rest Assured")
    public void firstTest() {
        given()
//                .contentType(ContentType.JSON)
                .spec(requestSpecBuilder)
                .when()
//                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .get("/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));
    }

    @Test
    @Disabled
    @DisplayName("======================Drugi test który się wysypie")
    public void secondTest() {
        given()
                .contentType("application/json")
                .when()
//                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .get("/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("[0].imie", is("Piotr"))
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"))
                .body("[0].device[0].device.model[0].producec", equalTo("dell"));
    }

    @Test
    @DisplayName("======================Trzeci test, użycie JsonPath")
    public void SimpleTest() {
        JsonPath jsonPath = RestAssured.given()
                .when()
//                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .get("/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        MyObj myObj = jsonPath.getObject("", MyObj.class);

        assertThat(myObj.name).isEqualTo("Piotr");
        assertThat(myObj.surname).isEqualTo("Kowalski");

        System.out.println(myObj.toString());
    }

    @Test
    @DisplayName("======================Test z użyciem JsonPath")
    public void restTest() {
        JsonPath jsonPath = RestAssured.given()
                .when()
//                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .get("/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().body().jsonPath();

        List<User> users = jsonPath.getList("", User.class);

        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce).isEqualTo("dell");
        System.out.println(users.toString());
    }

    @Test
    @DisplayName("======================Testy z wykorzystaniem biblioteki Rest Assured")
    public void nextTest() {
        Response response = given()
                .contentType("application/json")
                .when()
//                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .get("/5a6b69ec3100009d211b8aeb")
                .andReturn();

        MyObj myObj = response
                .then()
                .extract()
                .body()
                .as(MyObj.class);

        System.out.println(myObj.toString());

        assertThat(myObj.name).isEqualTo("Piotr");
        assertThat(myObj.surname).isEqualTo("Kowalski");
    }


    @Test
    @DisplayName("======================Testy z wykorzystaniem biblioteki Rest Assured")
    public void restAssuredSerializedTest() throws IOException {

        Response response = given()
                .contentType("application/json")
                .when()
//                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .get("/5a6a58222e0000d0377a7789")
                .andReturn();

        List<User> users = Arrays.asList(response.then().extract().body()
                .as(User[].class));

        System.out.println(users.get(0).toString());
        System.out.println(users.get(0).device.get(0).deviceModel.get(0).toString());

        assertTrue(response.contentType().equals("application/json"));
        assertThat(users.get(0).device.get(0).type).isEqualTo("computer");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce).isEqualTo("dell");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screen_size).isEqualTo("17");
    }


    @Test
    @DisplayName("======================Error test")
    public void errorTest() {
        Response response = given()
                .contentType("application/json")
                .when()
//                .get("http://www.mocky.io/v2/5a690b452e000054007a73cd")
                .get("/5a690b452e000054007a73cd")
                .andReturn();

        ErrorResponse errorResponse = response
                .then()
                .extract()
                .body()
                .as(ErrorResponse.class);

        System.out.println(errorResponse.toString());

        assertThat(errorResponse.error.error_code == 400);
        assertThat(errorResponse.error.validation_erro).isEqualTo("invalid_email");
        assertThat(errorResponse.error.message).isEqualTo("your email is invalid");
    }


    @Test
    @DisplayName("======================Testy z użyciem  RequestSpecBuilder")
    public void specBuiilderTest() {

        //przenosimy do Configa
//        RequestSpecification requestSpecBuilder = new RequestSpecBuilder()
//                .addCookie("cookie")
//                .addHeader("Authorization", "autoryzacja")
//                .setContentType(ContentType.JSON)
//                .setBaseUri("http://www.mocky.io/v2/")
//                .build();

        Response response = given()
                .spec(requestSpecBuilder)
                .when()
//                .get("http://www.mocky.io/v2//5a6b77973100009d211b8b0d")
                .get("/5a6b77973100009d211b8b0d")
                .andReturn();

        MyObj myObj = response
                .then()
                .extract()
                .body()
                .as(MyObj.class);

        assertThat(myObj.name).isEqualTo("Piotr");
    }

    @Test
    @DisplayName("======================Test na posta")
    public void postTest() {

        Response response =
                given()
                        .spec(requestSpecBuilder)
                        .when()
                        .body(new MyObj("Rafal", "Wrobel"))
                        .post("/5a690a1b2e000051007a73cb")
                        .andReturn();

        String responsePost = Arrays.asList(response
                .then()
                .statusCode(201)
                .extract()
                .body()
                .as(String[].class)).toString();

        System.out.println(responsePost.toString());

        assertThat(responsePost).isEqualTo("[]");
    }

    @Test
    @DisplayName("======================Test na JsonSchema")
    public void jsonSchemaTest() {
        Response response = given()
                .spec(requestSpecBuilder)
                .when()
//                .get("http://www.mocky.io/v2/5a690b452e000054007a73cd")
                .get("/5a690b452e000054007a73cd")
                .andReturn();

        response
                .then()
                .assertThat()
                .body(matchesJsonSchema(new File("src/test/java/resources/schema/validation.json")));
    }

    @Test
    @DisplayName("======================Test na JsonSchema")
    public void jsonSchemaArrayTest() throws IOException {
        Response response = given()
                .spec(requestSpecBuilder)
                .when()
//                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .get("/5a6a58222e0000d0377a7789")
                .andReturn();

        response
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemaUser.json"));
    }
}