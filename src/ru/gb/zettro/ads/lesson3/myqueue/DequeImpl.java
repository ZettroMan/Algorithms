package ru.gb.zettro.ads.lesson3.myqueue;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        if (size > 0) {
            head--;
            if (head == - 1) {
                head = data.length - 1 ;
            }
        }
        data[head] = value;
        size++;
        return true;

    }

    @Override
    public E removeRight() {
        if (size == 0) {
            return null;
        }

        E removedValue = data[tail];
        size--;
        if (size > 0) {
            tail--;
            if (tail == -1) {
                tail = data.length - 1;
            }
        }
        return removedValue;
    }

}
