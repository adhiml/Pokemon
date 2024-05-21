package RivalsRace;

import java.util.*;

public class DijkstraAlgorithm {

    public DijkstraAlgorithm() {
    }

    public List<Town> calculateSTP(Town source, Town target) {
        return dijkstra(source, target);
    }

    private List<Town> dijkstra(Town source, Town target) {

        Map<Town, Integer> dist = new HashMap<>();
        Map<Town, Town> prev = new HashMap<>();

        // dist = HashMap, so dist::get = uses method 'get' in dist map
        // comparatorInt ensures that pq will order the towns based on distances from the source
        PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        initializingDataStructures(source, dist, prev);

        dist.put(source, 0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Town currentTown = pq.poll();

            if (currentTown.equals(target)) {
                break;
            }

            // entrySet() = returns the key (town) and its value (distance)
            for (Map.Entry<Town, Integer> entry : currentTown.getNeighbors().entrySet()) {

                Town neighbor = entry.getKey();
                int newDist = dist.get(currentTown) + entry.getValue();

                if (dist.get(neighbor) == null || newDist < dist.get(neighbor)) {

                    dist.put(neighbor, newDist);
                    prev.put(neighbor, currentTown);
                    pq.add(neighbor);
                }
            }
        }

        return constructShortestPath(target, prev);
    }

    private void initializingDataStructures(Town source, Map<Town, Integer> dist, Map<Town, Town> prev) {
        for (Map.Entry<Town, Integer> entry : source.getNeighbors().entrySet()) {

            Town town = entry.getKey();
            dist.put(town, Integer.MAX_VALUE);
            prev.put(town, null);

        }
    }

    private List<Town> constructShortestPath(Town target, Map<Town, Town> prev) {

        List<Town> path = new LinkedList<>();

        // this method traceback from "target" to the sourceTown using the STP
        // at = null = sourcenode
        for (Town at = target; at != null; at = prev.get(at)) {

            // the 'currentTown' will be add to the beginning (index = 0) = ensure correct order
            path.add(0, at);
        }

        return path;
    }

    public void displaySTP(DijkstraAlgorithm dijkstra, Town source, Town target) {
        List<Town> path = dijkstra.calculateSTP(source, target);
        
        System.out.println("The battle has begun! \nYour rival Gary has challenged you to a race to " + target.getName() + "!");
        
        System.out.println("\nShortest path from " + source.getName() + ": " );
        
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i).getName());
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
        System.out.println("\nGood luck on your race!");
    }

    public static void main(String[] args) {

        RivalsRaceMap raceMap = new RivalsRaceMap();
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();

        Town source = raceMap.Pewter;
        Town target = raceMap.Cinnabar;

    }
}
/*
Shortest Path:
 Saffron City-> Vermillion City-> Fuchsia City-> Cinnabar Island
 */
