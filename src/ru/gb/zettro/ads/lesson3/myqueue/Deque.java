package ru.gb.zettro.ads.lesson3.myqueue;

public interface Deque<E> extends Queue<E> {

    boolean insertLeft(E value);
    default boolean insertRight(E value) { return this.insert(value);}

    default E removeLeft() {return this.remove();}
    E removeRight();

}
