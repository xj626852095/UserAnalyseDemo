package com.kevin.useranalysedemo.utils.generator.base;

import java.util.Date;
import java.util.Random;

public abstract class GenericGenerator {
    public abstract <T> T generate();

    private static Random random = null;

    protected Random getRandomInstance() {
        if (random == null) {
            random = new Random(new Date().getTime());
        }

        return random;
    }
}
