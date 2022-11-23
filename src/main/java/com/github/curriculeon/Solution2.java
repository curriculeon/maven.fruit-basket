package com.github.curriculeon;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2 implements SolutionInterface {
    public Integer totalFruit(int[] fruits) {
        // 1. get number of different types of fruit
        Set<Integer> differentFruitTypes = getDifferentFruitTypes(fruits);


        int highestNumberOfOccurrences = 0;
        int secondHighestNumberOfOccurrences = 0;
        // 2. iterate through each fruit type
        for (Integer fruitType : differentFruitTypes) {
            // 3. count number of occurrences of each fruit type
            int numberOfOccurrences = getNumberOfOccurrences(fruits, fruitType);

            // 4. identify the two largest `numberOfOccurrences`
            boolean isNewHighest = numberOfOccurrences > highestNumberOfOccurrences;
            boolean isSecondNewHighest = numberOfOccurrences > secondHighestNumberOfOccurrences;

            // 5. set the two largest `numberOfOccurrences`
            if (isNewHighest) {
                secondHighestNumberOfOccurrences = highestNumberOfOccurrences;
                highestNumberOfOccurrences = numberOfOccurrences;
            } else if (isSecondNewHighest) {
                secondHighestNumberOfOccurrences = numberOfOccurrences;
            }
        }
        // 6. sum largest and second largest of `numberOfOccurrences`
        int sum = highestNumberOfOccurrences + secondHighestNumberOfOccurrences;

        // 7. return sum
        return sum;
    }

    private Integer getNumberOfOccurrences(int[] fruits, int inputFruit) {
        List<Integer> fruitList = IntStream.of(fruits).boxed().collect(Collectors.toList());
        return Collections.frequency(fruitList, inputFruit);
    }

    private Set<Integer> getDifferentFruitTypes(int[] fruits) {
        return IntStream
                .of(fruits)
                .boxed()
                .collect(Collectors.toSet());
    }
}
