package ru.gb.zettro.ads.lesson7;

import java.util.Objects;

public class Vertex {

    private final String label;
    private Vertex visitedFrom = null;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    public void setVisitedFrom(Vertex fromVertex) {
        visitedFrom = fromVertex;
    }

    public Vertex getVisitedFrom() {
        return visitedFrom;
    }

    public boolean isVisited() { return visitedFrom != null;}
}
