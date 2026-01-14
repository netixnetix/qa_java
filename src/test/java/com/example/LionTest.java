package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Predator mockPredator;

    @Test
    void getKittens_callPredatorGetKittens() throws Exception {
        when(mockPredator.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", mockPredator);
        assertEquals(1, lion.getKittens());
        verify(mockPredator).getKittens();
    }

    @Test
    void constructor_whenSexIsMale_setsHasManeTrue() throws Exception{
        Lion lion = new Lion("Самец", mockPredator);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void constructor_whenSexIsFemale_setsHasManeFalse() throws Exception{
        Lion lion = new Lion("Самка", mockPredator);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void getFood_WhenCalled_ReturnsValidMeatList() throws Exception {
        Lion lion = new Lion("Самка", mockPredator);
        List<String> lionEat = List.of("Животные", "Птицы", "Рыба");
        when(mockPredator.eatMeat()).thenReturn(lionEat);
        assertEquals(lionEat, lion.getFood());
        verify(mockPredator, times(1)).eatMeat();
        verifyNoMoreInteractions(mockPredator);
    }

    @Test
    void getFood_WhenCalled_ReturnsException() throws Exception {
        Lion lion = new Lion("Самец", mockPredator);
        when(mockPredator.eatMeat()).thenThrow(new Exception("Невозможно получить еду для Льва"));
        assertThrows(Exception.class, lion::getFood, "Невозможно получить еду для Льва");
    }

}