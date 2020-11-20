package ru.gb.zettro.ads.lesson7;

import java.util.Stack;

public class Main7 {

    public static void main(String[] args) {
//        testGraph();
//        testDfs();
//        testBfs();
        testShortestPath();
    }

    private static void testShortestPath() {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdges("Тула", "Липецк");
        graph.addEdges("Рязань", "Тамбов");
        graph.addEdges("Калуга", "Орел");
        graph.addEdges("Тамбов", "Саратов");
        graph.addEdges("Орел", "Курск");
        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");
       // graph.display();

        Stack<String> shortestPath = graph.getShortestPath("Москва", "Воронеж");
        System.out.println("================================================================");
        if (shortestPath.empty()) {
            System.out.println("Path is not found!");
        } else {
            System.out.println("The shortest path is:");
            displayPath(shortestPath);
        }
    }

    private static void displayPath(Stack<String> path) {
        if (path.isEmpty()) {
            return;
        }
        while (true) {
            System.out.print(path.pop());
            if (!path.isEmpty()) {
                System.out.print(" --> ");
            } else break;
        }
    }


    private static void testGraph() {
        Graph graph = new Graph(4);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdges("A", "B", "C");
        graph.addEdges("B", "A", "C", "D");
        graph.addEdges("C", "A", "B", "D");
        graph.addEdges("D", "B", "C");

        System.out.println("Size of graph is " + graph.getVertexSize());
        graph.display();
    }

    private static void testDfs() {
        Graph graph = new Graph(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdges("B", "E");
        graph.addEdges("D", "F");
        graph.addEdges("F", "G");

        graph.dfs("A");
        //A B E C D F G
    }


    private static void testBfs() {
        Graph graph = new Graph(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdges("B", "E");
        graph.addEdges("E", "H");
        graph.addEdges("C", "F");
        graph.addEdges("D", "G");

        graph.bfs("A");
    }
}
