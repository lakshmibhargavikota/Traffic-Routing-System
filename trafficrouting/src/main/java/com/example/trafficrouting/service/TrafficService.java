package com.example.trafficrouting.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import org.springframework.stereotype.Service;

import com.example.trafficrouting.model.Edge;
import com.example.trafficrouting.model.Node;

@Service
public class TrafficService {

    private HashMap<Integer, String> locations = new HashMap<>();
    private HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();

    public TrafficService() {

        addLocation(1, "Bus Stand");
        addLocation(2, "Benz Circle");
        addLocation(3, "MG Road");
        addLocation(4, "Railway Station");
        addLocation(5, "One Town");
        addLocation(6, "Governorpet");

        addRoad(1, 2, 10, 2);
        addRoad(1, 4, 5, 1);
        addRoad(2, 3, 3, 3);
        addRoad(2, 6, 4, 1);
        addRoad(3, 5, 2, 2);
        addRoad(4, 5, 8, 1);
        addRoad(5, 6, 6, 3);
    }

    public void addLocation(int id, String name) {
        locations.put(id, name);
        graph.put(id, new ArrayList<>());
    }

    public void addRoad(int src, int dest, int baseTime, int trafficLevel) {
        graph.get(src).add(new Edge(dest, baseTime, trafficLevel));
        graph.get(dest).add(new Edge(src, baseTime, trafficLevel));
    }

    public void updateTraffic(int src, int dest, int newTraffic) {

        if (!graph.containsKey(src) || !graph.containsKey(dest)) {
            return;
        }

        for (Edge e : graph.get(src)) {
            if (e.getDest() == dest) {
                e.setTrafficLevel(newTraffic);
            }
        }

        for (Edge e : graph.get(dest)) {
            if (e.getDest() == src) {
                e.setTrafficLevel(newTraffic);
            }
        }
    }

    public Map<Integer, String> getLocations() {
        return locations;
    }

    public String findShortestPath(int start, int end) {

        HashMap<Integer, Integer> dist = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (Integer id : locations.keySet()) {
            dist.put(id, Integer.MAX_VALUE);
        }

        dist.put(start, 0);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            if (current.getDist() > dist.get(current.getId())) {
                continue;
            }

            for (Edge edge : graph.get(current.getId())) {

                int newDist = dist.get(current.getId()) + edge.getCurrentTime();

                if (newDist < dist.get(edge.getDest())) {

                    dist.put(edge.getDest(), newDist);
                    parent.put(edge.getDest(), current.getId());

                    pq.offer(new Node(edge.getDest(), newDist));
                }
            }
        }

        if (dist.get(end) == Integer.MAX_VALUE) {
            return "No Route Found!";
        }

        Stack<Integer> stack = new Stack<>();

        int curr = end;

        while (curr != start) {
            stack.push(curr);
            curr = parent.get(curr);
        }

        stack.push(start);

        StringBuilder route = new StringBuilder();

        while (!stack.isEmpty()) {

            route.append(locations.get(stack.pop()));

            if (!stack.isEmpty()) {
                route.append(" → ");
            }
        }

        route.append("<br><br><b>Total Time : </b>");
        route.append(dist.get(end));
        route.append(" minutes");

        return route.toString();
    }
}