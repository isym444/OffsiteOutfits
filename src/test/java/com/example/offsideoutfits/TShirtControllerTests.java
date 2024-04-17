package com.example.offsideoutfits;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.offsideoutfits.controller.TShirtController;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.TShirtRepository;
import com.example.offsideoutfits.service.TShirtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;

import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

//@SpringBootTest
//The below annotation initializes fields annotated with @Mock @Spy etc. so you don't have to manually create them with Mockito.mock()
//Then it injects them with needed i.e. executes the @InjectMocks annotation
//Cleans up mocks after test is run
@ExtendWith(MockitoExtension.class)
public class TShirtControllerTests {

    //The @Mock annotation means you don't have to manually do something like tShirtRepository = Mockito.mock(TShirtRepository.class)
    @Mock
    private TShirtRepository mocktShirtRepository;

//    Spies are also injected automatically into the object annotated with @InjectMocks
//    @Spy
//    private TShirtRepository spytShirtRepository;

    @Mock
    private TShirtService tShirtService;

    //InjectMocks provides mocks like tShirtRepository into the tShirtController to use
    @InjectMocks
    private TShirtController tShirtController;

    private List<TShirt> mockList;

    @BeforeEach
    public void setUp() {
        mockList = Arrays.asList(new TShirt(), new TShirt());
//        tShirtRepository = Mockito.mock(TShirtRepository.class);
        //creates stub
        when(mocktShirtRepository.findAll()).thenReturn(mockList);
//        when(spytShirtRepository.findAll()).thenReturn(mockList);
    }

    @Test
    public void testMockGetAllTshirts() {
        // Act
        List<TShirt> result = tShirtController.getAllTshirts();
        // Assert
        verify(mocktShirtRepository, times(1)).findAll();
//        verify(spytShirtRepository, times(1)).findAll();
        assertEquals(mockList, result);
        assertEquals(1,1);
    }

    @Test
    public void testSpyGetAllTshirts() {

    }
}