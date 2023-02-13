package com.ryanmark;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> tempExits = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W",2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("S", 1);
        tempExits.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExits));

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");


        int loc = 1;
        while (true) {
            boolean isValid = false;
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            if (exits.containsKey(direction.toUpperCase())) {
                loc = exits.get(direction.toUpperCase());
            } else {
                System.out.println("You cannot go in that direction");
            }

/*            for(String testString: direction.split(" ")){
                //can replace this with an array of valid options and cycle them.
                if (testString.equalsIgnoreCase("EAST") ||
                        testString.equalsIgnoreCase("WEST") ||
                        testString.equalsIgnoreCase("SOUTH") ||
                        testString.equalsIgnoreCase("NORTH") ||
                        testString.equalsIgnoreCase("QUIT") ||
                        testString.equalsIgnoreCase("E") ||
                        testString.equalsIgnoreCase("W") ||
                        testString.equalsIgnoreCase("S") ||
                        testString.equalsIgnoreCase("N") ||
                       testString.equalsIgnoreCase("Q")){
                    if (exits.containsKey(testString.substring(0,1).toUpperCase())) {
                        isValid = true;
                        loc = exits.get(testString.substring(0,1).toUpperCase());
                        break;
                    }
                    else{
                        System.out.println("You cannot go in that direction");
                    }
                }
            }
            if (!isValid){
                System.out.println("Please enter a valid direction.");
            }
        }*/
        }

    }
}
