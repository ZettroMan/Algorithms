package ru.gb.zettro.ads.lesson3;

import ru.gb.zettro.ads.lesson3.myqueue.Deque;
import ru.gb.zettro.ads.lesson3.myqueue.DequeImpl;
import ru.gb.zettro.ads.lesson3.myqueue.Queue;
import ru.gb.zettro.ads.lesson3.myqueue.QueueImpl;
import ru.gb.zettro.ads.lesson3.mystack.Stack;
import ru.gb.zettro.ads.lesson3.mystack.StackImpl;

public class Test {

    public static void main(String[] args) {
        testStack();
        testQueue();
        testDeque();
        testReverse();
    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);

        System.out.println("\n==================================================================\nWorking with stack:");

        System.out.println("Add value 1: " + addToStack(stack, 1));
        System.out.println("Add value 2: " + addToStack(stack, 2));
        System.out.println("Add value 3: " + addToStack(stack, 3));
        System.out.println("Add value 4: " + addToStack(stack, 4));
        System.out.println("Add value 5: " + addToStack(stack, 5));
        System.out.println("Add value 6: " + addToStack(stack, 6));

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static boolean addToStack(Stack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

    private static void testQueue() {
        Queue<Integer> queue = new QueueImpl<>(5);
//        Queue<Integer> queue = new PriorityQueue<>(5);
        System.out.println("\n==================================================================\nWorking with queue:");

        System.out.println("Add value 3: " + queue.insert(3));
        System.out.println("Add value 5: " + queue.insert(5));
        System.out.println("Add value 1: " + queue.insert(1));
        System.out.println("Add value 2: " + queue.insert(2));
        System.out.println("Add value 6: " + queue.insert(6));
        System.out.println("Add value 4: " + queue.insert(4));

        System.out.println("Queue peek head: " + queue.peekHead());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static void testDeque() {

        Deque<Integer> deque = new DequeImpl<>(8);
        System.out.println("\n==================================================================\nWorking with deque:");

        System.out.println("Add value 3 to Left: " + deque.insertLeft(3));
        System.out.println("Add value 5 to Right: " + deque.insertRight(5));
        System.out.println("Add value 1 to Right: " + deque.insertRight(1));
        System.out.println("Add value 2 to Right: " + deque.insertRight(2));
        System.out.println("Add value 6 to Left: " + deque.insertLeft(6));
        System.out.println("Add value 4 to Left: " + deque.insertLeft(4));
        System.out.println("Add value 8 to Right: " + deque.insertRight(8));
        System.out.println("Add value 9 to Left: " + deque.insertLeft(9));
        System.out.println("Add value 4 to Left: " + deque.insertLeft(100));

        System.out.println("Deque peek head: " + deque.peekHead());
        System.out.println("Deque size: " + deque.size());
        System.out.println("Deque is full: " + deque.isFull());

        System.out.println("\nOutput deque elements from right end to left end:");
        while (!deque.isEmpty()) {
            System.out.println(deque.removeRight());
//            System.out.println(deque.removeLeft());
        }
    }
    private static void testReverse() {
        System.out.println("\n==================================================================\nReversing strings:");

        doTestReverse("АБЫРВАЛГ");
        doTestReverse("А роза упала на лапу Азора");
        doTestReverse("Корабли лавировали лавировали да не вылавировали");
        doTestReverse("Не видали мы такого невода");
        doTestReverse("Обыкновенная строка");
    }

    private static void doTestReverse(String str) {
        System.out.println("Source string: " + str);
        System.out.println("Reversed string: " + reverseString(str));
    }

    private static String reverseString(String str) {
        Stack<Character> charStack = new StackImpl<>(str.length());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            charStack.push(str.charAt(i));
        }
        while (charStack.size() != 0) {
            stringBuilder.append(charStack.pop());
        }
        return stringBuilder.toString();
    }
}
