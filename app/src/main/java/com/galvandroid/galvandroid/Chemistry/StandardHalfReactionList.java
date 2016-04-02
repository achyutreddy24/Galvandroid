package com.galvandroid.galvandroid.Chemistry;

import android.content.Context;

import java.util.ArrayList;

import static com.galvandroid.galvandroid.Chemistry.Util.parseHalfReaction;

public class StandardHalfReactionList {
    public static ArrayList<HalfReaction> halfreactions;

    public static void initialize(Context c) {
        AtomConstants.initialize(c);
        halfreactions = new ArrayList<>();
        halfreactions.add(parseHalfReaction("1F2+0 = 2F1-1", 2, 2.87));
    }

    public static ArrayList<HalfReaction> getHalfreactions() {
        return halfreactions;
    }


}
