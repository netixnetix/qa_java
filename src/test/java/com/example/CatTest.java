package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    Predator mockPredator;
    Cat cat;

    @BeforeEach
    void setup(){
        cat = new Cat(mockPredator);

    }

    @Test
    void getSoundReturnSoundMya() {
        cat.getSound();
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodReturnValidValue () throws Exception {
        List<String> catEat = List.of("Рыба", "Птица");
        when(mockPredator.eatMeat()).thenReturn(catEat);
        assertEquals(catEat,cat.getFood());
    }

    @Test
    void getFoodReturnException() throws Exception {
        when(mockPredator.eatMeat()).thenThrow(new Exception("Невозможно получить еду для кота"));
        assertThrows(Exception.class, () -> cat.getFood(), "Невозможно получить еду для кота" );
    }
}
