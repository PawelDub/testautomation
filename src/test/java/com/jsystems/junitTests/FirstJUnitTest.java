package com.jsystems.junitTests;

import com.jsystems.models.TestUser;
import com.jsystems.service.jdbcService.UserServiceDao;
import com.jsystems.service.jdbiService.UserServise;
import com.jsystems.service.jdbiService.model.JdbiUser;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;


public class FirstJUnitTest extends ConfigJUnit {

    int repeatedTest = 0;
    @Tag("Repeated") //mvn clean install -Dtests=Repeated
    @Tag("all")      //mvn clean install -PallTests // allTests it is profile in pom file
    @Test
    @DisplayName("======== First JUnit test, to get know assert methods ===============")
    @RepeatedTest(5)
    public void testForToGetKnowAssertMethods() {
        System.out.println("############ test " + ++repeatedTest + " ##################");

        String testowy = "firstTest";
        Integer dd = 5;

        String test = "firstTest";
        String testo = new String("firstTest");


        assertTrue(testowy.equals(testo));
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


    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

    @Tag("all")
    @Test
    @DisplayName("================= Second test to get know matchers methods =================================")
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
        assertThat(integers, hasItem(5));
        assertThat(integers.size(), is(5) );
        assertThat(integers, hasItem(2));
        assertThat(testowy, matchesPattern("^first.*"));
        assertThat("123456789", matchesPattern("^[0-9]+"));

        assertFalse(0.2*0.2 == 0.4);
        System.out.println(0.2*0.2);
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
    }

    @Tag("all")
    @Test
    @DisplayName("======= Third test: Lists")
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
        assertThat(list1, Matchers.hasItem(1));
        assertThat(list3, IsEmptyCollection.empty());
        assertTrue(list2.containsAll(list2a));
        assertTrue(true == true);
    }

    UserServiceDao userServiceDao = new UserServiceDao();

    @Tag("all")
    @Test
    @DisplayName("JDBC")
    public void getUserTest(){
        TestUser testUser = userServiceDao.getOne(1l);
        System.out.println(testUser.toString());
        assertTrue(testUser.getId() == 1);

        List<TestUser> userTest = new ArrayList<TestUser>();

        userTest = userServiceDao.getAll();
        System.out.println(userTest.toString());
        assertTrue(userTest.get(0).getId() == 1);

//        userServiceDao.saveOne(new TestUser(4, "Roman", "Romanowski"));
//        userServiceDao.delete(4);

    }

    @Test
    void getUserTestByJdbi(){
    UserServise userServise = new UserServise();
        System.out.println(UserServise.getTestUser(1l).toString());
        JdbiUser testUser = UserServise.getTestUser(1l);
        assertTrue(testUser.getName().equals("Piotr"));
    }
}