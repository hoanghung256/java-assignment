/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

import java.util.Random;

/**
 *
 * @author hoang
 */
public class Fraction implements Comparable<Fraction> {

    private int tuSo, mauSo;
    protected int m = 5;
//--------------------------------    

    public Fraction() {
    }

//--------------------------------    
    public Fraction(int t, int m) {
        tuSo = t;
        mauSo = m;
    }

    public void random() {
        Random ran = new Random();
        tuSo = 1 + ran.nextInt(9);
        do {
            mauSo = ran.nextInt(9) + 1;
        } while (mauSo == 0);
    }

//-----------------------------
    public Fraction multiply(Fraction p) {
        return new Fraction(tuSo * p.tuSo, mauSo * p.mauSo).simplify();
    }
//-----------------------------

    public static Fraction mutiply(Fraction p, Fraction q) {
        return p.multiply(q);
    }
//-----------------------------

    public Fraction divide(Fraction p) {
        return this.multiply(p.reverse());
    }
//-----------------------------

    public static int uscln(int t, int m) {
        t = Math.abs(t);
        m = Math.abs(m);
        while (t != m) {
            if (t > m) {
                t -= m;
            } else {
                m -= t;
            }
        }
        return t;
    }
//-----------------------------

    public Fraction simplify() {
        int us = uscln(tuSo, mauSo);
        if (us != 0) {
            tuSo /= us;
            mauSo /= us;
        }
        return this;
    }
//-----------------------------

    public Fraction add(Fraction p) {
        return new Fraction(tuSo * p.mauSo + mauSo * p.tuSo, mauSo * p.mauSo).simplify();
    }

//-----------------------------
    public Fraction reverse() {
        if (tuSo != 0) {
            return new Fraction(mauSo, tuSo);
        } else {
            throw new ArithmeticException("Cannot reverse fraction with numerator 0");
        }
    }

//-----------------------------
    public int getTuSo() {
        return tuSo;
    } // read-only

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int m) {
        mauSo = m;
    }

    public void setTuSo(int m) {
        tuSo = m;
    }

//-----------------------------
    ///////////////////////////////////////
//-----------------------------
    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }

    @Override
    public int compareTo(Fraction o) {
        double a = (double) this.tuSo / this.mauSo;
        double b = (double) o.getTuSo() / o.getMauSo();
        return Double.compare(b, a);
    }

}
