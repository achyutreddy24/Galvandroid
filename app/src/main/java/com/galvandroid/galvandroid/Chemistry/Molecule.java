package com.galvandroid.galvandroid.Chemistry;

import android.text.Html;

import java.util.LinkedHashMap;
import java.util.Map;

public class Molecule {
    private LinkedHashMap<Atom, Integer> form;
    private int charge;

    public Molecule(LinkedHashMap<Atom, Integer> x, int c) {
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

    public LinkedHashMap<Atom, Integer> getForm() {
        return form;
    }

    public int getCharge() {
        return charge;
    }

    @Override
    public String toString() {
        String r = "";
        for (Map.Entry<Atom, Integer> entry : form.entrySet()) {
            Atom key = entry.getKey();
            Integer value = entry.getValue();
            r += key.toString() + "<sub><small>" + value + "</small></sub>";
        }
        return r + getFormatCharge();
    }

    private String getFormatCharge() {
        if (charge > 0) {
            return "<sup><small>" + charge + "+" + "</small></sup>";
        } else if (charge < 0) {
            return "<sup><small>" + Math.abs(charge) + "-" + "</small></sup>";
        }
        return "";
    }
}
