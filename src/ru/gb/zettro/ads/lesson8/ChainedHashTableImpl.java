package ru.gb.zettro.ads.lesson8;

import java.util.ArrayList;
import java.util.List;

public class ChainedHashTableImpl<K, V> implements HashTable<K, V> {

    static class Node<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    private final List<Node<K, V>>[] data;
    private final int hashSize;
    private int size;

    public ChainedHashTableImpl(int hashSize) {
        this.hashSize = hashSize;
        size = 0;
        this.data = new ArrayList[hashSize];
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);

        if (data[index] == null) {
            // adding new value to empty list
            data[index] = new ArrayList<>();
        } else {
            // adding new value to existing list
            for (Node<K, V> node : data[index]) {
                if (node.getKey().equals(key)) {
                    node.setValue(value);
                    return true;
                }
            }
        }
        data[index].add(new Node<>(key, value));
        size++;
        return true;
    }

    private int hash(K key) {
        return key.hashCode() % hashSize;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        if(data[index] == null) return null;
        for (Node<K, V> node : data[index]) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);
        List<Node<K, V>> nodesList = data[index];
        if(nodesList == null) return null;
        for (int i = 0; i < nodesList.size() ; i++) {
            if (nodesList.get(i).getKey().equals(key)) {
                V retval = nodesList.get(i).getValue();
                nodesList.remove(i);
                size--;
                return retval;
            }
        }
        return null;

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
    public void display() {
        System.out.println("--------------------");
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null) {
                System.out.printf("%d = EMPTY\n", i);
            } else {
                System.out.printf("%d = LIST:\n", i);
                for(Node<K, V> node: data[i]) {
                    System.out.println("      " + node);
                }
            }
        }
        System.out.println("--------------------");
    }
}
