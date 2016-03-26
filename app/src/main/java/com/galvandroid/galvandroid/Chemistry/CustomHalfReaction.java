package com.galvandroid.galvandroid.Chemistry;

import java.util.HashMap;

public class CustomHalfReaction{
    private HalfReaction baseReaction;
    private HashMap<Molecule, Float> molarities;
    private int multiplier;

    public CustomHalfReaction(HalfReaction hf, HashMap<Molecule, Float> m) {
        baseReaction = hf;
        molarities = m;
    }

    public HalfReaction getBaseReaction() {
        return baseReaction;
    }

    public void setBaseReaction(HalfReaction baseReaction) {
        this.baseReaction = baseReaction;
    }

    public HashMap<Molecule, Float> getMolarities() {
        return molarities;
    }

    public void setMolarities(HashMap<Molecule, Float> molarities) {
        this.molarities = molarities;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
