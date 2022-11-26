package utils;

import java.util.Random;

import static utils.BirthdayData.MaxAvailableDay;

public class RandomUtils {
    public static String RandomStringFromArray(String[] input) {
        Random random = new Random();
        int index = random.nextInt(input.length);

        return input[index];
    }

    public static String[] SeveralRandomStringsFromArray(String[] input) {
        Random random = new Random();
        String[] result = new String[random.nextInt(1, input.length)];
        int[] mix = random.ints(0, result.length).distinct().limit(result.length).toArray();
        for (int i = 0; i < result.length; i++) {
            result[i] = input[mix[i]];
        }

        return result;
    }

    public static int RandomIntInRange(int min, int max) {
        Random random = new Random();

        return random.nextInt(max - min) + min;
    }
    public static String RandomBirthdayDay(String month, String year) {
        String value = Integer.toString(RandomUtils.RandomIntInRange(1, MaxAvailableDay(month, year)));
        if (value.length() == 1)
            value = "0" + value;

        return value;
    }
}
