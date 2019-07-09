
package model;

import java.io.Serializable;

public class Fraction implements Serializable{
    private int nominate, denominate;

    public Fraction(int nominate, int denominate) {
        if (denominate == 0) throw new RuntimeException("denominate == 0");
        this.nominate = nominate;
        this.denominate = denominate;
    }

    public void setNominate(int nominate) {
        this.nominate = nominate;
    }

    public void setDenominate(int denominate) {
        if (denominate == 0) throw new RuntimeException("denominate == 0");
        this.denominate = denominate;
    }

    public int getNominate() {
        return nominate;
    }

    public int getDenominate() {
        return denominate;
    }
    
    public Fraction add(Fraction b){
        return new Fraction(this.nominate * b.getDenominate() + b.getNominate() * this.denominate,
                denominate * b.getDenominate());
    }
    
}
