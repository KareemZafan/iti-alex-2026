package org.iti.app_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArrayListTests {

    @Mock
    ArrayList<Integer> list;


    @Test
    void testListSizeGreaterThan5(){
        when(list.size()).thenReturn(50);

        assertEquals(5, list.size());

        verify(list).size();
    }

    @Test
    void testListSalariesGreaterThan1000() {
        when(list.get(10)).thenReturn(2000).thenReturn(20000);

        assertEquals(2000, list.get(10));

        assertEquals(20000, list.get(10));



        verify(list,times(2)).get(10);
    }


}
