package com.modernJava.lvl7_collectionAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RemovingFromMaps {
    public static void main(String[] args) {
        removingFromMaps();
    }

    private static void removingFromMaps() {
        // Mutable Map required here!
        Map<String, String> favouriteMovies = new HashMap<>();
        favouriteMovies.put("Raphael", "Jack Reacher 2");
        favouriteMovies.put("Cristina", "Matrix");
        favouriteMovies.put("Olivia", "James Bond");
        String key = "Raphael";
        String value = "Jack Reacher 2";

        System.out.println("--> Removing an unwanted entry the cumbersome way");
        boolean result = remove(favouriteMovies, key, value);
        System.out.printf("%s [%b]%n", favouriteMovies, result);

        // Put back the deleted entry for the second test
        favouriteMovies.put("Raphael", "Jack Reacher 2");

        System.out.println("--> Removing an unwanted the easy way");
        favouriteMovies.remove(key, value);
        System.out.printf("%s [%b]%n", favouriteMovies, result);
    }

    private static <K, V> boolean remove(Map<K, V> favouriteMovies, K key, V value) {
        if (favouriteMovies.containsKey(key) && Objects.equals(favouriteMovies.get(key), value)) {
            favouriteMovies.remove(key);
            return true;
        }
        return false;
    }
}
