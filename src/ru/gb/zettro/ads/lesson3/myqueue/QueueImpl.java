package ru.gb.zettro.ads.lesson3.myqueue;

public class QueueImpl<E> implements Queue<E> {

    protected E[] data;
    protected int size;

    protected int tail;
    protected int head;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    @Override // O(1)
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }
        // такая реализация для меня более интуитивно-понятная
        if (size > 0) {
            tail++;
            if (tail == data.length) {
                tail = 0;
            }
        }
        data[tail] = value;
        size++;
        return true;
    }

    @Override // O(1)
    public E remove() {
        if (size == 0) {
            return null;
        }

        E removedValue = data[head];
        size--;
        if (size > 0) {
            head++;
            if (head == data.length) {
                head = 0;
            }
        }
        return removedValue;
    }

    @Override
    public E peekHead() {
        if (size == 0) {
            return null;
        }

        return data[head];
    }

    @Override
    public E peekTail() {
        if (size == 0) {
            return null;
        }

        return data[tail];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return data.length == size;
    }
}
