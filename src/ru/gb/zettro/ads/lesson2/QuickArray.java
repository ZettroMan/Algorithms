package ru.gb.zettro.ads.lesson2;

public interface QuickArray<T extends Comparable<? super T>> extends Array<T> {
    void insertQuick(T value, int index);
    T removeQuick(int index);
}
