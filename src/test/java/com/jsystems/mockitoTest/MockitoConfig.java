package com.jsystems.mockitoTest;

import com.jsystems.mockitoPacket.TestUser;
import com.jsystems.service.UserImplement;
import com.jsystems.service.jdbcService.UserServiceDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

public class MockitoConfig {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("========================= @BeforeClass mockito ==================");
    }

    @Mock
    public UserServiceDao userService;

    @Mock
    public UserImplement userImplement;

    @Mock
    List<String> mockedList;

    @Mock
    Map<String, String> wordMap;

    @InjectMocks
    MyDictionary dic = new MyDictionary();

    TestUser userMockFranek = new TestUser(1l, "Franek", "Kimono");
    TestUser userMockAdam = new TestUser(2l, "Adam", "Kurka");
    TestUser userMockJanina = new TestUser(3l, "Janina", "Wiosna");
    List<TestUser> usersMocks = Arrays.asList(userMockAdam, userMockFranek, userMockJanina);

    @Mock
    List<String> userMocksSpy = Mockito.spy(new ArrayList<String>());

    @Before
    public void setUp() {
        System.out.println("========================= @Before mockito ==================");
//        MockitoAnnotations.initMocks(this);
//        userService = mock(UserServiceDao.class);
//        userImplement = mock(UserImplement.class);
        userMocksSpy.add("Kamil");
        userMocksSpy.add("Kamila");

        setMocks();
    }

    @After
    public void tearDown(){
        System.out.println("========================= @After mockito ==================");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("========================= @AfterClass mockito ==================");
    }

    public void setMocks() {
//        userService = new UserServiceDao();
        Mockito.when(userService.getOne(1l)).thenReturn(userMockFranek);
        Mockito.when(userService.getAll()).thenReturn(usersMocks);
        Mockito.when(mockedList.size()).thenReturn(100);
        Mockito.when(userImplement.getId()).thenReturn(156);
        Mockito.when(userImplement.getName()).thenReturn("Jolka");
        Mockito.when(userImplement.getSurname()).thenReturn("Witowski");
        Mockito.when(userImplement.isValid(anyString())).thenReturn(true);

        Mockito.when(userMocksSpy.size()).thenReturn(1665);
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

        Mockito.when(userService.getOneAdamNumber(anyInt())).thenReturn("Numer Adama wynosi 1");
    }
}