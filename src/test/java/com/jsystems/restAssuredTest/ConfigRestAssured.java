package com.jsystems.restAssuredTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
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
    System.out.println("================== @BeforeClass RestTest JUpiter =====================");

}
    @BeforeAll
    public static void setUp(){
        System.out.println("================== @BeforeAll RestTest JUpiter =====================");

        RestAssured.baseURI = TestData.baseUri;
        RestAssured.basePath = "/v2";
    }
}
