package Trainers;

public class TestClass {

    public static void main(String[] args) {

        GymInitialization gyms = new GymInitialization();

        gyms.GymInitialization();
        
        
        String currentGymName = "Pewter City";
        
        Gym currentGym = gyms.getCurrentGym(currentGymName);

        gyms.display(currentGym);
        
        Trainer ash = new Trainer("Ash", "Saffron");

        System.out.println("\n1. Adding pokemons......\n");

        // examples
        ash.addPokemon(new Pokemon("Pikachu", 10));
        ash.addPokemon(new Pokemon("Charizard", 36));
        ash.addPokemon(new Pokemon("Bulbasaur", 18));

        System.out.println();
        ash.showTeam();

        System.out.println("\n2. Removing pokemon......\n");
        ash.removePokemon("Charizard");
        ash.removePokemon("Geodude");

        System.out.println();
        ash.showTeam();

        System.out.println("\n3. Adding badges......\n");
        ash.showBadges();
        
        // assuming we're at Pewter Gym
        ash.addBadge(gyms.getBadges(currentGym));
        
        System.out.println("");
        ash.showBadges();

        System.out.println("\n4. Showing progress......");
        ash.showProgress();
    }
}
