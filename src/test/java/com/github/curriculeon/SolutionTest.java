package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    // given
    private void test(int expected, int... fruits) {
        Solution solution = new Solution();

        // when
        int actual = solution.totalFruit(fruits);

        // then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test1() {
        test(1, Integer.MIN_VALUE);
    }

    @Test
    public void test2() {
        test(2, 1,2,3,4,5,6,7);
    }

    @Test
    public void test3() {
        test(3, 1,1,3,4,5,6,7);
    }

    @Test
    public void test4() {
        test(4, 1,1,1,4,5,6,7);
    }

    @Test
    public void test5() {
        test(5, 0,0,0,1,1,2,3,4,5);
    }

    @Test
    public void test6() {
        test(6, 0,0,0,0,1,1,3,4,5);
    }

    @Test
    public void test8() {
        test(8, 1,1,1,2,4,4,4,4,4,7);
    }
}