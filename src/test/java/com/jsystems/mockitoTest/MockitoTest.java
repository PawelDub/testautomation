package com.jsystems.mockitoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest extends MockitoConfig {


    @Test
    public void testMockito(){
        assertTrue(userService.getOne(1l).getId() == 1);
        assertTrue(userService.getAll().equals(userMocks));
        assertTrue(userService.getAll().size() == 3);
        assertTrue(userService.getOne(1l).getName().equals("Franek"));

        Mockito.verify(userService,Mockito.atLeastOnce()).getAll();
        Mockito.verify(userService, Mockito.atLeast(2)).getAll();

    }

    @Test
    public void secondTestMockito(){
        assertEquals(mockedList.size(), 100);
        assertTrue(userImplement.getId() == 156);
        assertTrue(userImplement.getName().equals("Jolka"));
        assertTrue(userImplement.getSurname().equals("Witowski"));
        assertTrue(userImplement.isValid("String") == true);

        assertEquals("aMeaning", dic.getMeaning("aWord"));

        assertTrue(userMocksSpy.size() == 1665);

        assertTrue(userService.getOneAdamNumber(1).equals("Numer Adama wynosi 1"));

        Mockito.verify(mockedList,Mockito.times(1)).size();
    }

}
