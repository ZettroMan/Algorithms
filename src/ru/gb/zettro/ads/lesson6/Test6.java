package ru.gb.zettro.ads.lesson6;

import java.util.Random;

public class Test6 {

    public static void main(String[] args) {
//        testTree();
//        testRemoveElement();
        System.out.println("===================================================================================================");
        System.out.println("Depth \t\t Range \t\t Pass count \t\t Balanced \t\t Unbalanced \t\t Balance percentage");

        // Тестируем сбалансированность деревьев:
        // Сначала по заданию
        testBalance(4, 25, 20);
        testBalance(6, 100, 20);

        // затем с произвольными данными
        testBalance(4, 1000, 100);
        testBalance(5, 1000, 100);
        testBalance(6, 1000, 100);
        testBalance(7, 1000, 100);
        testBalance(8, 1000, 100);
        testBalance(9, 1000, 100);
    }

    private static void testBalance(int maxDepth, int range, int nTests) {
        Random random = new Random();
        int balancedTrees = 0, unbalancedTrees = 0;
        for (int i = 1; i <= nTests; i++) {
            Tree<Integer> testTree = new FixedDepthTreeImpl<>(maxDepth);
            int nElements = pow(2, maxDepth) - 1;
            // Initialize the tree
            for (int j = 0; j < nElements; j++) {
                int value = random.nextInt(range * 2 + 1) - range;
                testTree.add(value);
            }
            if (testTree.isBalanced()) balancedTrees++;
            else unbalancedTrees++;
        }
        System.out.println("===================================================================================================");

        System.out.println(maxDepth + " \t\t [-" + range + ";" + range + "]   \t\t " + nTests + " \t\t\t " +
                balancedTrees + " \t\t\t " + unbalancedTrees  + " \t\t\t " +  ((double) balancedTrees * 100)/nTests + "%");
    }

    private static int pow(int value, int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }

    private static void testRemoveElement() {
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(55);
        tree.add(32);

        tree.remove(25);
        tree.display();
    }

    private static void testTree() {
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(67);
        tree.add(81);

        System.out.println("Find 70: " + tree.contains(70));
        System.out.println("Find 700: " + tree.contains(700));

        tree.display();
//        tree.traverse(Tree.TraverseMode.IN_ORDER, System.out::println);
//        tree.traverse(Tree.TraverseMode.PRE_ORDER, System.out::println);
//        tree.traverse(Tree.TraverseMode.POST_ORDER, System.out::println);
    }
}
