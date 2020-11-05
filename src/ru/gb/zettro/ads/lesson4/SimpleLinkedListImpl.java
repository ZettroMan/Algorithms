package ru.gb.zettro.ads.lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected int size;
    protected Node<E> firstElement; //001[005]

    @Override
    public void insertFirst(E value) {
        Node<E> newNode = new Node<>(value, firstElement); // 002[007] | 002[..next->005]
        firstElement = newNode; //001[007]
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedElement = firstElement;
        E data = removedElement.item;

        firstElement = firstElement.next;
        removedElement.next = null;
        removedElement.item = null;

        size--;
        return data;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        current.item = null;

        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void display() {
        System.out.println("-----------");
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("-----------");
    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private Node<E> cursor;
        private Node<E> lastReturned;
        private Node<E> prevToReturned;

        Itr() {
            cursor = firstElement;
            lastReturned = null;
            prevToReturned = null;
        }

        public boolean hasNext() {
            return cursor != null;
        }

       // @SuppressWarnings("unchecked")
        public E next() {
            if (cursor == null)
                throw new NoSuchElementException();
            E elementData = cursor.item;
            if(lastReturned != null) {
                prevToReturned = lastReturned;
            }
            lastReturned = cursor;
            cursor = cursor.next;
            return elementData;
        }

        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();

            // assert prevToReturned == null only when first element is just returned, otherwise - should be not null
            if (prevToReturned == null) {
                firstElement.next = null;
                firstElement = cursor;
            } else {
                prevToReturned.next = cursor;
                lastReturned.next = null;
            }
            lastReturned = null;
        }

    }
}
