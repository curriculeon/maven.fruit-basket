package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    // given
    private void test(SolutionInterface solution, int expected, int... fruits) {

        // when
        int actual = solution.totalFruit(fruits);

        // then
        Assert.assertEquals(expected, actual);
    }

    private void testSolution1(int expected, int... fruits) {
        test(new Solution1(), expected, fruits);
    }

    private void testSolution2(int expected, int... fruits) {
        test(new Solution2(), expected, fruits);
    }

    @Test
    public void test1() {
        testSolution2(1, Integer.MIN_VALUE);
    }

    @Test
    public void test2() {
        testSolution2(2, 1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    public void test3() {
        testSolution1(3, 1, 1, 3, 4, 5, 6, 7);
    }

    @Test
    public void test4() {
        testSolution1(4, 1, 1, 1, 4, 5, 6, 7);
    }

    @Test
    public void test5() {
        testSolution1(5, 0, 0, 0, 1, 1, 2, 3, 4, 5);
    }

    @Test
    public void test6() {
        testSolution1(6, 0, 0, 0, 0, 1, 1, 3, 4, 5);
    }

    @Test
    public void test8() {
        testSolution1(8, 1, 1, 1, 2, 4, 4, 4, 4, 4, 7);
    }
}