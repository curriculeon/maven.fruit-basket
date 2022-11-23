package com.github.curriculeon;

import java.util.ArrayList;
import java.util.List;

public class Solution1 implements SolutionInterface {
    public Integer totalFruit(int[] fruits) {
        // 1. get number of different types of fruit
        List<Integer> differentFruitTypes = getDifferentFruitTypes(fruits);


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
        // 5. sum largest and second largest of `numberOfOccurrences`
        int sum = highestNumberOfOccurrences + secondHighestNumberOfOccurrences;

        // 6. return sum
        return sum;
    }

    private Integer getNumberOfOccurrences(int[] fruits, int inputFruit) {
        int count = 0;
        for (int i = 0; i < fruits.length; i++) {
            int fruit = fruits[i];
            if (fruit == inputFruit) {
                count++;
            }
        }
        return count;
    }

    private List<Integer> getDifferentFruitTypes(int[] fruits) {
        List<Integer> foundFruit = new ArrayList<>();
        for (int i = 0; i < fruits.length; i++) {
            int fruit = fruits[i];
            boolean isDuplicateFruit = foundFruit.contains(fruit);
            if (!isDuplicateFruit) {
                foundFruit.add(fruit);
            }
        }
        return foundFruit;
    }
}
