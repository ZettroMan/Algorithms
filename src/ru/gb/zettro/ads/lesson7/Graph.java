package ru.gb.zettro.ads.lesson7;

import java.util.*;

public class Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    public void addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;
    }

    public void addEdges(String startLabel, String secondLabel, String... others) {
        addEdge(startLabel, secondLabel);
        for (String other : others) {
            addEdge(startLabel, other);
        }
    }

    private int indexOf(String vertexLabel) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexLabel.equals(vertexList.get(i).getLabel())) {
                return i;
            }
        }
        return -1;
    }


    public int getVertexSize() {
        return vertexList.size();
    }

    public void display() {
        for (int i = 0; i < getVertexSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getVertexSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * англ. Depth-first search, DFS
     *
     * @param startLabel
     */
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(vertex, vertex, stack);
        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.peek();
            vertex = getNearUnvisitedVertex(currentVertex);
            if (vertex != null) {
                visitVertex(currentVertex, vertex, stack);
            } else {
                stack.pop();
            }
        }

        resetVertexState();
    }

    /**
     * англ. breadth-first search, BFS
     *
     * @param startLabel
     */
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(vertex, vertex, queue);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.peek();
            vertex = getNearUnvisitedVertex(currentVertex);
            if (vertex != null) {
                visitVertex(currentVertex, vertex, queue);
            } else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisitedFrom(null);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        for (int i = 0; i < getVertexSize(); i++) {
            if (adjMat[peekIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Vertex from, Vertex vertex, Stack<Vertex> stack) {
        System.out.println(vertex);
        stack.push(vertex);
        vertex.setVisitedFrom(from);
    }

    private void visitVertex(Vertex from, Vertex vertex, Queue<Vertex> queue) {
        System.out.println(vertex);
        queue.add(vertex);
        vertex.setVisitedFrom(from);
    }

    public void showShortestPath(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }
        if (finishIndex == -1) {
            throw new IllegalArgumentException("Invalid finish label");
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(vertex, vertex, queue);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.peek();
            vertex = getNearUnvisitedVertex(currentVertex);
            if (vertex != null) {
                if (finishLabel.equals(vertex.getLabel())) {
                    System.out.println("===========================================\nThe shortest path is:");
                    System.out.println(finishLabel);
                    while (true) {
                        System.out.println(currentVertex.getLabel());
                        if(currentVertex == currentVertex.getVisitedFrom()) break;
                        currentVertex = currentVertex.getVisitedFrom();
                    }
                    return;
                }
                visitVertex(currentVertex, vertex, queue);
            } else {
                queue.remove();
            }
        }

        resetVertexState();

    }
}
