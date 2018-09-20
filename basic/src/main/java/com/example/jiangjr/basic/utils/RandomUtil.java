package com.example.jiangjr.basic.utils;


import java.util.Random;

/**
 * Created by Administrator on 2015/2/11.
 */
public class RandomUtil {
    private static final Random RANDOM = new Random();
    private static final int CENT_PERCENT = 101;

    private RandomUtil() {
        //Empty
    }

    /**
     * Return true of false using a random value generated and the percentage passed as parameter.
     *
     * @param percentage to evaluate.
     * @return true fifty percent of the times it's executed if the percentage parameter is 50.
     */
    public static boolean percent(final int percentage) {
        return (RANDOM.nextInt(CENT_PERCENT) < percentage);
    }

    /**
     * Returns a random integer between 0 and the maxValue argument, included maxValue.
     */
    public static int getRandomValueBelow(final int maxValue) {
        return RANDOM.nextInt(maxValue + 1);
    }

    public static int[] getRandowValueBelows(final int maxValue){
        int[] ints = new int[3];
        ints[0] = RANDOM.nextInt(maxValue+1);
        ints[1] = RANDOM.nextInt(maxValue+1);
        ints[2] = RANDOM.nextInt(maxValue+1);
        return ints;
    }
}
