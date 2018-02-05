package com.jsystems.junitTests;

import com.jsystems.validator.PhoneValidator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.custom.combined.CombinedParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(JUnitParamsRunner.class)
public class ParametrizedJUnitTest extends ConfigJUnit {

    private PhoneValidator phoneValidator;


    @Test        // parametry
    @Parameters({"1234567890", "123-456-7890", "(123)-456-7890", "123.456.7890", "123 456 7890", "123-456-7890 x1234", "123-456-7890 ext1234"})
    public void shouldPhoneIsTrue(String phone) throws Exception {
        System.out.println("=== test na true dla phone");
        assertTrue(phoneValidator.validatePhoneNumber(phone));
    }

    @Test        // parametry
    @Parameters({"1234567890T", "123-456--7890", "(123)-456/-7890", "123.456..7890", "123 456   7890", "123-456-7890 xx1234", "123@-456-7890 ext1234"})
    public void ShouldPhoneIsFalse(String phone) throws Exception {
        System.out.println("=== test na true dla phone");
        assertFalse(phoneValidator.validatePhoneNumber(phone));
    }


    @Test
    @CombinedParameters({"1,3", "1,3"})
    public void combinedParameters(String first, String second) {
        System.out.println("=== test na true dla combined parameters");
        String result = first +second;
        System.out.println(result);
        assertTrue(result.contains("1") || result.contains("3"));

        Integer c = Integer.valueOf(first);
        Integer d = Integer.valueOf(second);
        Integer e = c*d;
        assertTrue(e == 1 || e == 3 || e == 9);
    }

    @Test
    @CombinedParameters({"1,2", "Ela,Adam"})
    public void combinedParameters2(String first, String second) {
        System.out.println("=== test na true dla combined parameters test2");
        String result = first +second;
        assertTrue(result.contains("1") || result.contains("2"));

        Integer c = Integer.valueOf(first);
        assertTrue((c == 1 || c == 2) && (second.equals("Ela") || second.equals("Adam")) );
    }

}

