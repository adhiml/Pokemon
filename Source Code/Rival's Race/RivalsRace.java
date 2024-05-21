package RivalsRace;

import java.util.Random;
import java.util.*;

/*
        MapTools = contains basic function of graphs (fro the map)
                 = town (node), edge (weight and adjacent node)
                 = MapTools is to connect each nodes and its neighbors with one another

        RivalsRaceMap = initialize each town, its neighbors and weight         

        RandomSelectionAlgorithm = select random target town to race to

        DijkstraAlgorithm = Find the shortest path to go to the "target"

 */
public class RivalsRace {

    Town currentTown;
    Town source;
    Town target;

    public RivalsRace(String currentTownName) {
        RivalsRaceMap raceMap = new RivalsRaceMap();
        RandomSelectionAlgorithm randomSelectionAlgorithm = new RandomSelectionAlgorithm(raceMap);

        this.currentTown = raceMap.getTownByName(currentTownName);
        
        if (currentTown == null) {
            throw new IllegalArgumentException ("Invalid town name.");
        }
        
        Map<Town, Integer> neighbors = currentTown.getNeighbors();
        randomSelectionAlgorithm.removingAdjacentNodes(neighbors, currentTown);
        
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        this.target = randomSelectionAlgorithm.specifiedTargetTown();
        
        dijkstra.displaySTP(dijkstra, currentTown, target);
    }

    public static void main(String[] args) {
        
        RivalsRace race1 = new RivalsRace("Saffron City");
    }
}
