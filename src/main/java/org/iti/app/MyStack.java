package org.iti.app;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private ArrayList<Integer> myStackList;

    public MyStack() {
        myStackList = new ArrayList<>();
    }

    public boolean isEmpty() {
        return myStackList.isEmpty();
    }

    public MyStack push(int value) {
        myStackList.add(value);
        return this;
    }

    public MyStack pushAll(List<Integer> values) {
        myStackList.addAll(values);
        return this;
    }



    public int getSize() {
        return myStackList.size();
    }

    public int getPeek() {
        if (isEmpty()) throw new IllegalStateException("Stack is Empty");
        return myStackList.get(myStackList.size() - 1);
    }

    public List<Integer> getAllStackElements() {
        return myStackList;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is Empty");
        int poppedItem = getPeek();
        myStackList.remove(getSize() - 1);

        return poppedItem;
    }
}
