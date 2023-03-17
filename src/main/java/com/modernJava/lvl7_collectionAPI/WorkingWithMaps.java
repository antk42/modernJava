package com.modernJava.lvl7_collectionAPI;

import java.util.Map;

import static java.util.Map.entry;

public class WorkingWithMaps {
    public static void main(String[] args) {
        workingWithMaps();
    }

    private static void workingWithMaps() {
        System.out.println("------ Working with Maps ------");

        System.out.println("--> Iterating a map with a for loop");
        Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
        for (Map.Entry<String, Integer> entry: ageOfFriends.entrySet()) {
            String friend = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(friend + " is " + age + " years old");
        }

        System.out.println("--> Iterating a map with forEach()");
        ageOfFriends.forEach((friend, age) -> System.out.println(friend + " is " + age + " years old"));

        System.out.println("--> Iterating a map sorted by keys through a Stream");
        Map<String, String> favouriteMovies = Map.ofEntries(
                entry("Raphael", "Star Wars"),
                entry("Cristina", "Matrix"),
                entry("Olivia", "James Bond"));
        favouriteMovies.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(System.out::println);

        System.out.println("--> Using getOrDefault()");
        System.out.println(favouriteMovies.getOrDefault("Olivia", "Matrix"));
        System.out.println(favouriteMovies.getOrDefault("Thibaut", "Matrix"));
    }
}
