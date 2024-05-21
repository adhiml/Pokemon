package Trainers;

import java.util.*;

public class GymInitialization {

    List<Gym> gym = new LinkedList<>();

    public void GymInitialization() {

        Gym Pewter = new Gym("Brook", "Pewter City", leadersPokemonTeam("Pewter"), "Boulder Badge of Pewter City");
        Gym Cerulean = new Gym("Misty", "Cerulean City", leadersPokemonTeam("Cerulean"), "Cascade Badge of Cerulean City");
        Gym Vermilion = new Gym("Lt.Surge", "Vermilion City", leadersPokemonTeam("Vermilion"), "Thunder Badge of Vermilion City");
        Gym Celadon = new Gym("Erika", "Celadon City", leadersPokemonTeam("Celadon"), "Rainbow Badge of Celadon City");
        Gym Fushcia = new Gym("Koga", "Fushciav", leadersPokemonTeam("Fushcia"), "Soul Badge of Fushcia City");
        Gym Saffron = new Gym("Sabrina", "Saffron City", leadersPokemonTeam("Saffron"), "Marsh Badge of Saffron City");
        Gym Cinnabar = new Gym("Blaine", "Cinnabar Island", leadersPokemonTeam("Cinnabar"), "Volcano Badge of Cinnabar Island");
        Gym Viridian = new Gym("Giovanni", "Viridian City", leadersPokemonTeam("Viridian"), "Earth Badge of Viridian City");

        gym.add(Pewter);
        gym.add(Cerulean);
        gym.add(Vermilion);
        gym.add(Celadon);

        gym.add(Fushcia);
        gym.add(Saffron);
        gym.add(Cinnabar);
        gym.add(Viridian);

    }

    public List<Gym> getGym() {
        return gym;
    }

    public ArrayList<Pokemon> leadersPokemonTeam(String name) {

        if (name.equalsIgnoreCase("Pewter")) {
            ArrayList<Pokemon> BrockTeam = new ArrayList<>();
            BrockTeam.add(new Pokemon("Geodude", 12));
            BrockTeam.add(new Pokemon("Onix", 14));
            BrockTeam.add(new Pokemon("Rhyhorn", 15));
            return BrockTeam;
        }

        if (name.equalsIgnoreCase("Cerulean")) {
            ArrayList<Pokemon> MistyTeam = new ArrayList<>();
            MistyTeam.add(new Pokemon("Staryu", 18));
            MistyTeam.add(new Pokemon("Starmie", 21));
            MistyTeam.add(new Pokemon("Goldeen", 20));
            return MistyTeam;
        }

        if (name.equalsIgnoreCase("Vermilion")) {
            ArrayList<Pokemon> LtSurgeTeam = new ArrayList<>();
            LtSurgeTeam.add(new Pokemon("Voltorb", 21));
            LtSurgeTeam.add(new Pokemon("Pikachu", 23));
            LtSurgeTeam.add(new Pokemon("Raichu", 24));
            return LtSurgeTeam;
        }

        if (name.equalsIgnoreCase("Celadon")) {
            ArrayList<Pokemon> ErikaTeam = new ArrayList<>();
            ErikaTeam.add(new Pokemon("Victreebel", 29));
            ErikaTeam.add(new Pokemon("Tangela", 24));
            ErikaTeam.add(new Pokemon("Vileplume", 29));
            return ErikaTeam;
        }

        if (name.equalsIgnoreCase("Fuchsia")) {
            ArrayList<Pokemon> KogaTeam = new ArrayList<>();
            KogaTeam.add(new Pokemon("Koffing", 30));
            KogaTeam.add(new Pokemon("Muk", 33));
            KogaTeam.add(new Pokemon("Weezing", 34));
            return KogaTeam;
        }

        if (name.equalsIgnoreCase("Saffron")) {
            ArrayList<Pokemon> SabrinaTeam = new ArrayList<>();
            SabrinaTeam.add(new Pokemon("Kadabra", 38));
            SabrinaTeam.add(new Pokemon("Mr. Mime", 37));
            SabrinaTeam.add(new Pokemon("Alakazam", 40));
            return SabrinaTeam;
        }

        if (name.equalsIgnoreCase("Cinnabar")) {
            ArrayList<Pokemon> BlaineTeam = new ArrayList<>();
            BlaineTeam.add(new Pokemon("Growlithe", 40));
            BlaineTeam.add(new Pokemon("Ponyta", 42));
            BlaineTeam.add(new Pokemon("Arcanine", 47));
            return BlaineTeam;
        }

        if (name.equalsIgnoreCase("Viridian")) {
            ArrayList<Pokemon> GiovanniTeam = new ArrayList<>();
            GiovanniTeam.add(new Pokemon("Rhyhorn", 45));
            GiovanniTeam.add(new Pokemon("Dugtrio", 42));
            GiovanniTeam.add(new Pokemon("Nidoking", 50));
            return GiovanniTeam;
        }

        return null;
    }

    public String getBadges(Gym currentGym) {

        if (gym.contains(currentGym)) {
            return currentGym.getBadges();

        }

        return null;
    }

    public Gym getCurrentGym(String currentGym) {

        for (Gym gym : getGym()) {
            if (gym.getCity().equalsIgnoreCase(currentGym)) {
                return gym;
            }
        }

        return null;

    }

    public void display(Gym currentGym) {

        if (gym.contains(currentGym)) {
            System.out.println("Gym Leader: " + currentGym.getGymLeader());
            System.out.println("City: " + currentGym.getCity());
            System.out.println("Badge: " + currentGym.getBadges());
            System.out.println(currentGym.getGymLeader() + " Pokemon Team: ");

            for (Pokemon p : currentGym.getPokemonTeam()) {
                System.out.println("- " + p.getName() + " (Level " + p.getLevel() + ")");
            }

            System.out.println("");
        }

    }

}
