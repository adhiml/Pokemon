package RivalsRace;

import java.util.*;

public class Town {

    public String name;
    public Map<Town, Integer> neighbors;

    public static Map<Town, Map<Town, Integer>> towns = new HashMap<>();

    public Town() {}
    
    public Town(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
        towns.put(this, neighbors);
    }

    // neighbor = town, neighbors = list of towns
    // Add adjacent towns to the current town
    public void addNeighbor(Town neighbor, int weight) {
        neighbors.put(neighbor, weight);
        neighbor.getNeighbors().put(this, weight); // ensure bidirectional connection
    }

    public String getName() {
        return name;
    }


    public Map<Town, Integer> getNeighbors() {
        return neighbors; // return list of adj towns
    }

    public void addEdge(Town from, Town to, int weight) {
        from.addNeighbor(to, weight);
    }

    public static Map<Town, Map<Town, Integer>> getTowns() {
        return towns;       // return list of towns
    }
    
    public  String toString() {
        return name;
    }
    
}
