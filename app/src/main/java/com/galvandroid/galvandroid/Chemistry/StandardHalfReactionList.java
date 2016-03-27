package com.galvandroid.galvandroid.Chemistry;

import java.util.ArrayList;
import java.util.HashMap;

public class StandardHalfReactionList {
    public static ArrayList<HalfReaction> halfreactions;

    public static void initialize() {
        halfreactions = new ArrayList<>();
        HashMap<Molecule, Integer> r = new HashMap<>();
        HashMap<Molecule, Integer> p = new HashMap<>();
        //new Molecule(new HashMap<Atom, Integer>().put(AtomConstants.getAtoms().get("F"), 0), 0);

        //r.put(, 2);
        halfreactions.add(new HalfReaction(r, p, 2, 2.87));
    }

    public static ArrayList<HalfReaction> getHalfreactions() {
        return halfreactions;
    }


}
