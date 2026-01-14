package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LionParameterizedTest {

    @Mock
    Predator mockPredator;

    @ParameterizedTest
    @ValueSource(strings = {"Самоед", "", " ", "самка", "самец", "Самка Самец" })
    void constructor_whenSexIsNotValidValue_returnException(String sex) throws Exception{
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion(sex, mockPredator);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, Integer.MAX_VALUE})
    void getKittens_callPredatorGetKittensForGivenParameter(int kittensCount) throws Exception {
        when(mockPredator.getKittens(kittensCount)).thenReturn(kittensCount);
        Lion lion = new Lion("Самец", mockPredator);
        assertEquals(kittensCount, lion.getKittens(kittensCount));
        verify(mockPredator).getKittens(kittensCount);

    }
}
