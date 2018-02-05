package com.jsystems.junitTests;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.params.provider.ValueSource;

import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//@RunWith(JUnitPlatform.class)

@DisplayName("=======Nad klasą główną to są testy sparametryzowane jupiterem ==========")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParametrizedJupiterTest extends ConfigJUnit {

    @Nested
    @DisplayName("======= to są testy sparametryzowane jupiterem ==========")
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

        @ParameterizedTest
        @ValueSource(strings = {"Hello", "JUnitlo"})
        void withValueSource(String word) {
            assertTrue(word.contains("lo"));
        }

        @ParameterizedTest
        @ValueSource(strings = {"55", "5"})
        public void withValueSource2(String word) {
            assertTrue(word.contains("5"));
//            int a = Integer.parseInt(word);
//            assertTrue(a == 5);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 3, 5})
        void testWithValueSource(int argument) {
            assertTrue(argument % 2 != 0);
        }

        @ParameterizedTest
        @ValueSource(longs = {2, 4, 6})
        public void withValueLongs(long digit) {
            assertTrue(digit % 2 == 0);
        }



    }

    @Nested
    @DisplayName("======== TO są kolejne scenariusze testów ===========")
    public class JupiterNestedSecondTest {
        String testowy = "testowyString";

        @ParameterizedTest
        @CsvFileSource(resources = "/plik.csv")
        public void withFile(String name, Integer age) {
            System.out.println(name);
            System.out.println(age);
            assertTrue(name instanceof String);
            assertTrue(name.contains("a"));
            assertTrue(age instanceof Integer);
        }

        @Test
        public void toJestTest() {
            assertTrue(true == true);
        }

        @Test
        public void toJestNextTest() {
            assertThat("to jest tekst", testowy, containsString("String"));
        }
    }

}
