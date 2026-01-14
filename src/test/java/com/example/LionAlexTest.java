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
class LionAlexTest  {
    @Mock
    Predator predatorMock;
    LionAlex alex;

    @BeforeEach
    void setUp() throws Exception {
        alex = LionAlex.create(predatorMock);
    }

    @Test
    void create_returnsLionAlexInstanceWhenNoException() {
        assertNotNull(alex);
    }

    @Test
    void getFriends_returnValidFreindsName() {
        assertEquals(List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман"), alex.getFriends());
    }

    @Test
    void getPlaceOfLiving_returnNYzoo() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void getKittens_returnsValueFromParentWithZeroArgument() {
        when(predatorMock.getKittens(0)).thenReturn(0);
        assertEquals(0, alex.getKittens());
        verify(predatorMock).getKittens(0);

    }

}