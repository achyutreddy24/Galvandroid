package com.galvandroid.galvandroid.Chemistry;


public class Util {

    public static CustomHalfReaction getAnode(CustomHalfReaction a, CustomHalfReaction b) {


        return a;
    }

    public static double getnonStandard(CustomHalfReaction a, CustomHalfReaction b){
        double ared = a.getBaseReaction().getReductionPotential();
        int n = a.getMultiplier();
        double q = 1.00;
        return 0.0592/n*Math.log(q);
    }

}

