package com.galvandroid.galvandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.galvandroid.galvandroid.Chemistry.Cell;


public class GalvanicCellActivity extends AppCompatActivity {

    private ImageButton lBeaker;
    private ImageButton rBeaker;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            delayedHide(500);
        }
    };

    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_galvanic_cell);

        final Cell cell = (Cell) getIntent().getSerializableExtra("R");
        TextView lm = (TextView) findViewById(R.id.metal1);
        TextView rm = (TextView) findViewById(R.id.metal2);

        lm.setText(Html.fromHtml(cell.getlMetal()));
        rm.setText(Html.fromHtml(cell.getrMetal()));

        TextView lmol = (TextView) findViewById(R.id.left_molarity);
        TextView rmol = (TextView) findViewById(R.id.right_molarity);

        lmol.setText(Html.fromHtml(cell.getLMolarity()));
        rmol.setText(Html.fromHtml(cell.getRMolarity()));

        mContentView = findViewById(R.id.fullscreen_content);

        lBeaker = (ImageButton) findViewById(R.id.left_beaker);
        rBeaker = (ImageButton) findViewById(R.id.right_beaker);

        lBeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SelectHRxnActivity.class);
                i.putExtra("R", cell);
                i.putExtra("b", 0);
                startActivity(i);
            }
        });

        rBeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SelectHRxnActivity.class);
                i.putExtra("R", cell);
                i.putExtra("b", 1);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }


    private void hide() {
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}
