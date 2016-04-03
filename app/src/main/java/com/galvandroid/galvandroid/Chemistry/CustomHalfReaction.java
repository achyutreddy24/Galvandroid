package com.galvandroid.galvandroid.Chemistry;

import java.io.Serializable;
import java.util.HashMap;

public class CustomHalfReaction implements Serializable {
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

    public String getMetal() {
        HashMap<Molecule, Integer> reac = baseReaction.getReactants();

        for (Molecule key : reac.keySet()) {
            if (key.getCharge() == 0 && key.getForm().size() < 2)
                return key.toString();
        }
        return "Pt";
    }
}
