package com.jsystems.restAssuredTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ConfigRestAssured {

    static RequestSpecification requestSpecBuilder = new RequestSpecBuilder()
//                .addCookie("cookie")
//                .addHeader("Authorization", "autoryzacja")
            .setContentType(ContentType.JSON)
            .setBaseUri(TestData.baseUri)
            .setBasePath("/v2")
            .build();

    RequestSpecification requestSpecBuilderWithContentHtml = new RequestSpecBuilder()
//                .addCookie("cookie")
//                .addHeader("Authorization", "autoryzacja")
            .setContentType(ContentType.HTML)
            .setBaseUri(TestData.baseUri)
            .setBasePath("/v2/")
            .build();


    RequestSpecification requestSpecBuilderWithAuthorization = new RequestSpecBuilder()
//                .addCookie("cookie")
                .addHeader("Authorization", "api,1234567890")
            .setContentType(ContentType.JSON)
            .setBaseUri(TestData.baseUri)
                .setBasePath("/v2/")
            .build();

    RequestSpecification requestSpecBuilderFaker = new RequestSpecBuilder()
//                .addCookie("cookie")
            .setContentType(ContentType.JSON)
            .setBaseUri("http://fakerestapi.azurewebsites.net")
//                .setBasePath("/v2/")
            .build();

    @BeforeEach
    public void before() {
        System.out.println("================== @BeforeClass RestTest JUpiter =====================");
    }

    @BeforeAll
    public static void setUp() {
        System.out.println("================== @BeforeAll RestTest JUpiter =====================");

//        RestAssured.baseURI = TestData.baseUri;
//        RestAssured.basePath = "/v2";

    }
}