package org.iti.app_test;

import org.iti.app.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTests {
    private MyStack myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack();
    }

    @Test
    void testPushElementsToStack() {
        assertTrue(myStack.isEmpty());
        myStack.push(1)
                .push(2)
                .push(3)
                .push(400)
                .push(500);

        assertEquals(5, myStack.getSize());
        assertEquals(500, myStack.getPeek());
        assertEquals(List.of(1, 2, 3, 400, 500), myStack.getAllStackElements());
    }

    @Test
    void testPopElementsFromStack() {
        assertTrue(myStack.isEmpty());
        IllegalStateException ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.pop());
        assertEquals("Stack is Empty", ex.getMessage());

        myStack.push(1)
                .push(2)
                .push(3)
                .push(400)
                .push(500);

        assertEquals(500, myStack.getPeek());
        assertEquals(500, myStack.pop());
        assertEquals(4, myStack.getSize());
        assertEquals(400, myStack.getPeek());
        assertEquals(List.of(1, 2, 3, 400), myStack.getAllStackElements());
    }

    @Test
    void testPeekElementFromStack() {
        assertTrue(myStack.isEmpty());
        IllegalStateException ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.getPeek());
        assertEquals("Stack is Empty", ex.getMessage());

        /*myStack.push(1)
                .push(2)
                .push(1000)
                .push(400)
                .push(500);*/

        myStack.pushAll(List.of(1,2,1000,400,500));

        assertEquals(500, myStack.getPeek());
        myStack.pop();
        myStack.pop();
        assertEquals(3, myStack.getSize());
        assertEquals(1000, myStack.getPeek());
        myStack.push(4000);
        assertEquals(4000, myStack.getPeek());

    }


}
