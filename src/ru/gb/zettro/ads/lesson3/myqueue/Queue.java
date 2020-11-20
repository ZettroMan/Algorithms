package ru.gb.zettro.ads.lesson3.myqueue;

public interface Queue<E> {

    boolean insert(E value);

    E remove();

    E peekHead();
//    E peekTail();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();
}
