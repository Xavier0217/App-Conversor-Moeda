package com.example.conversormoeda;

public class Moeda {
    private double valorReais;

    public Moeda(double valorReais) {
        this.valorReais = valorReais;
    }

    public double converterDolar() {

        double valorMoeda = 4.97;

        double conversaoDolar = valorReais / valorMoeda;

        return conversaoDolar;

    }

    public double converterEuro() {

        double valorMoeda = 5.36;

        double conversaoEuro = valorReais / valorMoeda;

        return conversaoEuro;
    }
}