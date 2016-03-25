package com.galvandroid.galvandroid.Chemistry;

import java.util.HashMap;

public class Molecule {
    private HashMap<Atom, Integer> form;
    private int charge;

    public Molecule(HashMap<Atom, Integer> x, int c) {
        form = x;
        charge = c;
    }

    @Override
    public boolean equals(Object x) {
        if (x instanceof Molecule) {
            Molecule m = (Molecule) x;
            return form.equals(m.getForm()) && charge == m.getCharge();
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return form != null ? form.hashCode() : 0;
    }

    public HashMap<Atom, Integer> getForm() {
        return form;
    }

    public int getCharge() {
        return charge;
    }
}
