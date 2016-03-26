package com.galvandroid.galvandroid.Chemistry;

import java.util.HashMap;

public class HalfReaction {
    private HashMap<Molecule, Integer> reactants;
    private HashMap<Molecule, Integer> products;
    private int electrons;
    private float reductionPotential;

    public HalfReaction(HashMap<Molecule, Integer> r, HashMap<Molecule, Integer> p, int e, float red) {
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
        }
        else {
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

    public float getReductionPotential() {
        return reductionPotential;
    }

    public HashMap<Molecule, Integer> getReactants() {
        return reactants;
    }

    public HashMap<Molecule, Integer> getProducts() {
        return products;
    }

    public int getElectrons() {
        return electrons;
    }
}
