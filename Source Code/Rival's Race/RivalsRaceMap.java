


package RivalsRace;

import static RivalsRace.Town.getTowns;
import java.util.ArrayList;
import java.util.List;

public class RivalsRaceMap {

    public RivalsRaceMap() {    // initialize the method instantly when called
        addTownIntoMap();
    }

    // create nodes (town)
    Town Pewter = new Town("Pewter City");
    Town Cerulean = new Town("Cerulean City");
    Town Viridian = new Town("Viridian City");
    Town Pallet = new Town("Pallet City");
    Town Cinnabar = new Town("Cinnabar City");
    Town Fuschia = new Town("Fuschia City");
    Town Vermillion = new Town("Vermillion City");
    Town Lavender = new Town("Lavender City");
    Town Saffron = new Town("Saffron City");
    Town Celadon = new Town("Celadon City");

    Town map = new Town ();    // initialize a map to store the towns and the weight

    public void addTownIntoMap() {

        map.addEdge(Pewter, Cerulean, 12);
        map.addEdge(Cerulean, Pewter, 12);

        map.addEdge(Pewter, Viridian, 8);
        map.addEdge(Viridian, Pewter, 8);

        map.addEdge(Cerulean, Saffron, 6);
        map.addEdge(Saffron, Cerulean, 6);

        map.addEdge(Cerulean, Lavender, 9);
        map.addEdge(Lavender, Cerulean, 9);

        map.addEdge(Viridian, Pallet, 5);
        map.addEdge(Pallet, Viridian, 5);

        map.addEdge(Cinnabar, Pallet, 7);
        map.addEdge(Pallet, Cinnabar, 7);

        map.addEdge(Cinnabar, Fuschia, 5);
        map.addEdge(Fuschia, Cinnabar, 5);

        map.addEdge(Celadon, Fuschia, 10);
        map.addEdge(Fuschia, Celadon, 10);

        map.addEdge(Vermillion, Fuschia, 7);
        map.addEdge(Fuschia, Vermillion, 7);

        map.addEdge(Lavender, Fuschia, 11);
        map.addEdge(Fuschia, Lavender, 11);

        map.addEdge(Vermillion, Saffron, 3);
        map.addEdge(Saffron, Vermillion, 3);

        map.addEdge(Vermillion, Lavender, 5);
        map.addEdge(Lavender, Vermillion, 5);

        map.addEdge(Lavender, Saffron, 3);
        map.addEdge(Saffron, Lavender, 3);

        map.addEdge(Celadon, Saffron, 4);
        map.addEdge(Saffron, Celadon, 4);

    }
    
    public Town getMap() {
        return map;
    }
    
    public Town getTownByName (String townName) {

        for (Town town : getTowns().keySet()) {
            if (town.getName().equals(townName))
                return town;
        }
        
        return null;
    }

//    public static void main(String[] args) {
//        RivalsRaceMap raceMap = new RivalsRaceMap();
//        
//        System.out.println(raceMap.toString());
//    }

    
}
