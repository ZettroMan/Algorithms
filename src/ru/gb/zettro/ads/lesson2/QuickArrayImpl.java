package ru.gb.zettro.ads.lesson2;

public class QuickArrayImpl<T extends Comparable<? super T>> extends ArrayImpl<T> implements QuickArray<T> {

    public QuickArrayImpl(int capacity) {
        super(capacity);
    }

    public QuickArrayImpl() {
    }

    // Экспериментальная "быстрая" версия удаления элемента из массива.
     // Не сохраняет порядок следования элементов в массиве.
    public T removeQuick(int index) {
        checkIndex(index);
        T removedValue = data[index];
        size--;
        data[index] = data[size];
        return removedValue;
    }

    // Экспериментальная "быстрая" версия вставки элементов в массив.
    // Не сохраняет порядок следования элементов в массиве.
    public void insertQuick(T value, int index) {
        if (index == size) {
            add(value);
        } else {
            checkIndex(index);
            checkAndGrow();
            data[size] = data[index];
            data[index] = value;
            size++;
        }
    }


}
