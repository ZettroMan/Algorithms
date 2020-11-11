package ru.gb.zettro.ads.lesson5;

public class RecursivePower {
    public static void main(String[] args) {
        System.out.println("4 ^ 5 = " + recPower(4,5));
        System.out.println("5 ^ 4 = " + recPower(5,4));
        System.out.println("4 ^ 3 = " + recPower(4,3));
        System.out.println("7 ^ 6 = " + recPower(7,6));
        System.out.println("15 ^ 2 = " + recPower(15,2));
        System.out.println("15 ^ 15 = " + recPower(15,15));
        System.out.println("70 ^ 70 = " + recPower(70,70)); // При переполнении возвращаем -1
    }


    private static long recPower(long base, int power) {
        if(base == 0) return 0L;
        if(power < 0) {
            throw new IllegalArgumentException("Power value must be non negative.");
        }
        long result;
        try {
            result = doRecPower(base, power);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return -1L;
        }
        return result;
    }

    private static long doRecPower(long base, int power) {
        if(power == 0) return 1L;
        long mult  = doRecPower(base, power - 1);
        long result = base * mult;
        if(mult != result / base) {
            throw new ArithmeticException("Overflow detected!");
        }
        return result;
    }
}
