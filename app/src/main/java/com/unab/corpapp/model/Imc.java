package com.unab.corpapp.model;

public class Imc {
    String IMC, name, stature, weight;

    public Imc(String IMC, String name, String stature, String weight) {
        this.IMC = IMC;
        this.name = name;
        this.stature = stature;
        this.weight = weight;
    }

    public Imc(){

    }

    public String getIMC() {
        return IMC;
    }

    public void setIMC(String IMC) {
        this.IMC = IMC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStature() {
        return stature;
    }

    public void setStature(String stature) {
        this.stature = stature;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
