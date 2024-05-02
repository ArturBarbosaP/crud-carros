package com.company;

public class Carro
{
    public String modelo;
    public String marca;
    public int ano;
    public String cor;
    public String chassi;
    public int revisoes;
    public double km;

    public Carro (String modelo, String marca, int ano, String cor, String chassi)
    {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.chassi = chassi;

        this.revisoes = 0;
        this.km = 0;
    }
}