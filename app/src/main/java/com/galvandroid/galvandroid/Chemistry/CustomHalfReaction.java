package com.galvandroid.galvandroid.Chemistry;

import java.util.HashMap;

public class CustomHalfReaction{
    private HalfReaction baseReaction;
    private HashMap<Molecule, Double> molarities;
    private int multiplier;

    public CustomHalfReaction(HalfReaction hf, HashMap<Molecule, Double> m) {
        baseReaction = hf;
        molarities = m;
    }

    public HalfReaction getBaseReaction() {
        return baseReaction;
    }

    public void setBaseReaction(HalfReaction baseReaction) {
        this.baseReaction = baseReaction;
    }

    public HashMap<Molecule, Double> getMolarities() {
        return molarities;
    }

    public double getReactantMolarity(Molecule x) {
        return molarities.get(x);
    }

    public void setMolarities(HashMap<Molecule, Double> molarities) {
        this.molarities = molarities;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
