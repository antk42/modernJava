package com.modernJava.lvl7_collectionAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class CreatingCollections {
    public static void main(String[] args) {
        creatingLists();
        creatingSets();
        creatingMaps();
    }

    private static void creatingLists() {
        System.out.println("------ Creating Lists ------");

        System.out.println("--> Creating a list the old-fashioned way");
        List<String> friends = new ArrayList<>();
        friends.add("Raphael");
        friends.add("Olivia");
        friends.add("Thibaut");
        System.out.println(friends);

        System.out.println("--> Using Arrays.asList()");
        List<String> friends2 = Arrays.asList("Raphael", "Olivia");
        System.out.println(friends2);
        friends2.set(0, "Richard");
        System.out.println(friends2);


        System.out.println("--> Creating a Set from a List");
        Set<String> friends3 = new HashSet<>(Arrays.asList("Raphael", "Olivia", "Thibaut"));
        System.out.println(friends3);

        System.out.println("--> Creating a Set from a Stream");
        Set<String> friends4 = Stream.of("Raphael", "Olivia", "Thibaut")
                .collect(Collectors.toSet());
        System.out.println(friends4);

        System.out.println("--> Creating a List with List.of()");
        List<String> friends5 = List.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friends5);
    }

    private static void creatingSets() {
        System.out.println("------ Creating Sets ------");

        System.out.println("--> Creating a Set with Set.of()");
        Set<String> friends = Set.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friends);
    }

    private static void creatingMaps() {
        System.out.println("--> Creating a Map with Map.of()");
        Map<String, Integer> ageOfFriends = Map.of(
                "Raphael", 30,
                "Olivia", 25,
                "Thibaut", 26
        );
        System.out.println(ageOfFriends);

        System.out.println("--> Creating a Map with Map.ofEntries()");
        Map<String, Integer> ageOfFriends2 = Map.ofEntries(
                entry("Raphael", 30),
                entry("Olivia", 25),
                entry("Thibaut", 26));
        System.out.println(ageOfFriends2);
    }
}
