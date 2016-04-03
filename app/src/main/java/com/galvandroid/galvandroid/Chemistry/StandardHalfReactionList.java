package com.galvandroid.galvandroid.Chemistry;

import android.content.Context;

import java.util.ArrayList;

import static com.galvandroid.galvandroid.Chemistry.Util.parseHalfReaction;

public class StandardHalfReactionList {
    public static ArrayList<HalfReaction> halfreactions;

    public static void initialize(Context c) {
        AtomConstants.initialize(c);
        halfreactions = new ArrayList<>();
        halfreactions.add(parseHalfReaction("2H1+1 = 1H2+0", 2, 0)); // Standard

        halfreactions.add(parseHalfReaction("1F2+0 = 2F1-1", 2, 2.87));
        halfreactions.add(parseHalfReaction("1Ag1+2 = 1Ag1+1", 1, 1.99));
        halfreactions.add(parseHalfReaction("1Co1+3 = 1Co1+2", 1, 1.82));


        halfreactions.add(parseHalfReaction("1O2+0 + 2H2O1+0 = 4O1H1-1", 4, 0.4));
        halfreactions.add(parseHalfReaction("1Cu1+2 = 1Cu1+0", 2, 0.34));
        halfreactions.add(parseHalfReaction("1Hg2Cl2+0 = 2Hg1+0 + 2Cl1-1", 2, 0.34));
        halfreactions.add(parseHalfReaction("1Ag1Cl1+0 = 1Ag1+0 + 1Cl1-1", 1, 0.22));
        halfreactions.add(parseHalfReaction("1S1O4-2 + 4H1+1 = 1H2S1O3+0 + 1H2O1+0", 2, 0.2));
        halfreactions.add(parseHalfReaction("1Cu1+2 = 1Cu1+1", 1, 0.16));
        halfreactions.add(parseHalfReaction("1Fe1+3 = 1Fe1+0", 3, -0.036));
        halfreactions.add(parseHalfReaction("1Pb1+2 = 1Pb1+0", 2, -0.13));
        halfreactions.add(parseHalfReaction("1Sn1+2 = 1Sn1+0", 2, -0.14));
        halfreactions.add(parseHalfReaction("1Ni1+2 = 1Ni1+0", 2, -0.23));
        halfreactions.add(parseHalfReaction("1Pb1S1O4+0 = 1Pb1+0 + 1S1O4-2", 2, -0.35));
        halfreactions.add(parseHalfReaction("1Cd1+2 = 1Cd1+0", 2, -0.40));
        halfreactions.add(parseHalfReaction("1Fe1+2 = 1Fe1+0", 2, -0.44));
        halfreactions.add(parseHalfReaction("1Cr1+3 = 1Cr1+2", 1, -0.50));
        halfreactions.add(parseHalfReaction("1Cr1+3 = 1Cr1+0", 3, -0.73));
        halfreactions.add(parseHalfReaction("1Zn1+2 = 1Zn1+0", 2, -0.76));
        halfreactions.add(parseHalfReaction("2H2O1+0 = 1H2+0 + 2O1H1-1", 2, -0.83));
        halfreactions.add(parseHalfReaction("1Mn1+2 = 1Mn1+0", 2, -1.18));
        halfreactions.add(parseHalfReaction("1Al1+3 = 1Al1+0", 3, -1.66));
        halfreactions.add(parseHalfReaction("1H2+1 = 2H1-1", 2, -2.33));
        halfreactions.add(parseHalfReaction("1Mg1+2 = 1Mg1+0", 2, -2.27));
        halfreactions.add(parseHalfReaction("1La1+3 = 1La1+0", 3, -2.37));
        halfreactions.add(parseHalfReaction("1Na1+1 = 1Na1+0", 1, -2.71));
        halfreactions.add(parseHalfReaction("1Ca1+2 = 1Ca1+0", 2, -2.76));
        halfreactions.add(parseHalfReaction("1Ba1+2 = 1Ba1+0", 2, -2.90));
        halfreactions.add(parseHalfReaction("1K1+1 = 1K1+0", 1, -2.92));
        halfreactions.add(parseHalfReaction("1Li1+1 = 1Li1+0", 1, -3.05));

    }

    public static ArrayList<HalfReaction> getHalfreactions() {
        return halfreactions;
    }


}
