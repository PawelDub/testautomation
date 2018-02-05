package com.jsystems.junitTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ConfigJUnit{

        /*
    @Before
    @BeforeClass +static
    @BeforeEach

    @After
    @AfterClass
    @AfterEach
     */

    @BeforeAll
    public static void beforeAll() {  //muszą być statyczne
        System.out.println("====================== @BeforeAll Backend JUpiter");
    }

    @Before
    public void setUp() {
        System.out.println("@Before Backend JUnit");
    }

    @BeforeClass
    public static void init() {
        System.out.println("@BeforeClass Backend  JUnit");
    }

    @BeforeEach
    public void beforeTest() {  //nie mogą być statyczne
        System.out.println("@BeforeEach Backend JUpiter");
    }


    @After
    public void tearDown(){
        System.out.println("@After Backend");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass Backend");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("@AfterEach Backend");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("@AfterAll Backend");
    }


}
