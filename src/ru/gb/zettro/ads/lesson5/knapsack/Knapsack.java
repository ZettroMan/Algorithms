package ru.gb.zettro.ads.lesson5.knapsack;


import java.util.Stack;

public class Knapsack {
    private int freeSpace;
    private int totalCost;
    private Stack<Thing> content = new Stack<>();

    public Knapsack(int maxCapacity) {
        freeSpace = maxCapacity;
        totalCost = 0;
    }

    public boolean push(Thing thing) {
        if(freeSpace < thing.getVolume()) return false;
        freeSpace -= thing.getVolume();
        totalCost += thing.getCost();
        content.push(thing);
        return true;
    }

    public Thing pop() {
        Thing pickedOutThing = content.pop();
        freeSpace += pickedOutThing.getVolume();
        totalCost -= pickedOutThing.getCost();
        return pickedOutThing;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public Stack<Thing> getContent() {
        return content;
    }
}

