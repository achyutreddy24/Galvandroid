package com.galvandroid.galvandroid.Chemistry;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class HalfReaction implements Serializable {
    private LinkedHashMap<Molecule, Integer> reactants;
    private LinkedHashMap<Molecule, Integer> products;
    private int electrons;
    private double reductionPotential;

    public HalfReaction(LinkedHashMap<Molecule, Integer> r, LinkedHashMap<Molecule, Integer> p, int e, double red) {
        reactants = r;
        products = p;
        electrons = e;
        reductionPotential = red;
    }

    @Override
    public boolean equals(Object x) {
        if (x instanceof HalfReaction) {
            HalfReaction m = (HalfReaction) x;
            return reactants.equals(m.getReactants()) && products.equals(m.getProducts()) && electrons == m.getElectrons();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = reactants.hashCode();
        result = 31 * result + products.hashCode();
        result = 31 * result + electrons;
        return result;
    }

    public double getReductionPotential() {
        return reductionPotential;
    }

    public LinkedHashMap<Molecule, Integer> getReactants() {
        return reactants;
    }

    public LinkedHashMap<Molecule, Integer> getProducts() {
        return products;
    }

    public int getElectrons() {
        return electrons;
    }

    @Override
    public String toString() {
        String r = "";
        for (Map.Entry<Molecule, Integer> entry : reactants.entrySet()) {
            Molecule key = entry.getKey();
            Integer value = entry.getValue();
            r += value + key.toString() + " + ";
        }

        r += electrons + "e" + "<sup><small>" + "-" + "</small></sup>";
        r += " → ";

        for (Map.Entry<Molecule, Integer> entry : products.entrySet()) {
            Molecule key = entry.getKey();
            Integer value = entry.getValue();
            r += value + key.toString() + " ";
        }
        return r;
    }
}
