package ru.senla.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomNumber {
    public static int getRandomID() {
        Date currentDate = new Date();
        String formattedDate = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(currentDate);
        long seed = Long.parseLong(formattedDate);
        Random random = new Random(seed);
        int randomID = random.nextInt(900000) + 100000;
        return randomID;
    }
}
