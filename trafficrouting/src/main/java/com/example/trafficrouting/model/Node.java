package com.example.trafficrouting.model;

public class Node implements Comparable<Node> {

    private int id;
    private int dist;

    public Node(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    public int getId() {
        return id;
    }

    public int getDist() {
        return dist;
    }

    @Override
    public int compareTo(Node other) {
        return this.dist - other.dist;
    }
}