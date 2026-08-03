package com.example.trafficrouting.model;

public class Edge {

	    private int dest;
	    private int baseTime;
	    private int trafficLevel;

	    public Edge(int dest, int baseTime, int trafficLevel) {
	        this.dest = dest;
	        this.baseTime = baseTime;
	        this.trafficLevel = trafficLevel;
	    }

	    public int getDest() {
	        return dest;
	    }

	    public int getBaseTime() {
	        return baseTime;
	    }

	    public int getTrafficLevel() {
	        return trafficLevel;
	    }

	    public void setTrafficLevel(int trafficLevel) {
	        this.trafficLevel = trafficLevel;
	    }

	    public int getCurrentTime() {
	        if (trafficLevel == 1)
	            return baseTime;
	        else if (trafficLevel == 2)
	            return baseTime * 2;
	        else
	            return baseTime * 3;
	    }
	
}
