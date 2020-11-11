package ru.gb.zettro.ads.lesson5;

public class RecursivePower {
    public static void main(String[] args) {
        System.out.println("4 ^ 5 = " + recPower(4,5));
        System.out.println("5 ^ 4 = " + recPower(5,4));
        System.out.println("4 ^ 3 = " + recPower(4,3));
        System.out.println("7 ^ 6 = " + recPower(7,6));
        System.out.println("15 ^ 2 = " + recPower(15,2));
        System.out.println("15 ^ 15 = " + recPower(15,15));
        System.out.println("70 ^ 70 = " + recPower(70,70)); // При переполнении long возвращает 0
    }

    private static long recPower(long base, int power) {
        if(power < 0) {
            throw new IllegalArgumentException("Power value must be non negative.");
        }
        if(power == 0) return 1L;
        return base * recPower(base, power-1);
    }
}
