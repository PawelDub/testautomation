package com.jsystems.Mockito;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class MockitoConfig {


    @BeforeClass
    public static void beforeClass(){
        System.out.println("========================= @BeforeClass Mockito ==================");

    }

    @Before
    public void setUp(){
        System.out.println("========================= @Before Mockito ==================");
    }

    @After
    public void tearDown(){
        System.out.println("========================= @After Mockito ==================");

    }

    @AfterClass
    public static void afterClass(){
        System.out.println("========================= @AfterClass Mockito ==================");

    }

}
