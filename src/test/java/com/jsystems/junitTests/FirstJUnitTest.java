package com.jsystems.junitTests;

import com.jsystems.mockitoPacket.UserMock;
import com.jsystems.service.UserService;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;


public class FirstJUnitTest extends ConfigJUnit {

    @Test
    @DisplayName("======== To jest pierwszy test ===============")
    @RepeatedTest(5)
    public void firstJUnitTest() {
        System.out.println("############ test 1 ##################");


        String testowy = "firstTest";
        Integer dd = 5;
        assertTrue("message from True", testowy.equals("firstTest"));
        assertTrue("message from True", 5 == (2 + 3));
        assertFalse("message from False", testowy.equals("Adam"));
        assertThat("message from That", testowy, is("firstTest"));
        assertEquals("message from Equals", testowy, "firstTest");
        assertSame("message from Same", testowy, "firstTest");
        assertThat("message from That", testowy, containsString("Test"));
        assertThat("message from True", testowy, equalTo("firstTest"));
        assertThat("message from True", testowy, endsWith("t"));
    }


    static List<Integer> integery = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    @DisplayName("================= To jest drugi test =================================")
    public void secondJUnitTest() {
        System.out.println("############ test 2 ##################");
        String testowy = "firstTest";
        Integer dd = 5;
        assertTrue(testowy.equals("firstTest"));
        assertTrue(5 == (2 + 3));
        assertFalse(testowy.equals("Adam"));
        assertThat(testowy, is("firstTest"));
        assertEquals(testowy, "firstTest");
        assertSame(testowy, "firstTest");
        assertThat(testowy, containsString("Test"));
        assertThat(testowy, equalTo("firstTest"));
        assertThat(integery, hasItem(5));
        assertThat(integery, hasItem(5));
        assertThat(integery, hasItem(5));
    }

    @Test
    @DisplayName("======= To jest trzeci test: Listy")
    public void firdTest() {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list1a = Arrays.asList(1,2,3,4,5);
        List<String> list2 = Arrays.asList("Ewa", "Adam", "Iwona", "Robert", "Tomek");
        List<String> list2a = Arrays.asList("Ewa", "Adam", "Iwona");
        List<String> list3 = new ArrayList<String>();

        assertArrayEquals(list1.toArray(), list1a.toArray());
        assertThat(list2, hasSize(5));
        assertThat(list1, not(containsInAnyOrder(1, 2, 3)));
        assertThat(list2, not(IsEmptyCollection.empty()));
        assertThat(list3, IsEmptyCollection.empty());
        assertTrue(list2.containsAll(list2a));
        assertTrue(true == true);
    }




        UserService userService = new UserService();
    @Test
    @DisplayName("JDBC")
    public void getUserMockTest(){
//
        UserMock userMock = userService.getOne(1l);
        System.out.println(userMock.toString());

        List<UserMock> userMocks = new ArrayList<UserMock>();

        userMocks = userService.getAll();
        System.out.println(userMocks.toString());

//        userService.saveOne(new UserMock(4, "Roman", "Romanowski"));

//        userService.delete(4);

    }

}
