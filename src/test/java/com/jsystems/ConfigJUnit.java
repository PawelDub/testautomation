package com.jsystems;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.Suite;

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
        System.out.println("@BeforeAll");
    }

    @Before
    public void setUp() {
        System.out.println("@Before");
    }

    @BeforeClass
    public static void init() {
        System.out.println("@BeforeClass");
    }

    @BeforeEach
    public void beforeTest() {  //nie mogą być statyczne
        System.out.println("@BeforeEach");
    }


    @After
    public void tearDown(){
        System.out.println("@After");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("@AfterAll");
    }


}
