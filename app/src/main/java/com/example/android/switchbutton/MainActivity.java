package com.example.android.switchbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    Button b_prev, b_next;
    ImageSwitcher imageSwitcher;
    Integer[] images = {R.drawable.aa, R.drawable.bb, R.drawable.cc};

    int i = 0;

    Animation in, out, in2, out2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        imageSwitcher = (ImageSwitcher) findViewById (R.id.imageSwitcher);

        imageSwitcher.setFactory (new ViewSwitcher.ViewFactory () {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView (getApplicationContext ());
                imageView.setScaleType (ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams (
                        new ImageSwitcher.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;

            }
        });

        final Animation in = AnimationUtils.loadAnimation (getApplicationContext (), R.anim.in);
        final Animation out = AnimationUtils.loadAnimation (getApplicationContext (), R.anim.out);
        final Animation in2 = AnimationUtils.loadAnimation (getApplicationContext (), R.anim.in2);
        final Animation out2 = AnimationUtils.loadAnimation (getApplicationContext (), R.anim.out2);

        imageSwitcher.setInAnimation (in);
        imageSwitcher.setOutAnimation (out);

        b_prev = (Button) findViewById (R.id.b_prev);
        b_next = (Button) findViewById (R.id.b_next);

        b_prev.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                imageSwitcher.setInAnimation (in2);
                imageSwitcher.setOutAnimation (out2);
                if (i > 0) {
                    i--;
                    imageSwitcher.setImageResource (images[i]);
                }
            }
        });
        b_next.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                imageSwitcher.setInAnimation(in);
                imageSwitcher.setOutAnimation(out);
                if (i < images.length - 1) {
                    i++;
                    imageSwitcher.setImageResource (images[i]);
                }
            }
        });


    }
}
