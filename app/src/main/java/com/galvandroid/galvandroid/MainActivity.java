package com.galvandroid.galvandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.galvandroid.galvandroid.Chemistry.Cell;
import com.galvandroid.galvandroid.Chemistry.CustomHalfReaction;
import com.galvandroid.galvandroid.Chemistry.HalfReaction;
import com.galvandroid.galvandroid.Chemistry.Molecule;
import com.galvandroid.galvandroid.Chemistry.StandardHalfReactionList;

import java.io.IOException;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button galvanicCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StandardHalfReactionList.initialize(this);

        galvanicCell = (Button) findViewById(R.id.galvanic_cell);

        galvanicCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GalvanicCellActivity.class);
                HalfReaction hf = StandardHalfReactionList.getHalfreactions().get(8);
                HashMap<Molecule, Double> m = new HashMap<>();
                for (Molecule key : hf.getReactants().keySet()) {
                    m.put(key, 1.0);
                }
                for (Molecule key : hf.getProducts().keySet()) {
                    m.put(key, 1.0);
                }
                Cell c = new Cell(new CustomHalfReaction(hf, m), new CustomHalfReaction(hf, m));
                i.putExtra("R", c);
                startActivity(i);
            }
        });
    }

}
