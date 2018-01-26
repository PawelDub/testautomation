package com.jsystems.RestAssuredTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

public class ConfigRestAssured {


        RequestSpecification requestSpecBuilder = new RequestSpecBuilder()
//                .addCookie("cookie")
//                .addHeader("Authorization", "autoryzacja")
                .setContentType(ContentType.JSON)
//                .setBasePath("/v2/")
                .build();


    @BeforeAll
    public static void setUp(){

        RestAssured.baseURI = TestData.baseUri;
        RestAssured.basePath = "/v2";
    }
}
