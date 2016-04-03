package com.galvandroid.galvandroid.Chemistry;

import java.io.Serializable;

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
