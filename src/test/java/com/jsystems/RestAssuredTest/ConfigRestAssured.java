package com.jsystems.RestAssuredTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ConfigRestAssured {


        RequestSpecification requestSpecBuilder = new RequestSpecBuilder()
//                .addCookie("cookie")
//                .addHeader("Authorization", "autoryzacja")
                .setContentType(ContentType.JSON)
//                .setBasePath("/v2/")
                .build();

@BeforeEach
public void before(){
    System.out.println("================== @BeforeClass RestTest =====================");

}
    @BeforeAll
    public static void setUp(){
        System.out.println("================== @BeforeClass RestTest =====================");

        RestAssured.baseURI = TestData.baseUri;
        RestAssured.basePath = "/v2";
    }
}
