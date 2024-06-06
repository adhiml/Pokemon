package pokemonkantoadventure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class KantoCity {
    public static void main(String[] args) {
        //Check save file
        fileExists();
        
        Scanner sc = new Scanner(System.in);
        
        //ArrayList declaration
        ArrayList<ArrayList<City>> graph = new ArrayList<>();
        ArrayList<City> PewterCity = new ArrayList<>();     //0
        ArrayList<City> ViridianCity = new ArrayList<>();   //1
        ArrayList<City> PalletTown = new ArrayList<>();     //2
        ArrayList<City> CinnabarIsland = new ArrayList<>(); //3
        ArrayList<City> FuschiaCity = new ArrayList<>();    //4
        ArrayList<City> CeladonCity = new ArrayList<>();    //5
        ArrayList<City> VermilionCity = new ArrayList<>();  //6
        ArrayList<City> LavenderTown = new ArrayList<>();   //7
        ArrayList<City> SaffronCity = new ArrayList<>();    //8
        ArrayList<City> CeruleanCity = new ArrayList<>();   //9
        
        
        //Determining the adjacent vertx of each vertices
        PalletTown.add(new City("Viridian City",1));
        PalletTown.add(new City("Cinnabar Island",3));
        
        PewterCity.add(new City("Viridian City",1));
        PewterCity.add(new City("Cerulean City",9));
        
        ViridianCity.add(new City("Pallet Town",2));
        ViridianCity.add(new City("Pewter City",0));
        
        CinnabarIsland.add(new City("Pallet Town",2));
        CinnabarIsland.add(new City("Fuchsia City",4));
        
        FuschiaCity.add(new City("Celadon City",5));
        FuschiaCity.add(new City("Lavender Town",7));
        FuschiaCity.add(new City("Cinnabar Island",3));
        
        CeladonCity.add(new City("Fuchsia City",4));
        CeladonCity.add(new City("Vermilion City",6));
        CeladonCity.add(new City("Saffron City",8));
        
        VermilionCity.add(new City("Saffron City",8));
        VermilionCity.add(new City("Lavender Town",7));
        VermilionCity.add(new City("Fuchsia City",4));
        
        LavenderTown.add(new City("Vermilion City",6));
        LavenderTown.add(new City("Cerulean City",9));
        LavenderTown.add(new City("Fuchsia City",4));
        LavenderTown.add(new City("Saffron City",8));
        
        SaffronCity.add(new City("Celadon City",5));
        SaffronCity.add(new City("Cerulean City",9));
        SaffronCity.add(new City("Vermilion City", 6));
        SaffronCity.add(new City("Lavender Town",7));
        
        CeruleanCity.add(new City("Pewter City",0));
        CeruleanCity.add(new City("Saffron City",8));
        CeruleanCity.add(new City("Lavender Town",7));
        
        
        //Adding all the arraylist in the graph        
        graph.add(PewterCity);
        graph.add(ViridianCity);
        graph.add(PalletTown);
        graph.add(CinnabarIsland);
        graph.add(FuschiaCity);
        graph.add(CeladonCity);
        graph.add(VermilionCity);
        graph.add(LavenderTown);
        graph.add(SaffronCity);
        graph.add(CeruleanCity);
        
        //Map gym leaders to locations
        HashMap<String,GymLeaders> gymLeaders = setGymLeaders();
        
        Player player = null;
        GymLeaders gymleader;
        try{
            Scanner skaner = new Scanner(new FileInputStream("pokemon_logo.txt"));
            while(skaner.hasNextLine()) {
               System.out.println(skaner.nextLine());
            }
            skaner.close();
        } catch(IOException e) {
            System.out.println("There is something wrong with the pokemon logo");
        }
        
        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome to Pokemon - Kanto Adventure\n");
        switch(startPrompt()) {
            case 1 :
                player = newGame();
                break;
            case 2: 
                player = loadPlayerData();
                System.out.println(player.getName());
                break;
            case 3:
                System.exit(0);        
        }
        
        int Index = 2;
        String Location = "Pallet Town";
        boolean gameloop = true ;
        boolean creditPlayed = false;
        
        while(gameloop) {
            if(creditPlayed == false)
                creditPlayed = creditScene(player);
            int arr_size = graph.get(Index).size();
            ArrayList<City> currentLocation = graph.get(Index);
            System.out.println("\nYou are now at " + Location);
            WildPokemon wildPokemon = new WildPokemon(Location);
            
            if(player.pokeball > 0) {
               player.catchPokemon();
            }
            
            //First Option (Move to other places)
            System.out.println("[1] Move To : ");
            char options = 'a';
            for(int i = 0 ; i < arr_size ; i++) {
                System.out.print((char)(options + i) + "." + currentLocation.get(i).name + "  ");
            }

            //Second option (Fight wild pokemon)
            System.out.println("\n[2] Fight Wild Pokemon " + wildPokemon.stringPokemonInArea());
            
            //Third Option
            System.out.println("[3] Player Options ");
            System.out.println("a.Show Map  b.Show My Pokemon  c.Show My Badges  d.Save and Exit");
            
            //Fourth option to challenge gym leader (Pallet Town and Lavender City doesnt have gym)
            if(!(Location.equals("Pallet Town") || Location.equals("Lavender Town"))) {
                String gymLeader ;
                switch (Location) {
                    case "Pewter City":
                        gymLeader = "Brock - Rock type";
                        break;
                    case "Viridian City":
                        gymLeader = "Giovanni - Ground type";  
                        break;
                    case "Pallet Town":
                        gymLeader = "No Gym in Pallet Town";
                        break;
                    case "Cinnabar Island":
                        gymLeader = "Blaine - Fire type";
                        break;
                    case "Fuchsia City":
                        gymLeader = "Koga - Poison type";  
                        break;
                    case "Celadon City":
                        gymLeader = "Erika - Grass type";
                        break;
                    case "Vermilion City":
                        gymLeader = "Lt. Surge - Electric type";
                        break;
                    case "Lavender Town":
                        gymLeader = "No Gym in Lavender Town";
                        break;
                    case "Cerulean City":
                        gymLeader = "Misty - Water type";
                        break;
                    case "Saffron City":
                        gymLeader = "Sabrina - Psychic type";
                        break;
                    default :
                        gymLeader = "";
                }
                System.out.println("[4] Challenge Gym Leader " + "[" + gymLeader + "]");
            }
            
            if(Location.equals("Lavender Town")) {
                System.out.println("[4] PokeMaze");
            } else if(Location.equals("Pallet Town")) {
                System.out.println("[4]Talk to MOM (Your hometown has no gym)");
            }
            
            if(Location.equals("Saffron City")) {
                System.out.println("[5] Rival's Race");
            } else if(Location.equals("Fuchsia City")) {
                System.out.println("[5] Safari Zone");
            }
            
            System.out.println("---------------------------------------------------------------");
            String input ;
            System.out.print("Your Choice : ");
            input = sc.nextLine();
            System.out.println("---------------------------------------------------------------\n");
            
            while(true) {
                if(!(Location.equals("Pallet Town") || Location.equals("Fuchsia City") || Location.equals("Saffron City")) && !(input.charAt(0) >= '1' && input.charAt(0) <= '4')) {
                    System.out.println("1.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                } else if(Location.equals("Pallet Town") && !(input.charAt(0) >= '1' && input.charAt(0) <= '4')) {
                    System.out.println("2.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                } else if((input.charAt(0) == '1' || input.charAt(0) == '3') && input.length() != 2) {
                    System.out.println("3.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                } else if((input.charAt(0) == '2' || input.charAt(0) == '4') && input.length() != 1) {
                    System.out.println("4.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                } else if((input.charAt(0) == '1' && arr_size == 2) && !(input.charAt(1) == 'a' || input.charAt(1) == 'b')) {
                    System.out.println("5.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                } else if(input.charAt(0) == '1' && arr_size == 3 && !(input.charAt(1) == 'a' || input.charAt(1) == 'b' || input.charAt(1) == 'c')) {
                    System.out.println("6.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                } else if(input.charAt(0) == '1' && arr_size == 4 && !(input.charAt(1) == 'a' || input.charAt(1) == 'b' || input.charAt(1) == 'c' || input.charAt(1) == 'd')) {
                    System.out.println("7.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                } else if(input.charAt(0) == '3' && !(input.charAt(1) == 'a' || input.charAt(1) == 'b' || input.charAt(1) == 'c' || input.charAt(1) == 'd')) {
                    System.out.println("8.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                } else {
                    break;
                }
            }

            //if user choose option 1
            if(input.charAt(0) == '1') {
                char input_char = input.charAt(1);
                Location = currentLocation.get(input_char-'a').name;
                Index = currentLocation.get(input_char-'a').index ;
                System.out.println("\n");
            } else if(input.charAt(0) == '2') {
                wildPokemonBattle(player,wildPokemon.getEnemy());
            } else if(input.charAt(0) == '3') {
                if(input.charAt(1) == 'a') {
                    //display kanto map
                    convertMap(Location);
                    System.out.println("\n");
                } else if(input.charAt(1) == 'b') {
                    //Show pokemon
                    for(int i = 0 ; i < player.getPokemon().size() ; i++) {
                        System.out.println((i + 1) + ". " + player.getPokemon().get(i).getName() + " [level " + player.getPokemon().get(i).getLevel() + "]");
                    }
                    System.out.println("\n");
                } else if(input.charAt(1) == 'c') {
                    //Show badges
                    if(!player.getBadges().isEmpty()) {
                        for(int i = 0 ; i < player.getBadges().size() ; i++) {
                            System.out.println((i + 1) + ". " + player.getBadges().get(i));
                        }
                    } else {
                        System.out.println("You don't have any badges.");
                    }
                    System.out.println("\n");
                } else if(input.charAt(1) == 'd') {
                    //Save and exit
                    saveAndExit(player);
                    System.exit(0);
                }
            } else if(input.charAt(0) == '4' && Location.equals("Pallet Town")) {
                System.out.println("MOM : Oh hi there " + player.getName() + "!");
                try{
                    Scanner sc2 = new Scanner(new FileInputStream("mom's dialogue.txt"));
                    while(sc2.hasNextLine()) {
                        System.out.println(sc2.nextLine());
                    }
                    System.out.println("\n");
                } catch(IOException e) {
                    System.out.println("Theres a problem with mom's dialogue");
                }
            } else if(input.charAt(0) == '4' && Location.equals("Lavender Town")) {
                pokemaze(player);
            } else if(input.charAt(0) == '4' && !Location.equals("Lavender Town")) {
                //Challenge gym leader
                System.out.println("You challenged " + Location + "'s Gym Leader!");
                gymleader = gymLeaders.get(Location);
                System.out.println("Prepare to battle against " + gymleader.getName() + "!");
                gymLeaderBattle(player,gymleader);
                gymLeaders.replace(Location, resetGymLeaders(Location));
            } else if(input.charAt(0) == '5' && Location.equals("Saffron City")) {
                RivalsRace race = new RivalsRace(Location);
                //Rival Race
            } else if(input.charAt(0) == '5' && Location.equals("Fuchsia City")) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("+----------------------------------------------------------------------+");
                System.out.println("Welcome to the Safari Zone! Today's challenge: Sort the Pokémon!");
                System.out.println("+----------------------------------------------------------------------+");
                System.out.print("Enter the Pokémon in your party (separated by a comma): ");
                String SafariZoneInput = scanner.nextLine();
                String[] pokemonArray = SafariZoneInput.split(", ");
                System.out.println("\nYou entered: " + String.join(", ", pokemonArray));
                System.out.println("\nSorting your Pokémon according to their unique preferences...");
                sortPokemon(pokemonArray);            
            }
        }
    }
    
    public static void convertMap (String city) {
        try{
            Scanner sc = new Scanner(new FileInputStream("PokemonMap.txt"));
            while(sc.hasNextLine()) {
                String temp = sc.nextLine();
                if(!(city.equals("Viridian City") || city.equals("Pallet Town"))) {
                    String line = temp.replace(city,"**" + city + "**");
                    System.out.println(line);
                } else {
                    String line = temp.replace(city + "]    ","**" + city + "**]");
                    System.out.println(line);
                }
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("There is something wrong with the pokemon map");
        }
    }
    
    public static void pokemaze(Player player) {
        Random rand = new Random();
        int maze_option = rand.nextInt(5) + 1;
        String filename;
        
        switch(maze_option) {
            case 1:
                filename = "maze1.txt";
                break;
            case 2 :
                filename = "maze2.txt";
                break;
            case 3 :
                filename = "maze3.txt";
                break;
            case 4 :
                filename = "maze4.txt";
                break;
            case 5 :
                filename = "maze5.txt";
                break;
            default :
                filename = " ";
                break;
        }
        
        try{
            Scanner sc = new Scanner(new FileInputStream(filename));
            int num_line = 0 ;
            while(sc.hasNextLine()) {
                num_line++;
                sc.nextLine();
            }
            String[][] arr = new String[num_line][];
            Scanner sc2 = new Scanner(new FileInputStream(filename));
            for(int i = 0 ; i < num_line ; i++){
                arr[i]= sc2.nextLine().split(" ");
            }
            gameStart(arr,player);
        } catch(IOException e) {
            System.out.println("There is a problem with the map");
        }
    }
    
    public static void gameStart(String arr[][], Player player) {
        MyStack<String> stack = new MyStack<>();
        
        Scanner sc = new Scanner(System.in);
        String you = "Y";
        ArrayList<coordinate> hashlist = new ArrayList<>();
        int ghastcount = 0;
        int x_ghast1 = 0;
        int y_ghast1 = 0;
        int x_ghast2 = 0;
        int y_ghast2 = 0;
        int x = 0;
        int y = 0;
        int x_end=0, y_end=0;
        
        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = 0 ; j < arr[i].length ; j++) {
                if(arr[i][j].equals("S")) {
                    x = i;
                    y = j;
                }
                if(arr[i][j].equals("E")) {
                    x_end = i;
                    y_end = j ;
                }
                if(arr[i][j].equals("G")) {
                    if(ghastcount == 0) {
                        x_ghast1 = i;
                        y_ghast1 = j;
                        ghastcount++;
                    } else {
                        x_ghast2 = i;
                        y_ghast2 = j;
                    }
                }
                if(arr[i][j].equals("#")) {
                    hashlist.add(new coordinate(i,j));
                }
            }
        }
        
        while (true) {
            String temp = arr[x][y];
            System.out.println("Enter direction (R-right , L-left , U-up , D-down) : ");
            for(int i = 0 ; i < arr.length ; i++) {
                for(int j = 0 ; j < arr[i].length ; j++) {
                System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            
            String input = sc.nextLine();
            System.out.println();
            if(arr[x][y].equals("S")) {
            arr[x][y] = temp;
            } else {
                arr[x][y] = ".";
            }
            int old_x = x;
            int old_y = y;
            
            if(input.equals("R") || input.equals("r")) {
                y++;
                stack.push("right");
            } else if(input.equals("L") || input.equals("l")) {
                y--;
                stack.push("left");
            } else if(input.equals("U") || input.equals("u")) {
                x--;
                stack.push("up");
            } else if(input.equals("D") || input.equals("d")) {
                x++;
                stack.push("down");
            } else {
                System.out.println("Invalid input, please tray again.");
                continue;
            }

            //System.out.println("X = "+x+", Y = "+y);
            coordinate target = new coordinate(x,y);
           
            if(target.contains(hashlist)) {
                System.out.println("Why are you approaching a wall, try again.\n");
                x = old_x;
                y = old_y;
                arr[x][y] = "Y";
                stack.pop();
                continue ;
            }
            
            arr[x][y] = "Y";
            System.out.println("Your moves : " + stack);
            
            if(x == x_end && y == y_end) {
                System.out.println("Congratulations, you have reached the end of the maze !");
                
                Random randReward = new Random();
                int probability_items = randReward.nextInt(2); 
                switch(probability_items) {
                case 0 :
                    System.out.println("Congratulations, you have received one ANTIDOTE item !");
                    player.antidote++;
                    System.out.println("You currently have " + player.getAntidote() + " ANTIDOTE item.");
                    break;
                }
                break;
            }
            if(x == x_ghast1 && y == y_ghast1) {
                System.out.println("You have encountered a ghast, you have been kicked out of the maze. \n");
                break;
            }
            if(x == x_ghast2 && y == y_ghast2) {
                System.out.println("You have encountered a ghast, you have been kicked out of the maze.");
                break;
            }
            if(stack.size() == 40) {
                System.out.println("You took too long in the maze, you are kicked out.");
                break;
            }
        }
    }
    
    public static int startPrompt() {
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("1. Start a new adventure.");
        System.out.println("2. Resume previous adventure.");
        System.out.println("3. Quit game");
        System.out.println("---------------------------------------------------------------");
        do{
            System.out.print("Your choice: ");
            choice = acceptInt();
            if(choice < 1 || choice > 3) {
                System.out.println("Invalid input! Please try again!");
            }
        } while(choice < 1 || choice > 3);
        
        return choice;
    }
    
    public static void gymLeaderBattle(Player player, GymLeaders gymleader) {     //myPokemon from Player, enemy from demo
        if(gymleader.getRemainingPokemon().size() != gymleader.getAllPokemon().size())
            gymleader.resetPokemon();
        if(player.getBattlePokemon().size() != player.getPokemon().size())
            player.resetPokemon();
        
        int accumulatedLevel = 0;
        Scanner input = new Scanner(System.in);
        
        while((!player.battlePokemonEmpty() || player.getCurrentPokemon() != null) && (!gymleader.remainingPokemonEmpty() || gymleader.getCurrentPokemon() != null)) {
            System.out.println("\n---------------------------------------------------------------");
            int choice = 0;
            if(gymleader.getCurrentPokemon() == null) {
                gymleader.setCurrentPokemon();
                gymleader.getCurrentPokemon().display();
                System.out.println(gymleader.getName() + " chose " + gymleader.getCurrentPokemon().getName() + " [level " + gymleader.getCurrentPokemon().getLevel() + "]\n");
                System.out.println("Strong against: "+gymleader.getCurrentPokemon().stringStrength());
                System.out.println("Weak against: "+gymleader.getCurrentPokemon().stringWeakness());
                System.out.println();
            } else {
                gymleader.getCurrentPokemon().display();
                System.out.println(gymleader.getName() + "'s " + gymleader.getCurrentPokemon().getName() + " still stands " + "! [HP: " + gymleader.getCurrentPokemon().getCurrentHP() + "/" + gymleader.getCurrentPokemon().getHP() + "]\n");
                System.out.println("Strong against: " + gymleader.getCurrentPokemon().stringStrength());
                System.out.println("Weak against: " + gymleader.getCurrentPokemon().stringWeakness());
                System.out.println();
            }
            if(player.getCurrentPokemon() == null)
                player.choosePokemon();
            else {
                if(!player.battlePokemonEmpty()) {
                    System.out.println("Stay with this pokemon or choose another one?");
                    System.out.println(player.getCurrentPokemon().getName() + " [HP: " + player.getCurrentPokemon().getCurrentHP() + "/" + player.getCurrentPokemon().getHP() + "]");
                    do{
                        System.out.println("\n1. Stay with this one.\n2. Choose another pokemon.");
                        choice = acceptInt();
                    } while(choice < 1 || choice > 2);
                    switch(choice) {
                        case 1:
                            break;
                        case 2:
                            player.choosePokemon();
                            break;
                    } 
                } else {
                    System.out.println("You only have " + player.getCurrentPokemon().getName() + " left! Keep fighting!");
                }
            }
            System.out.println("\n");
            player.getCurrentPokemon().againstEnemy(gymleader.getCurrentPokemon());
            
            while(player.getCurrentPokemon().getCurrentHP() > 0 && gymleader.getCurrentPokemon().getCurrentHP() > 0){
                System.out.println("\n---------------------------------------------------------------");
                player.getCurrentPokemon().attack(gymleader.getCurrentPokemon());
                if(gymleader.getCurrentPokemon().getCurrentHP() <= 0) {
                    System.out.println(gymleader.getCurrentPokemon().getName() + " [HP: 0/" + gymleader.getCurrentPokemon().getHP() + "]");
                    System.out.println(player.getCurrentPokemon().getName() + " won against " + gymleader.getName() + "'s " + gymleader.getCurrentPokemon().getName() + "!");
                    accumulatedLevel += gymleader.getCurrentPokemon().getLevel();
                    gymleader.removeCurrentPokemon();
                    break;
                }
                player.getCurrentPokemon().defense(gymleader.getCurrentPokemon(),player);
                if(player.getCurrentPokemon().getCurrentHP() <= 0){
                    System.out.println(player.getCurrentPokemon().getName() + " [HP: 0/" + player.getCurrentPokemon().getHP() + "]");
                    System.out.println(player.getCurrentPokemon().getName() + " lose!");
                    player.removeCurrentPokemon();
                    break;
                }
                System.out.println("\n---------------------------------------------------------------");
            }
        }
        
        if(!player.battlePokemonEmpty() || player.getCurrentPokemon() != null) {
            System.out.println("\nYou won " + accumulatedLevel * 5 + " XP for all pokemon that went to battle!");
            System.out.println("You have earned 2 pokeballs");
            player.pokeball += 2;
            for(int i = 0 ; i < player.getUsedPokemon().size() ; i++) {
                player.getUsedPokemon().get(i).levelUp(accumulatedLevel);
            }
            if(!player.getBadges().contains(gymleader.getBadge())) {
                System.out.println("\n" + gymleader.getName() + ": You beat me fair and square. You are worthy of winning my badge! Here you go!");
                System.out.println(gymleader.getName() + ": Come back here sometime! I'll be happy to fight you again!");
                System.out.println("\nCongratulations " + player.getName() + ", you obtained " + gymleader.getBadge() + "!");
                player.obtainBadge(gymleader.getBadge());
            } else {
                System.out.println("\n" + gymleader.getName() + ": You beat me again this time! It was a very good fight!");
                System.out.println(gymleader.getName() + ": Come again sometime!");
            }
        } else {
            if(!player.getBadges().contains(gymleader.getBadge())) {
                System.out.println("\n" + gymleader.getName() + ": Looks like you are not ready to have my badge! Come again when you are stronger!");
                System.out.println(gymleader.getName() + ": I will be waiting for our next rematch!");
            } else {
                System.out.println("\n" + gymleader.getName() + ": Looks like it's not your luck this time! Come back again some other time for another rematch!");
            }
        }
        System.out.println();
        player.updatePokemon();
        player.resetPokemon();
        gymleader.resetPokemon();
    }
    
    public static void wildPokemonBattle(Player player, Pokemon enemy){
        Random rand = new Random();
        boolean win = false;
        if(player.getBattlePokemon().size() != player.getPokemon().size())
            player.resetPokemon();
        
        Scanner input = new Scanner(System.in);
        while((!player.battlePokemonEmpty() || player.getCurrentPokemon() != null) && win == false) {
            int choice = 0;
            System.out.println("\n---------------------------------------------------------------");
            enemy.display();
            System.out.println("Wild " + enemy.getName() + " [level " + enemy.getLevel() + "]\n");
            System.out.println("Strong against: " + enemy.stringStrength());
            System.out.println("Weak against: " + enemy.stringWeakness());
            System.out.println();
            
            if(player.getCurrentPokemon() == null) {
                player.choosePokemon();
            } else {
                if(!player.battlePokemonEmpty()) {
                    System.out.println("Stay with this pokemon or choose another one?");
                    System.out.println(player.getCurrentPokemon().getName() + " [HP: " + player.getCurrentPokemon().getCurrentHP() + "/" + player.getCurrentPokemon().getHP() + "]");
                    do{
                        System.out.println("\n1. Stay with this one.\n2. Choose another pokemon.");
                        choice = acceptInt();
                    } while(choice < 1 || choice > 2);
                    switch(choice) {
                        case 1:
                            break;
                        case 2:
                            player.choosePokemon();
                            break;
                    } 
                } else {
                    System.out.println("You only have " + player.getCurrentPokemon().getName() + " left! Keep fighting!");
                }
            }
            System.out.println("\n");
            player.getCurrentPokemon().againstEnemy(enemy);
            
            while(player.getCurrentPokemon().getCurrentHP() > 0 && enemy.getCurrentHP() > 0){
                System.out.println("\n---------------------------------------------------------------");
                player.getCurrentPokemon().attack(enemy);
                if(enemy.getCurrentHP() <= 0){
                    System.out.println(enemy.getName() + " [HP: 0/" + enemy.getHP() + "]");
                    System.out.println(player.getCurrentPokemon().getName() + " won against wild " + enemy.getName() + "!");
                    win = true;
                    break;
                }
                player.getCurrentPokemon().defense(enemy,player);
                if(player.getCurrentPokemon().getCurrentHP() <= 0){
                    System.out.println(player.getCurrentPokemon().getName() + " [HP: 0/" + player.getCurrentPokemon().getHP() + "]");
                    System.out.println(player.getCurrentPokemon().getName() + " lose! Choose another pokemon!");
                    player.removeCurrentPokemon();
                    break;
                }
                System.out.println("\n---------------------------------------------------------------");
            }
        }
        if(!player.battlePokemonEmpty() || player.getCurrentPokemon() != null) {
            System.out.println("\nYou won " + enemy.getLevel() * 5 + " XP for all pokemon that went to battle!");
            int probability_pokeball = rand.nextInt(3);
            switch(probability_pokeball) {
                case 0 :
                    System.out.println("You have received one pokeball ");
                    player.pokeball++;
                    break;
            }
            int probability_items = rand.nextInt(2); 
            switch(probability_items) {
                case 0 :
                    System.out.println("Congratulations, you have received one ANTIDOTE item !");
                    player.antidote++;
                    System.out.println("You currently have " + player.getAntidote() + " ANTIDOTE item.");
                    break;
            }
            for(int i = 0 ; i < player.getUsedPokemon().size() ; i++){
                player.getUsedPokemon().get(i).levelUp(enemy.getLevel());
            }
        } else {
            System.out.println("You lost against wild " + enemy.getName());
        }
        System.out.println();
        player.updatePokemon();
        player.resetPokemon();
    }
    
    public static void fileExists() {
        File file = new File("Game Slot.txt");
        if(!file.exists()){
        createFile();
        }
    }
    
    public static void createFile() {
        try{
            FileWriter fw = new FileWriter("Game Slot.txt");
            fw.write("1\n2\n3\n");
            fw.close();
            System.out.println("File Created");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveAndExit(Player player) {
        String name = player.getName();
        String playerSave = name + ".bin";
        int slot = player.getSaveSlot();
        String line;
        String array[];
        ArrayList<String[]> data = new ArrayList<>();
        File file1 = new File("Game Slot.txt");
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file1));
            
            while((line = br.readLine()) != null){
                array = line.split(",");
                data.add(array);
            }
            br.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
            
            for(int i = 0 ; i < data.size() ; i++) {
                if(slot == Integer.parseInt(data.get(i)[0])) {
                    bw.write(String.valueOf(slot) + "," + name);
                    bw.newLine();
                } else {
                    if(data.get(i).length == 2) {
                        bw.write(data.get(i)[0] + "," + data.get(i)[1]);
                        bw.newLine();
                    } else if(data.get(i).length == 1) {
                        bw.write(data.get(i)[0]);
                        bw.newLine();
                    } else {
                        System.out.println("Error in saving data.(csv file)");
                        break;
                    }
                }
            }
            bw.close();
            
        } catch(IOException e){
            e.printStackTrace();
        }
        
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(playerSave));
            
            out.writeObject(player);
            out.close();
            System.out.println("Saved!");
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
        
    public static Player loadPlayerData() {
        Scanner input = new Scanner(System.in);
        boolean success = false;
        String line;
        String name = "";
        String[] array = null;
        ArrayList<String[]> slots = new ArrayList<>();
        int choice;
        Player player = null;
        System.out.print("Which game file would you like to load: ");
        
        while(success == false) {
            try{
                BufferedReader br = new BufferedReader(new FileReader("Game Slot.txt"));
                System.out.print("\nGame Saves:\t");
                do{
                    while((line = br.readLine()) != null) {
                        array = line.split(",");
                        if(array.length == 1) {
                            System.out.print(array[0] + ". (empty)\t");
                        } else if(array.length == 2) {
                            System.out.print(array[0] + ". ("+array[1] + ")\t");
                        } else {
                            System.out.print(array[0] + ". (corrupted save file)");
                        }
                        slots.add(array);
                    }
                    
                    System.out.print("\n\nLoad: ");
                    choice = acceptInt();
                    if(choice < 1 || choice > 3)
                        System.out.println("\nInvalid game save.");
                } while(choice < 1 || choice > 3);
                
                for(int i = 0 ; i < slots.size() ; i++) {
                    if(choice == Integer.parseInt(slots.get(i)[0])){
                        if(slots.get(i).length == 2) {
                            name = slots.get(i)[1];
                            success = true;
                            break;
                        } else if(slots.get(i).length == 1) {
                            System.out.println("Choose available game file only.");
                        } else {
                            System.out.println("Game file is corrupted. Choose another available game file.");
                        }
                    }
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        
        try{
            File filename = new File(name + ".bin");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            if(name.equals("") || filename.exists() == false) {
                System.out.println("Fail to load game file(no name or file does not exist).");
            } else{
                player = (Player) ois.readObject();
                System.out.println("Welcome back " + player.getName() + "!");
            }
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException f) {
            f.printStackTrace();
        }
        return player;
    }
    
    public static Player newGame() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        String name;
        Player player = null;
        
        while(player == null) {
            System.out.print("\nNew Game:\t");
            String line;
            String[] temp;
            String[] slot;
            String answer;
            boolean overwrite = false;
            boolean unique = false;
            ArrayList<String[]> slots = new ArrayList<>();
            
            try{
                BufferedReader br = new BufferedReader(new FileReader("Game Slot.txt"));
                while((line = br.readLine()) != null) {
                    slot = line.split(",");
                    if(slot.length == 1) {
                        System.out.print(slot[0] + ". (empty)\t");
                    } else if(slot.length == 2){
                        System.out.print(slot[0] + ". ("+slot[1]+")\t");
                    } else{
                        System.out.println(slot[0] + ". Error(corrupted save file)");
                    }
                    slots.add(slot);
                }
                br.close();
                
                do {
                    System.out.print("\n\nGame Slot: ");
                    choice = acceptInt();
                    if(choice <1 || choice >3)
                        System.out.println("Invalid Save Slot.");
                } while(choice <1 || choice >3);
                
                if(slots.get(choice-1).length == 2) {
                    while(overwrite == false) {
                        System.out.println("Overwrite save file?");
                        System.out.print("You can't revert back after overwriting this game file. [yes/no] : ");
                        answer = input.nextLine();
                        if(answer.equalsIgnoreCase("yes")) {
                            while(unique == false) {
                                do{    //cant input blank
                                    System.out.print("Enter your name: ");
                                    name = input.nextLine();
                                    if(name.isBlank())
                                        System.out.println("Please enter a name!");
                                } while(name.isBlank());
                                for(int j = 0 ; j < 3 ; j++) {
                                    temp = slots.get(j);
                                    if(temp.length == 2) {
                                        if(name.equalsIgnoreCase(temp[1]) && choice == Integer.parseInt(temp[0])) {
                                            unique = true;
                                            break;
                                        } else if(name.equalsIgnoreCase(temp[1]) && choice != Integer.parseInt(temp[0])) {
                                            System.out.println("Please enter unique name.");
                                            unique = false;
                                            break;
                                        } else
                                            unique = true;
                                    }
                                }
                                if(unique == true) {
                                    player = new Player(name);
                                    player.setSaveSlot(choice);
                                    try{
                                        File oldFile = new File(slots.get(choice - 1)[1] + ".bin");
                                        File sameFile = new File(name + ".bin");
                                        if(sameFile.exists())
                                            sameFile.delete();
                                        else if(oldFile.exists())
                                            oldFile.delete();
                                    } catch(SecurityException s) {
                                        s.printStackTrace();
                                    }
                                    overwrite = true;
                                }
                            }
                        } else if(answer.equalsIgnoreCase("no")) {
                            overwrite = false;
                            break;
                        }
                    }
                } else if(slots.get(choice-1).length == 1) {
                    while(unique == false) {
                        do{    //cant input blank
                            System.out.print("Enter your name: ");
                            name = input.nextLine();
                            if(name.isBlank())
                                System.out.println("Please enter a name!");
                        } while(name.isBlank());
                        for(int k = 0 ; k < 3 ; k++) {
                            temp = slots.get(k);
                            if(temp.length == 2) {
                                if(name.equalsIgnoreCase(temp[1])) {
                                    unique = false;
                                    break;
                                }
                            } else if(temp.length == 1) {
                                unique = true;
                            }
                        }
                        if(unique == false) {
                            System.out.println("Please enter unique name.");
                        } else{
                            player = new Player(name);
                            player.setSaveSlot(choice);
                            break;
                        }
                    }
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return player;
    }
    
    public static HashMap<String,GymLeaders> setGymLeaders() {
        HashMap<String,GymLeaders> temp = new HashMap<>();
        
        temp.put("Pewter City", new PewterCityGymLeader());
        temp.put("Cerulean City", new CeruleanCityGymLeader());
        temp.put("Vermilion City", new VermilionCityGymLeader());
        temp.put("Celadon City", new CeladonCityGymLeader());
        temp.put("Fuchsia City", new FuchsiaCityGymLeader());
        temp.put("Saffron City", new SaffronCityGymLeader());
        temp.put("Cinnabar Island", new CinnabarIslandGymLeader());
        temp.put("Viridian City", new ViridianCityGymLeader());
        
        return temp;
    }
    
    public static GymLeaders resetGymLeaders(String Location) {
        GymLeaders temp = null;
        switch(Location) {
            case "Pewter City" :
                temp = new PewterCityGymLeader();
                break;
            case "Cerulean City" :
                temp = new CeruleanCityGymLeader();
                break;
            case "Vermilion City" :
                temp = new VermilionCityGymLeader();
                break;
            case "Celadon City" :
                temp = new CeladonCityGymLeader();
                break;
            case "Fuchsia City" :
                temp = new FuchsiaCityGymLeader();
                break;
            case "Saffron City" :
                temp = new SaffronCityGymLeader();
                break;
            case "Cinnabar Island" : 
                temp = new CinnabarIslandGymLeader();
                break;
            case "Viridian City" :
                temp = new ViridianCityGymLeader();
                break;
        }
        return temp;
    }
    
    public static boolean creditScene(Player player) {
        if(player.getBadges().size() == 8){
            System.out.println("---------------------------------------------------------------");
            System.out.println("Congratulations "+player.getName()+", you've finished the game!");
            System.out.println("You've collected all 8 badges in Kanto region!");
            System.out.println("We hope you enjoyed our game!");
            System.out.println("\nDeveloped by:");
            System.out.println("Ahmad Iman bin Azrul Hasni");
            System.out.println("Siti Sa'adah binti Ismail");
            System.out.println("Dennis Aimin Oon bin Jeffrey Oon");
            System.out.println("Muhammad Imran bin Ilias");
            System.out.println("\nYou can still enjoy current gameplay or create a new game save!");
            System.out.println("Happy playing dear pokemon trainer!");
            System.out.println("---------------------------------------------------------------");
            return true;
        } else
            return false;
    }

    public static int acceptInt() {
        int i;
        Scanner input = new Scanner(System.in);
        try{
            i = input.nextInt();
            input.nextLine();
            return i;
        } catch(InputMismatchException ex) {
            return -1;
        }
    }
    
    public static void sortPokemon(String[] pokemonArray) {
        int i = 1;
        List<String> pokemonList = new ArrayList<>(Arrays.asList(pokemonArray));
        
        if (pokemonList.contains("Eevee")) {
            pokemonList.remove("Eevee");
            pokemonList.add(0, "Eevee");
            System.out.println("\nStep " + i + ": Eevee insists on being positioned either at the beginning of the lineup to showcase its adaptability.");
            System.out.println("Sorted List: " + pokemonList);
            i++;
        }

        if (pokemonList.contains("Pikachu")) {
            pokemonList.remove("Pikachu");
            int centerIndex = pokemonList.size() / 2;
            pokemonList.add(centerIndex, "Pikachu");
            System.out.println("\nStep " + i + ": Pikachu demands to be placed at the center of the arrangement.");
            System.out.println("Partial Sort: " + pokemonList);
            i++;
        }
        
        if (pokemonList.contains("Snorlax")) {
            pokemonList.remove("Snorlax");
            pokemonList.add("Snorlax");
            System.out.println("\nStep " + i + ": Snorlax insists on being positioned at the end of the lineup to ensure maximum relaxation.");
            System.out.println("Partial Sort: " + pokemonList);
            i++;
        }
        
        if (pokemonList.contains("Pikachu") && pokemonList.contains("Jigglypuff")) {
            pokemonList.remove("Jigglypuff");
            int pikachuIndex = pokemonList.indexOf("Pikachu");
            if (pikachuIndex != -1 && pikachuIndex > 0) {
                String removedPokemon = pokemonList.remove(pikachuIndex - 1);
                pokemonList.add(pikachuIndex - 1, "Jigglypuff"); 
                pokemonList.add(pikachuIndex + 1, removedPokemon); 
            }
            System.out.println("\nStep " + i + ": Jigglypuff prefers to be surrounded by \"cute\" Pokémon (Pikachu) for morale purposes.");
            System.out.println("Partial Sort: " + pokemonList);
            i++;
        }

        if (pokemonList.contains("Machop") && pokemonList.contains("Snorlax")) {
            pokemonList.remove("Machop");
            int snorlaxIndex = pokemonList.indexOf("Snorlax");
            pokemonList.add(snorlaxIndex, "Machop");
            System.out.println("\nStep " + i + ": Machop demands to be placed next to the heaviest Pokemon in the lineup to show  off its strength.");
            System.out.println("Partial Sort: " + pokemonList);
            i++;
        }
        
        if (pokemonList.contains("Bulbasaur") && pokemonList.contains("Charmander")) {
            int bulbasaurIndex = pokemonList.indexOf("Bulbasaur");
            int charmanderIndex = pokemonList.indexOf("Charmander");
            int bulbasaurSize = 0, charmanderSize = 0;
            if (Math.abs(bulbasaurIndex - charmanderIndex) == 1) {
                if (bulbasaurIndex > charmanderIndex) {
                    for (int j = bulbasaurIndex ; j < pokemonList.size() ; j++) {
                        bulbasaurSize++;
                    }
                    for (int k = charmanderIndex ; k >= 0 ; k--) {
                        charmanderSize++;
                    }
                    if (bulbasaurSize > charmanderSize) {
                        int swapIndex = bulbasaurIndex + 1;

                         Collections.swap(pokemonList, bulbasaurIndex, swapIndex);
                    } else if (bulbasaurSize < charmanderSize) {
                        int swapIndex = charmanderIndex - 1;
                        Collections.swap(pokemonList, charmanderIndex, swapIndex);
                     }
                } else {
                    for (int j = bulbasaurIndex ; j >= 0 ; j--) {
                        bulbasaurSize++;
                     }
                    for (int k = charmanderIndex ; k < pokemonList.size() ; k++) {
                        charmanderSize++;
                    }
                    if (bulbasaurSize > charmanderSize) {
                        int swapIndex = bulbasaurIndex - 1;
                        Collections.swap(pokemonList, bulbasaurIndex, swapIndex);
                    } else if (bulbasaurSize < charmanderSize) {
                        int swapIndex = charmanderIndex + 1;
                        Collections.swap(pokemonList, charmanderIndex, swapIndex);
                    }
                }
            }
            System.out.println("\nStep " + i + ": Bulbasaur refuses to be placed next to Charmander.");
            System.out.println("Final Sorted List: " + pokemonList);
        }
        System.out.println("\n+----------------------------------------------------------------------+");
        System.out.println("Your Pokémon are now sorted! Enjoy your adventure in the Safari Zone!");
        System.out.println("+----------------------------------------------------------------------+");
    }
}
