package com.jsystems.JunitTests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.jsystems.service.Person;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class ExpectedExceptionTest extends ConfigJUnit {



    @Test(expected = ArithmeticException.class)
    public void testDivisionWithException() {
        int i = 1 / 1;
    }

    @Test(expected = IndexOutOfBoundsException.class)
//    @Ignore
    public void testEmptyList() {
        List<String> listaStringow = new ArrayList<String>();
        assertTrue(listaStringow.get(0).equals("aasdasdsd"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpectedException1() {
        new Person("Joe", -1);
    }


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testExpectedException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(containsString("Invalid age"));
        new Person("Joe", -1);
    }

    @Test
    public void testExpectedException3() {
        try {
            new Person("Joe", -1);
            fail("Should have thrown an IllegalArgumentException because age is invalid!");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Invalid age"));
        }
    }
}