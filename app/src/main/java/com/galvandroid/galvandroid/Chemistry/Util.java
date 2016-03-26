package com.galvandroid.galvandroid.Chemistry;


public class Util {

    private static final double faraday = 0.0592;

    public static double getNonStandard(CustomHalfReaction a, CustomHalfReaction b) {
        double standard;
        double ared = a.getBaseReaction().getReductionPotential();
        double bred = b.getBaseReaction().getReductionPotential();
        int n = lcmcal(a.getBaseReaction().getElectrons(), b.getBaseReaction().getElectrons()); //Gets LCM of the two electron counts

        if(ared >= bred) {
            standard = ared + (-1 * bred);
        } else {
            standard = (-1 * ared) + bred;
        }

        double q = 1.00;
        return faraday / n * Math.log(q);
    }


    private static int lcmcal(int i, int y) {
        int n, x, s = 1, t = 1;
        for (n = 1; ; n++) {
            s = i * n;
            for (x = 1; t < s; x++) {
                t = y * x;
            }
            if (s == t)
                break;
        }
        return (s);
    }

}

