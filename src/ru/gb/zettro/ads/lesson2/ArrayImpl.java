package ru.gb.zettro.ads.lesson2;

import java.util.Arrays;

public class ArrayImpl<T extends Comparable<? super T>> implements Array<T> {

    private static final int DEFAULT_CAPACITY = 8;

    protected int size;
    protected T[] data;

    @SuppressWarnings("unchecked")
    public ArrayImpl(int capacity) {
        this.size = 0;
        this.data = (T[]) new Comparable[capacity];
    }

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(T value) {
        checkAndGrow();
        data[size++] = value;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedValue = data[index];
        size--;
        System.arraycopy(data, index + 1, data, index, size - index);
        return removedValue;
    }

    @Override
    public void insert(T value, int index) {
        if (index == size) {
            add(value);
        } else {
            checkIndex(index);
            checkAndGrow();
            System.arraycopy(data, index, data, index + 1, size - index);
            data[index] = value;
            size++;
        }
    }

    @Override
    public void set(T value, int index) {
        checkIndex(index);
        data[index] = value;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public int getFirstOccurrenceOf(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void showContent() {
        System.out.println(this);
    }

    @Override
    public void trimToSize() {
        data = Arrays.copyOf(data, size);
    }

    protected void checkIndex(int index) {
        if (index < 0 || index >= size) throw new MyCustomArrayIndexOutOfBoundsException(index, size);
    }

    protected void checkAndGrow() {
        if (size == data.length) {
            data = Arrays.copyOf(data, size > 0 ? size * 2 : 1);
        }
    }

    protected void checkAndShrink() {
        // don't shrink an array when current size is too small to avoid frequent copy operations
        if ((size <= data.length / 4) && (size >= DEFAULT_CAPACITY / 2)) {
            data = Arrays.copyOf(data, data.length / 2);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            if (i < 20 || (i > size - 20)) {
                sb.append(data[i]);
                sb.append(", ");
            } else {
                if ((i % (size / 30)) != 0) continue;
                sb.append("... , ");
                sb.append(data[i]);
                sb.append(", ");
            }
        }
        if (size > 0) {
            sb.append(data[size - 1]);
        }
        sb.append("]");
        return sb.toString();
    }

    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int indexA, int indexB) {
        T temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    //O(n^2) - compare
    // O(n) = exchange
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            T mimValue = data[minIndex];  // добавил кэширование, чтобы не обращаться каждый раз к массиву при сравнении
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(mimValue) < 0) {
                    minIndex = j;
                    mimValue = data[minIndex]; // но при кэшировании добавилось это присваивание
                }
            }
            if (minIndex != i) swap(minIndex, i);
        }
    }

    // O(n^2) --> O(n) - compare
    // O(n) --> O(0) = exchange + arraycopy
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            T temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) > 0) {
                in--;
            }
            // заменил поэлементный "пузырьковый" сдвиг на arraycopy
            if(in != i) {
                System.arraycopy(data, in, data, in + 1, i - in);
                data[in] = temp;
            }
        }
    }

}
