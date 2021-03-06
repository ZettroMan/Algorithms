package ru.gb.zettro.ads.lesson4;

import ru.gb.zettro.ads.lesson3.myqueue.Queue;
import ru.gb.zettro.ads.lesson3.mystack.Stack;

import java.util.Iterator;

public class TestMain4 {

    public static void main(String[] args) {
//        testLinkedList();
//        testStack();
//        testQueue();
        testForEach();
    }

    private static void testForEach() {

        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertFirst(9);
        linkedList.insertFirst(10);
        linkedList.insertFirst(11);
        linkedList.insertFirst(12);
        linkedList.insertFirst(13);

        linkedList.display();

        System.out.println("\nAnd now let's display all the list content via foreach:");
        for(Integer value: linkedList) {
            System.out.println(value);
        }

        System.out.println("\nLet's go through the list via iterator and remove each third element:");
        int i = 1;
        Iterator<Integer> listIterator = linkedList.iterator();
        while(listIterator.hasNext()) {
            listIterator.next();
            if ((i++) % 3 == 0) {
                listIterator.remove();
            }
        }
        linkedList.display();

    }

    private static void testLinkedList() {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
//        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
//        linkedList.insertLast(5);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        linkedList.removeFirst();
        linkedList.remove(2);

        linkedList.display();
    }

    private static void testStack() {
        Stack<Integer> stack = new LinkedStackImpl<>();

        System.out.println("Add value 1");
        stack.push(1);
        System.out.println("Add value 2");
        stack.push(2);
        System.out.println("Add value 3");
        stack.push(3);
        System.out.println("Add value 4");
        stack.push(4);
        System.out.println("Add value 5");
        stack.push(5);
        System.out.println("Add value 6");
        stack.push(6);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void testQueue() {
//        Queue<Integer> queue = new QueueImpl<>(5);
//        Queue<Integer> queue = new PriorityQueue<>(5);
        Queue<Integer> queue = new LinkedQueueImpl<>();
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));

        System.out.println("Queue peek: " + queue.peekHead());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
