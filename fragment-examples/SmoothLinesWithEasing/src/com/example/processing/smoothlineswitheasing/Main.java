package com.example.processing.smoothlineswitheasing;

import processing.core.PApplet;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.example.processing.smoothlineswitheasing.R;

/**
 * This source code is based on following book.
 * 
 * Getting Started with Processing
 * Casey Reas and Ben Fry.
 * Published June 2010, O'Reilly Media. 208 pages. Paperback.
 * 
 * http://shop.oreilly.com/product/0636920000570.do
 *
 */
public class Main extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public static final class Sketch extends PApplet {

        static final float EASING = 0.05f;

        float x;
        float y;
        float py;
        float px;

        @Override
        public void setup() {
            size(width, height);
            smooth();
            stroke(0, 102);
        }

        @Override
        public void draw() {
            float targetX = mouseX;
            float targetY = mouseY;

            x += (targetX - x) * EASING;
            y += (targetY - y) * EASING;

            float w = dist(x, y, px, py);
            strokeWeight(w);
            line(x, y, px, py);

            px = x;
            py = y;
        }
    }
}