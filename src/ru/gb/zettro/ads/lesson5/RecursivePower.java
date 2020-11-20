package ru.gb.zettro.ads.lesson5;

public class RecursivePower {
    public static void main(String[] args) {
        System.out.println("4 ^ 5 = " + recPower(4, 5));
        System.out.println("5 ^ 4 = " + recPower(5, 4));
        System.out.println("4 ^ 0 = " + recPower(4, 0));
        System.out.println("0 ^ 20 = " + recPower(0, 20));
        System.out.println("15 ^ 1 = " + recPower(15, 1));
        System.out.println("15 ^ 2 = " + recPower(15, 2));
        System.out.println("15 ^ 15 = " + recPower(15, 15));
        System.out.println("500 ^ 500 = " + recPower(500, 500));          // Переполнение типа данных Double - результат Infinity
        System.out.println("-500 ^ 501 = " + recPower(-500, 501));         // Переполнение типа данных Double - результат -Infinity
        System.out.println("0.1E-100 ^ 500 = " + recPower(0.1E-10, 500)); // Underflow типа данных Double - результат 0.0
        System.out.println("0 ^ 0 = " + recPower(0, 0));                  // Исключение
    }


    private static double recPower(double base, int power) {
        if (base == 0) {
            if (power == 0) {
                throw new IllegalArgumentException("It is illegal to raise zero to zero power.");
            }
            return 0;
        }
        if (power == 0) return 1.0;
        double result;
        if (power < 0) {
            return 1.0 / (base * recPower(base, -power - 1));
        } else {
            return base * recPower(base, power - 1);
        }
    }
}
