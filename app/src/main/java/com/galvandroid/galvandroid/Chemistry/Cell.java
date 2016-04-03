package com.galvandroid.galvandroid.Chemistry;

import java.io.Serializable;
import java.util.HashMap;

public class Cell implements Serializable {
    private CustomHalfReaction left;
    private CustomHalfReaction right;
    private String lMetal;
    private String rMetal;

    public Cell(CustomHalfReaction left, CustomHalfReaction right) {
        this.left = left;
        this.right = right;

        lMetal = left.getMetal();
        rMetal = right.getMetal();
    }

    public String getLMolarity() {
        String ret = "";
        HashMap<Molecule, Integer> r = left.getBaseReaction().getReactants();
        HashMap<Molecule, Double> m = left.getMolarities();
        for (Molecule key : r.keySet()) {
            ret += m.get(key) + " M " + key.toString() + "<br/>";
        }
        return ret;
    }

    public String getRMolarity() {
        String ret = "";
        HashMap<Molecule, Integer> p = left.getBaseReaction().getProducts();
        HashMap<Molecule, Double> m = left.getMolarities();
        for (Molecule key : p.keySet()) {
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
        return lMetal;
    }

    public void setlMetal(String lMetal) {
        this.lMetal = lMetal;
    }

    public String getrMetal() {
        return rMetal;
    }

    public void setrMetal(String rMetal) {
        this.rMetal = rMetal;
    }
}
