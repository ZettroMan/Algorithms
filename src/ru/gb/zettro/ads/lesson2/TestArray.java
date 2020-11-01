package ru.gb.zettro.ads.lesson2;

import java.util.Random;

public class TestArray {

    public static void main(String[] args) {
        testDynamicArray();
        System.out.println("\n=========================================================================================");
        System.out.println("Starting insertion efficiency test (Standard vs Quick realizations, 1 000 000 insertions)");
        testInsertionEfficiency();
    }

    private static void testDynamicArray() {
        final int ARRAY_SIZE = 100000;
        Array<Integer> data1 = new ArrayImpl<>();
        Array<Integer> data2 = new ArrayImpl<>();
        Array<Integer> data3 = new ArrayImpl<>();
        Random random = new Random();
        long startTime, finishTime, duration;
        startTime = System.currentTimeMillis();
        System.out.println("Start initializing arrays...");
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int randomValue = random.nextInt();
            data1.add(randomValue);
            data2.add(randomValue);
            data3.add(randomValue);
        }

        finishTime = System.currentTimeMillis();
        duration = finishTime - startTime;
        System.out.println("Arrays initialization is done. " + duration + " ms elapsed.");
        System.out.println("First array:");
        data1.showContent();
        System.out.println("Second array:");
        data2.showContent();
        System.out.println("Third array:");
        data3.showContent();


        startTime = System.currentTimeMillis();
        System.out.println("Start bubble sort...");
        data1.sortBubble();
        finishTime = System.currentTimeMillis();
        duration = finishTime - startTime;
        System.out.println("Bubble sort finished. " + duration + " ms elapsed" );

        startTime = System.currentTimeMillis();
        System.out.println("Start selection sort...");
        data2.sortSelect();
        finishTime = System.currentTimeMillis();
        duration = finishTime - startTime;
        System.out.println("Selection sort finished. " + duration + " ms elapsed" );

        startTime = System.currentTimeMillis();
        System.out.println("Start insertion sort...");
        data3.sortInsert();
        finishTime = System.currentTimeMillis();
        duration = finishTime - startTime;
        System.out.println("Insertion sort finished. " + duration + " ms elapsed" );

        System.out.println("\n==============================================================");
        System.out.println("AFTER SORTING:");
        System.out.println("First array:");
        data1.showContent();
        System.out.println("Second array:");
        data2.showContent();
        System.out.println("Third array:");
        data3.showContent();

    }

    private static void testInsertionEfficiency() {
        final int ARRAY_SIZE = 1000000;

        Array<Integer> standardArray = new ArrayImpl<>();
        QuickArray<Integer> quickArray = new QuickArrayImpl<>();
        Random random = new Random();
        long startTime, finishTime, duration;
        startTime = System.currentTimeMillis();
        System.out.println("Start operating with STANDARD array...");
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int randomValue = random.nextInt();
            int randomIndex = random.nextInt(i + 1);
            standardArray.insert(randomValue, randomIndex);
        }
        finishTime = System.currentTimeMillis();
        duration = finishTime - startTime;
        System.out.println(ARRAY_SIZE + " insertions done. " + duration + " ms elapsed on STANDARD array operations.");

        startTime = System.currentTimeMillis();
        System.out.println("Start operating with QUICK array...");
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int randomValue = random.nextInt();
            int randomIndex = random.nextInt(i + 1);
            quickArray.insertQuick(randomValue, randomIndex);
        }
        finishTime = System.currentTimeMillis();
        duration = finishTime - startTime;
        System.out.println(ARRAY_SIZE + " insertions done. " + duration + " ms !!!  elapsed on QUICK array operations.");

    }
}


