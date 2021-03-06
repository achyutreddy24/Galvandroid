package com.galvandroid.galvandroid.Chemistry;

import java.io.Serializable;
import java.util.HashMap;

public class Cell implements Serializable {
    private CustomHalfReaction left;
    private CustomHalfReaction right;

    public Cell(CustomHalfReaction left, CustomHalfReaction right) {
        this.left = left;
        this.right = right;
    }

    public String getLMolarity() {
        String ret = "";
        HashMap<Molecule, Double> m = left.getMolarities();
        for (Molecule key : m.keySet()) {
            if (key.getCharge() == 0)
                continue;
            ret += m.get(key) + " M " + key.toString() + "<br/>";
        }
        return ret;
    }

    public String getRMolarity() {
        String ret = "";
        HashMap<Molecule, Double> m = right.getMolarities();
        for (Molecule key : m.keySet()) {
            if (key.getCharge() == 0)
                continue;
            ret += m.get(key) + " M " + key.toString() + "<br/>";
        }
        return ret;
    }


    public CustomHalfReaction getLeft() {
        return left;
    }

    public void setLeft(CustomHalfReaction left) {
        this.left = left;
    }

    public CustomHalfReaction getRight() {
        return right;
    }

    public void setRight(CustomHalfReaction right) {
        this.right = right;
    }

    public String getlMetal() {
        return left.getMetal();
    }

    public String getrMetal() {
        return right.getMetal();
    }
}
