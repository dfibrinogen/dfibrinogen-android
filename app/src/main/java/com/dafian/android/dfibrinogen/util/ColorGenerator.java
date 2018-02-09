package com.dafian.android.dfibrinogen.util;

import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Dafian on 2/9/18
 */

public class ColorGenerator {

    public static ColorGenerator DEFAULT;

    public static ColorGenerator RANDOM;

    public static ColorGenerator MATERIAL;

    static {

        DEFAULT = create(Arrays.asList(
                0xfff16364,
                0xfff58559,
                0xfff9a43e,
                0xffe4c62e,
                0xff67bf74,
                0xff59a2be,
                0xff2093cd,
                0xffad62a7,
                0xff805781
        ));

        RANDOM = create(Arrays.asList(
                0xFFF44336,
                0xFFE91E63,
                0xFF9C27B0,
                0xFF673AB7,
                0xFF3F51B5,
                0xFF2196F3,
                0xFF03A9F4,
                0xFF00BCD4,
                0xFF009688,
                0xFF4CAF50,
                0xFF8BC34A,
                0xFFCDDC39,
                0xFFFFEB3B,
                0xFFFFC107
        ));

        MATERIAL = create(Arrays.asList(
                0xffe57373,
                0xfff06292,
                0xffba68c8,
                0xff9575cd,
                0xff7986cb,
                0xff64b5f6,
                0xff4fc3f7,
                0xff4dd0e1,
                0xff4db6ac,
                0xff81c784,
                0xffaed581,
                0xffff8a65,
                0xffd4e157,
                0xffffd54f,
                0xffffb74d,
                0xffa1887f,
                0xff90a4ae
        ));
    }

    private final List<Integer> mColors;
    private final Random mRandom;

    @NonNull
    public static ColorGenerator create(List<Integer> colorList) {
        return new ColorGenerator(colorList);
    }

    private ColorGenerator(List<Integer> colorList) {
        mColors = colorList;
        mRandom = new Random(System.currentTimeMillis());
    }

    public int getRandomColor() {
        return mColors.get(mRandom.nextInt(mColors.size()));
    }

    public int getColor(Object key) {
        return mColors.get(Math.abs(key.hashCode()) % mColors.size());
    }
}
