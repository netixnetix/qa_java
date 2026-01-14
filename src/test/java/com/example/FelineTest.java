package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FelineTest {
    @Mock
    private Animal mockAnimal;

    @Spy
    private Feline spyFeline;

    Feline feline = new Feline();


    @Test
    void eatMeatShouldReturnExpectedFood() throws Exception {
        List<String> expectedFood = List.of("Мясо");
        doReturn(expectedFood).when(spyFeline).getFood("Хищник");
        assertEquals(expectedFood, spyFeline.eatMeat());
        verify(spyFeline).getFood("Хищник");
    }


    @Test
    void getFamilyReturnCatsFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensReturnsCorrectCountForGivenParameter() {
        assertEquals(2, feline.getKittens(2));
    }

    @Test
    void getKittens_verifyCallMethod() {
        spyFeline.getKittens();
        verify(spyFeline).getKittens(1);
        assertEquals(1, spyFeline.getKittens());

    }

}