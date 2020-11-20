package ru.gb.zettro.ads.lesson5.knapsack;

public class Thing {
    private String title;
    private int volume;
    private int cost;

    public Thing(String title, int volume, int cost) {
        this.title = title;
        this.volume = volume;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public int getVolume() {
        return volume;
    }

    public int getCost() {
        return cost;
    }

}
