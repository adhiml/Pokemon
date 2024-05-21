
package Trainers;

import java.util.*;

/*

    Gym class = contains the method to get informations of the gym

*/

public class Gym {

    private String GymLeader;
    private ArrayList<Pokemon> pokemonTeam;     // pokemons at the gym
    private  String city;
    private String badges;

    public Gym(String GymLeader, String city, ArrayList<Pokemon> pokemonTeam, String badges) {
        this.GymLeader = GymLeader;
        this.pokemonTeam = pokemonTeam;
        this.city = city;
        this.badges = badges;
    }

    public String getGymLeader() {
        return GymLeader;
    }

    public ArrayList<Pokemon> getPokemonTeam() {
        return pokemonTeam;
    }

    public String getCity() {
        return city;
    }
    
    public String getBadges() {
        return badges;
    }
    
    
}
