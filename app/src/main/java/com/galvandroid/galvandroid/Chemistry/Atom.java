package com.galvandroid.galvandroid.Chemistry;

public class Atom {
    private String symbol;
    private String name;
    private int atomic_number;

    public Atom(int num, String sym, String n) {
        symbol = sym;
        name = n;
        atomic_number = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atom atom = (Atom) o;

        return !(symbol != null ? !symbol.equals(atom.symbol) : atom.symbol != null);

    }

    @Override
    public int hashCode() {
        return symbol != null ? symbol.hashCode() : 0;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getAtomic_number() {
        return atomic_number;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
