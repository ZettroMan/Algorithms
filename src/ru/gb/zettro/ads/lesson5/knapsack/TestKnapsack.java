package ru.gb.zettro.ads.lesson5.knapsack;

import java.util.ArrayList;
import java.util.List;

public class TestKnapsack {
    private static final int KNAPSACK_CAPACITY = 93;
    static List<Thing> optimalPack = new ArrayList<>();
    private static int maxCost;

    public static void main(String[] args) {
        Thing[] things = {
                new Thing("Кастрюля", 15, 20),
                new Thing("Термос", 12, 15),
                new Thing("Топор", 16, 17),
                new Thing("Спички", 2, 2),
                new Thing("Сапоги", 22, 24),
                new Thing("Кепка", 4, 5),
                new Thing("Куртка", 16, 27),
                new Thing("Удочка", 7, 35),
                new Thing("Мангал", 10, 18),
                new Thing("Фонарик", 5, 13),
                new Thing("Плащ-накидка", 20, 21),
                new Thing("Теплые носки", 4, 14),
                new Thing("Паспорт))", 1, 45)
        };
        Knapsack knapsack = new Knapsack(KNAPSACK_CAPACITY);
        maxCost = 0;
        packKnapsack(things, knapsack, 0);
        System.out.println("Объем рюкзака: " + KNAPSACK_CAPACITY + " усл. ед.");
        System.out.println("Оптимальный набор предметов:");
        int totalVolume = 0;
        int totalCost = 0;
        for(Thing thing: optimalPack) {
                System.out.println(" * " + thing.getTitle() + ", " + thing.getCost() + " руб., объем/вес - " + thing.getVolume() + " усл. ед.");
                totalVolume += thing.getVolume();
                totalCost += thing.getCost();
        }
        System.out.println("Общая ценность вещей в рюкзаке: " + totalCost);
        System.out.println("Объем, который они занимают: " + totalVolume);
        System.out.println("Свободное место в рюкзаке: " + (KNAPSACK_CAPACITY - totalVolume));
    }

    private static void packKnapsack(Thing[] things, Knapsack knapsack, int startIndex) {
        if(startIndex >= things.length) return;
        for (int i = startIndex; i < things.length; i++) {
            // Try to pack things[i]
            if(!knapsack.push(things[i])) continue;

            if(knapsack.getTotalCost() > maxCost) {
                maxCost = knapsack.getTotalCost();
                optimalPack.clear();
                optimalPack.addAll(knapsack.getContent());
            }
            packKnapsack(things, knapsack, i + 1);
            knapsack.pop();
        }

    }
}
