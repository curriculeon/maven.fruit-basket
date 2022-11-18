package com.github.curriculeon;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public int totalFruit(int[] fruits) {
        final List<Integer> fruitList = Arrays.stream(fruits).boxed().collect(Collectors.toList());
        final Set<Integer> fruitTypes = new TreeSet<>(fruitList);
        final Map<Integer, Integer> fruitTypeCounter = new TreeMap<>();
        for (Integer fruitType : fruitTypes) {
            final int numberOfFruit = Collections.frequency(fruitList, fruitType);
            fruitTypeCounter.put(fruitType, numberOfFruit);
        }
        final List<Integer> values = new ArrayList<>(fruitTypeCounter.values());
        final Function<Integer, Integer> getValue = (value) -> {
            try {
                return values.get(value);
            } catch(IndexOutOfBoundsException e) {
                return 0;
            }
        };
        return getValue.apply(0) + getValue.apply(1);
    }
}
