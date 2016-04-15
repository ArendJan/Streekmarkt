package com.arend_jan.streekmarkt;

/**
 * Created by Arend-Jan on 31-3-2016.
 * ____  ____  _____ _      ____           _  ____  _
 * /  _ \/  __\/  __// \  /|/  _ \         / |/  _ \/ \  /|
 * | / \||  \/||  \  | |\ ||| | \|_____    | || / \|| |\ ||
 * | |-|||    /|  /_ | | \||| |_/|\____\/\_| || |-||| | \||
 * \_/ \|\_/\_\\____\\_/  \|\____/      \____/\_/ \|\_/  \|
 */


import android.support.v4.view.ViewPager;
import android.view.View;

public class DepthPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);

        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1 - position);

            // Counteract the default slide transition
            view.setTranslationX(pageWidth * -position);

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}