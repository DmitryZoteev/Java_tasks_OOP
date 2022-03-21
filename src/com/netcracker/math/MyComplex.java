package com.netcracker.math;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "("  + real +
                "+" + imag + "i)";
    }

    public boolean isReal(){
        return real != 0;
    }

    public boolean isImaginary(){
        return imag != 0;
    }

    public boolean equals(double real, double imag){
        return Math.abs(this.real - real) < 0.00001 && Math.abs(this.imag - imag) < 0.00001;
    }

    public boolean equals(MyComplex complex){
        return Math.abs(real - complex.real) < 0.00001 && Math.abs(imag - complex.imag) < 0.00001;
    }

    public double magnitude(){
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
    }

    public double argument(){
        return Math.atan(imag / real);
    }

    public MyComplex add(MyComplex right){
        real += right.real;
        imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right){
        real += right.real;
        imag += right.imag;
        return new MyComplex(real, imag);
    }

    public MyComplex subtract(MyComplex right){
        real -= right.real;
        imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right){
        real -= right.real;
        imag -= right.imag;
        return new MyComplex(real, imag);
    }

    public MyComplex multiply(MyComplex right){
        real = real * right.real - imag * right.imag;
        imag = real * right.imag + right.real * imag;
        return this;
    }

    public MyComplex divide(MyComplex right){
        real = (real * right.real + imag * right.imag) / (right.real * right.real + right.imag * right.imag);
        imag = (right.real * imag + real * right.imag) / (right.real * right.real + right.imag * right.imag);
        return this;
    }

    public MyComplex conjugate(){
        return this;
    }
}
