package com.galvandroid.galvandroid.Chemistry;

import android.content.Context;

import com.galvandroid.galvandroid.Util.ReadCSV;

import java.util.HashMap;

public class AtomConstants {
    private static HashMap<String, Atom> atoms;

    public static void initialize(Context context) {
        atoms = ReadCSV.getArray(context);
    }

    public static HashMap<String, Atom> getAtoms() {
        return atoms;
    }

    public static Atom getAtom(String s) {
        return atoms.get(s);
    }
}
