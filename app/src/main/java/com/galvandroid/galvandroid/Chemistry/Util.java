package com.galvandroid.galvandroid.Chemistry;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class Util {

    private static final double faraday = 0.0592;

    public static double getNonStandard(CustomHalfReaction a, CustomHalfReaction b) {
        double standard;
        double ared = a.getBaseReaction().getReductionPotential();
        double bred = b.getBaseReaction().getReductionPotential();
        int n = lcmcal(a.getBaseReaction().getElectrons(), b.getBaseReaction().getElectrons()); //Gets LCM of the two electron counts

        if (ared >= bred) {
            standard = ared + (-1 * bred);
        } else {
            standard = (-1 * ared) + bred;
        }

        double q = 1.00;
        return faraday / n * Math.log(q);
    }

    public static Molecule parsemolecule(String x) {
        LinkedHashMap<Atom, Integer> atoms = new LinkedHashMap<>();
        int coef = 0; // coefficent
        int mark = 0;
        String cofe = "";

        for (int i = 0; i < x.length(); i++) {
            if (isInteger(x.substring(i, i + 1))) {
                cofe += x.substring(i, i + 1);
            } else {
                mark = i;
                break;
            }
        }
        coef = Integer.parseInt(cofe); // will return later
        for (int i = mark; i < x.length(); i++) {
            String symbol = "";
            String sub_string = "";
            int subscript = 0;

            if (x.substring(mark, mark + 1).equals("+") || x.substring(mark, mark + 1).equals("-")) {
                break;
            }
            while (!isInteger(x.substring(mark, mark + 1))) {
                symbol += x.substring(mark, mark + 1);
                mark++;
            }
            while (isInteger(x.substring(mark, mark + 1))) {
                sub_string += x.substring(mark, mark + 1);
                mark++;
            }
            subscript = Integer.parseInt(sub_string);
            atoms.put(AtomConstants.getAtom(symbol), subscript);

        }
        int charge = Integer.parseInt(x.substring(mark));
        return new Molecule(atoms, charge);
    }

    public static HalfReaction parseHalfReaction(String s, int e, double red) {
        String[] rxn = s.split("=");
        String[] reac = rxn[0].trim().split("\\s\\+\\s");
        String[] prod = rxn[1].trim().split("\\s\\+\\s");

        LinkedHashMap<Molecule, Integer> r = toMoleculeHashMap(reac);
        LinkedHashMap<Molecule, Integer> p = toMoleculeHashMap(prod);

        return new HalfReaction(r, p, e, red);
    }

    private static LinkedHashMap<Molecule, Integer> toMoleculeHashMap(String[] arr) {
        LinkedHashMap<Molecule, Integer> molecules = new LinkedHashMap<>();
        for (String s : arr) {
            molecules.put(parsemolecule(s.trim()), getCoef(s.trim()));
        }
        return molecules;
    }

    private static int getCoef(String s) {
        String cofe = "";

        for (int i = 0; i < s.length(); i++) {
            if (isInteger(s.substring(i, i + 1))) {
                cofe += s.substring(i, i + 1);
            } else {
                break;
            }
        }
        return Integer.parseInt(cofe);
    }

    private static boolean isInteger(String s) {
        return isInteger(s, 10);
    }

    private static boolean isInteger(String s, int radix) {
        if (s.isEmpty())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1)
                    return false;
                else
                    continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0)
                return false;
        }
        return true;
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

