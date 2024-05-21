package Trainers;

import java.util.*;

public class Trainer {

    private String name;
    private String currentLocation;
    private ArrayList<Pokemon> TrainersPokemon;
    private ArrayList<String> badges;
    private int progress = 0;

    public Trainer(String name, String currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.TrainersPokemon = new ArrayList<>();
        this.badges = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        TrainersPokemon.add(pokemon);
        System.out.println(pokemon.getName() + " has been added to your team!");
    }

    public void removePokemon(String pokemonName) {

        boolean found = false;

        System.out.println("Removing " + pokemonName + "........");

        for (Pokemon pokemon : TrainersPokemon) {

            if (pokemon.getName().contains(pokemonName)) {

                TrainersPokemon.remove(pokemon);
                System.out.println(pokemonName + " has been removed.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(pokemonName + " is not in your team.\n");
        }

    }

    public void addBadge(String badge) {

        if (!badges.contains(badge)) {
            badges.add(badge);

            System.out.println("You've earned the " + badge);

            progress++;
            updateProgress(progress);

            if (badges.size() == 8) {
                playCredits();
            }

        } else {
            System.out.println("You already have this badge.");
        }
    }

    public void updateProgress(int progress) {

        System.out.println("Progress update: " + progress + "/8 gyms completed.");
    }

    public void showTeam() {

        if (TrainersPokemon.isEmpty()) {
            System.out.println("Your Pokemon team is empty.");
        } else {
            System.out.println("Your Pokemon: ");

            for (Pokemon pokemon : TrainersPokemon) {
                System.out.println("- " + pokemon.getName() + " (Level " + pokemon.getLevel() + ")");
            }
        }
    }

    public void showBadges() {

        if (badges.isEmpty()) {
            System.out.println("You have no badges.");
        } else {
            System.out.println("Your badges:");

            for (String badge : badges) {
                System.out.println("- " + badge);
            }
        }
    }

    public void showProgress() {

        switch (progress) {
            case 0:
                System.out.println("No progress is recorded.");
                break;
            case 8:
                System.out.println("All quests are completed!.");
                break;
            default:
                System.out.println(progress + "/8");
                break;
        }
    }

    private void playCredits() {
        System.out.println("Congratulations! You have collected all 8 badges.");
        System.out.println("Playing credits...");
    }

}
