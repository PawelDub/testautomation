package com.jsystems.JunitTests;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ParametrizedJupiterTest extends ConfigJUnit {

    @Nested
    @DisplayName("======= to są testy sparametryzowane jupiterm ==========")
    public class JupiterParameterizedTest {


        @DisplayName("====== first parametrized test ======")
//        @Disabled
        @ParameterizedTest
        @CsvSource({"Hello, 5", "JUnit 5, 7", "'Hello, JUnit 5!', 15"})
        public void shouldPhoneIsTrue(String tekst, int liczba) throws Exception {
            System.out.println("=== test na true dla phone");
            List<String> listaStringow = Arrays.asList("Hello", "JUnit 5", "Hello, JUnit 5!");
            List<Integer> listaIntegerow = Arrays.asList(5, 7, 15);

            assertTrue(listaStringow.contains(tekst));
            assertTrue(listaIntegerow.contains(liczba));
        }

        @DisplayName("====== Second parametrized test ======")
        @ParameterizedTest
        @CsvSource({"Hello, 5", "JUnit 5, 7", "'Hello, JUnit 5!', 15"})
        public void ShouldPhoneIsFalse(String tekst, int length) throws Exception {
            List<String> listaStringow = Arrays.asList("Hello", "JUnit 5", "Hello, JUnit 5!");
            List<Integer> listaIntegerow = Arrays.asList(5, 7, 15);
            System.out.println("=== test na true dla phone");

            assertFalse(listaStringow.equals(tekst));
            assertFalse(listaIntegerow.equals(length));
        }
    }

    @Nested
    @DisplayName("======== TO są kolejne scenariusze testów ===========")
    public class JupiterNestedSecondTest {
        String testowy = "testowyString";

        @Test
        public void toJestTest(){
            assertTrue(true == true);
        }

        @Test
        public void toJestNextTest(){
            assertThat("to jest tekst", testowy, containsString("String"));
        }
    }

}
