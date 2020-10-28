package ru.gb.zettro.ads.lesson2;

public class MyCustomArrayIndexOutOfBoundsException extends RuntimeException {

    public MyCustomArrayIndexOutOfBoundsException(int index, int size) {
        super(String.format("Invalid index %d for array with size %d", index, size));
    }
}
