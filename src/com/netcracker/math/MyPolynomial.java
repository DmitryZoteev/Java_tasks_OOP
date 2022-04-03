package com.netcracker.math;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = coeffs.length - 1; i >= 0; i--) {
            output += coeffs[i];
            if (i != 0) {
                output += "x^" + i;
            }
            if (i != coeffs.length - 1) {
                output += " + ";
            }
        }
        return output;
    }

    public double evaluate(double x) {
        int result = 0;
        for (int i = 0; i <= coeffs.length; i++){
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        double[] coeffs;
        if (right.coeffs.length > this.coeffs.length) {
            coeffs = new double[right.coeffs.length];
            for (int i = 0; i < this.coeffs.length; i++) {
                coeffs[i] += this.coeffs[i];
            }
        } else {
            coeffs = new double[this.coeffs.length];
            for (int i = 0; i < right.coeffs.length; i++) {
                coeffs[i] += right.coeffs[i];
            }
        }
        return new MyPolynomial(coeffs);
    }

    public MyPolynomial multiple(MyPolynomial right) {
        int m = this.coeffs.length;
        int n = right.coeffs.length;
        double[] newCoeffs = new double[m + n - 1];

        for (int i = 0; i < m + n - 1; i++) {
            newCoeffs[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newCoeffs[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(newCoeffs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
    }
}
