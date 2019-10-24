package com.jsystems.restAssuredTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsystems.models.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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
     void firstTest() {
        given()
                .spec(requestSpecBuilder)
//                .contentType("application/json")
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
//                .contentType("application/json")
                .spec(requestSpecBuilder)
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
                .body("[0].device[0].device.model[0].produce", equalTo("dell"));
    }

    @Test
    @DisplayName("======================Trzeci test, użycie JsonPath")
    public void SimpleTest() {
        JsonPath jsonPath = RestAssured
                .given()
                .spec(requestSpecBuilder)
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
        JsonPath jsonPath = RestAssured
                .given()
                .spec(requestSpecBuilder)
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
                .spec(requestSpecBuilder)
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
    public void restAssuredSerializedTest() {

        Response response = given()
                .spec(requestSpecBuilder)
                .when()
//                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .get("/5a6a58222e0000d0377a7789")
                .andReturn();

        User[] usersTab = response
                .then()
                .extract()
                .body()
                .as(User[].class);

        List<User> users = Arrays.asList(usersTab);

        System.out.println(users.get(0).toString());
        System.out.println(users.get(0).device.get(0).deviceModel.get(0).toString());

        assertTrue(response.contentType().equals("application/json"));
        assertThat(users.get(0).device.get(0).type).isEqualTo("computer");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce).isEqualTo("dell");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screen_size).isEqualTo("17");
        assertTrue(response.getHeader("Content-type").equals("application/json"));
    }


    @Test
    @DisplayName("======================Error test")
    public void errorTest() {
        Response response = given()
                .spec(requestSpecBuilder)
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
        assertThat(errorResponse.error.validationErro).isEqualTo("invalid_email");
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
                .spec(requestSpecBuilderWithContentHtml)
                .contentType(ContentType.HTML)
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
    @DisplayName("====================== Test na posta")
    public void postTest() {

        Response response =
                given()
                        .spec(requestSpecBuilder)
                        .when()
                        .body(new MyObj("Rafal", "Wrobel"))
                        .post("/5a690a1b2e000051007a73cb")
                        .andReturn();

        String[] responsePost = response
                .then()
                .statusCode(201)
                .extract()
                .body()
                .as(String[].class);

        System.out.println(responsePost);

        assertThat(responsePost).isEmpty();
    }

    @Test
    @DisplayName("Test for mapping response to the reference type")
    public void genericTypeTest() throws IOException {
        Response response = given()
                .spec(requestSpecBuilder)
                .when()
//                .get("http://www.mocky.io/v2/5b05bf3f3200007100ebfa04")
                .get("/5b05bf3f3200007100ebfa04")
                .andReturn();
        System.out.println(response
                .then()
                .extract()
                .body().toString());

        ObjectMapper objectMapper = new ObjectMapper();

        TestUserGeneric<Integer> testUserGeneric = objectMapper.readValue(response
                .then()
                .extract()
                .body().asInputStream(), new TypeReference<TestUserGeneric<Integer>>() {
        });

        System.out.println(testUserGeneric);
    }

    @Test
    @DisplayName("Test for mapping response to the reference type 2")
    public void genericTypeTestNext() throws IOException {
        Response response = given()
                .spec(requestSpecBuilder)
                .when()
//                .get("http://www.mocky.io/v2/5b05c83e3200009700ebfa2b")
                .get("/5b05c83e3200009700ebfa2b")
                .andReturn();

        TestUserGeneric<String> testUserGeneric = new ObjectMapper().readValue(response
                .then()
                .extract()
                .body()
                .asInputStream(), new TypeReference<TestUserGeneric<String>>(){});

        System.out.println(testUserGeneric);
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
    public void jsonSchemaArrayTest() {
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

    @Test
    @DisplayName("Test with Authorization")
    public void getWithAuthorization() {

        Response response = given()
                .spec(requestSpecBuilderWithAuthorization)
                .when()
                .get("/5b008c113100007e0076df9d")
                .andReturn();

        MyObj myObj = response
                .then()
                .extract()
                .body()
                .as(MyObj.class);

        System.out.println(response.getBody().prettyPeek());
        System.out.println(myObj.toString());
        assertTrue(myObj.name.equals("irek"));
    }

    @Test
    @DisplayName("GET /api/Books  - Tests of Books")
    public void getBooks() {

        Response response = given()
                .spec(requestSpecBuilderFaker)
                .when()
                .get("/api/Books")
                .andReturn();

        List<Book> books = Arrays.asList(response
                .then()
                .extract()
                .body()
                .as(Book[].class));
        System.out.println(books.get(0).publishDate);
        assertTrue(books.get(0).id == 1);
        assertThat(books.get(0).publishDate);
    }

    @Test
    @DisplayName("GET /api/Books  - Tests of Books")
    public void getBookById() {
        Response response = given()
                .spec(requestSpecBuilderFaker)
                .when()
                .get("/api/Books/{id}", 1)
                .andReturn();

        assertThat(response.contentType()).isEqualTo(ContentType.JSON);
        assertThat(response.getSessionId()).isEqualTo("sessionId");
        assertThat(response.getCookie("cookie")).isEqualTo("firstCookie");
        assertThat(response.getHeader("name")).isEqualTo("value");

        Book books = response
                .then()
                .extract()
                .body()
                .as(Book.class);

        assertTrue(books.id == 1);
    }
}