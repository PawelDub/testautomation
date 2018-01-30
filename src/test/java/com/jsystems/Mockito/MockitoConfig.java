package com.jsystems.Mockito;

import com.jsystems.MockitoPacket.UserMock;
import com.jsystems.MockitoPacket.service.UserImplement;
import com.jsystems.MockitoPacket.service.UserService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

public class MockitoConfig {


    @BeforeClass
    public static void beforeClass() {
        System.out.println("========================= @BeforeClass Mockito ==================");

    }

    @Mock
    public UserService userService;

    @Mock
    public UserImplement userImplement;

    @Mock
    List<String> mockedList;

    @Mock
    Map<String, String> wordMap;

    @InjectMocks
    MyDictionary dic = new MyDictionary();



    UserMock userMockFranek = new UserMock(1, "Franek", "Kimono");
    UserMock userMockAdam = new UserMock(2, "Adam", "Kurka");
    UserMock userMockJanina = new UserMock(3, "Janina", "Wiosna");
    List<UserMock> userMocks = Arrays.asList(userMockAdam, userMockFranek, userMockJanina);
    List<String> userMocksSpy = Mockito.spy(new ArrayList<String>());




    @Before
    public void setUp() {
        System.out.println("========================= @Before Mockito ==================");
//        MockitoAnnotations.initMocks(this);
        setMocks();
//        mock(UserImplement.class);

        userMocksSpy.add("Kamil");
        userMocksSpy.add("Kamila");



    }

    @After
    public void tearDown() {
        System.out.println("========================= @After Mockito ==================");

    }

    @AfterClass
    public static void afterClass() {
        System.out.println("========================= @AfterClass Mockito ==================");

    }

    public void setMocks() {
        userService = new UserService();
//        Mockito.when(userService.getOne(1).getId()).thenReturn(15);
//        Mockito.when(userService.getOne(1)).thenReturn(userMockFranek);
//        Mockito.when(userService.getOne(1).getName()).thenReturn("Iwona");
        Mockito.when(userService.getAll().size()).thenReturn(10);
        Mockito.when(userService.getAll()).thenReturn(userMocks);
        Mockito.when(mockedList.size()).thenReturn(100);
        Mockito.when(userImplement.getId()).thenReturn(156);
        Mockito.when(userImplement.getName()).thenReturn("Jolka");
        Mockito.when(userImplement.getSurname()).thenReturn("Witowski");
        Mockito.when(userImplement.isValid(anyString())).thenReturn(true);
//
        Mockito.verify(userService,Mockito.times(1));
        Mockito.verify(userService.getAll(), Mockito.atLeast(1));
        Mockito.verify(mockedList.size());
//
        Mockito.when(userMocksSpy.size()).thenReturn(1665);
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

        Mockito.when(userService.getOneAdamNumber(anyInt())).thenReturn("Numer Adama wynosi 1" + anyInt());
    }

}
