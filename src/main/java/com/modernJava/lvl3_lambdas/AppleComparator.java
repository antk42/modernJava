package com.modernJava.lvl3_lambdas;

import java.util.Comparator;

public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple apple1, Apple apple2) {
        return apple1.getWeight() - apple2.getWeight();
    }
}
