package com.modernJava.lvl7_collectionAPI;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class MergingMaps {
    public static void main(String[] args) {
        mergingMaps();
    }
    private static void mergingMaps() {
        Map<String, String> family = Map.ofEntries(
                entry("Teo", "Star Wars"),
                entry("Cristina", "James Bond"));
        Map<String, String> friends = Map.ofEntries(entry("Raphael", "Star Wars"));

        System.out.println("--> Merging the old way");
        Map<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends);
        System.out.println(everyone);

        Map<String, String> friends2 = Map.ofEntries(
                entry("Raphael", "Star Wars"),
                entry("Cristina", "Matrix"));

        System.out.println("--> Merging maps using merge()");
        Map<String, String> everyone2 = new HashMap<>(family);
        friends2.forEach((k, v) -> everyone2.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
        System.out.println(everyone2);
    }
}
