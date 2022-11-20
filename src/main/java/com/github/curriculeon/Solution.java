package com.github.curriculeon;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public Integer totalFruit(int[] fruits) {
        // to track the max # of fruits we can pick
        int maxPicked = 0;

        //iterate through all subArrays(an array within another array) start at index left(which is 0),
        // and iterate over every index to the right of index "left"
        for (int left = 0; left < fruits.length; left++) {
            for (int right = 0; right < fruits.length; right++) {
                //Set is an interface, created an Integer object
                // HashSet Stores elements
                Set<Integer> basket = new HashSet<>();

                // iterate through the current subArray
                //add fruits to the basket
                for(int currentIndex = 0; currentIndex <= right; ++currentIndex){
                    basket.add(fruits[currentIndex]);
                }
                //need to be able to update maxPicked
                //if the number of types of fruits is no larger than 2 update maxPicked
                //shouldn't have noMore than 2 types of fruits
                if (basket.size() <= 2) {
                    maxPicked = Math.max(maxPicked, right - left + 1);
                }

            }


        }

        return maxPicked;
    }
}
