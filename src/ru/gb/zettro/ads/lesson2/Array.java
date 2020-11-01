package ru.gb.zettro.ads.lesson2;

public interface Array<T extends Comparable<? super T>> {

    void add(T value);

    T remove(int index);

    void set(T value, int index);

    T get(int index);

    void insert(T value, int index);

    default boolean contains(T value) { return getFirstOccurrenceOf(value) != -1;}

    int getFirstOccurrenceOf(T value);

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    void showContent();

    void trimToSize();

    void sortBubble();
    void sortSelect();
    void sortInsert();
}
