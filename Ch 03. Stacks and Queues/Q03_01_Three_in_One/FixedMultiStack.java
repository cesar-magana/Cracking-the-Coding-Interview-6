/*
 *  Cracking the Coding Interview Solutions.
 */
package Q03_01_Three_in_One;

import java.util.EmptyStackException;

/**
 *
 * @author cesar_magana
 */
public class FixedMultiStack {

    private int numberofStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackCapacity) {
        this.stackCapacity = stackCapacity;
        values = new int[stackCapacity * numberofStacks];
        sizes = new int[numberofStacks];
    }

    //public void push(int stackNum, int value) throws FullStackException {
    public void push(int stackNum, int value) {
        //if (isFull(stackNum)) {
        //    throw new FullStackException();
        //}
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

}
