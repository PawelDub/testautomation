package com.jsystems.Mockito;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@RunWith(MockitoJUnitRunner.class)
public class MockitoTests extends MockitoConfig {


    @Test
    public void testMockito(){
        assertTrue(userService.getOne(1).equals(userMockAdam));
        assertTrue(userService.getAll().equals(userMocks));
        assertTrue(userService.getAll().size() == 10);
        assertTrue(userService.getOne(1).equals("Iwona"));


    }

    @Test
    public void secondTestMockito(){
        assertEquals(mockedList.size(), 100);
        assertEquals("aMeaning", dic.getMeaning("aWord"));

    }

}
