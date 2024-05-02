package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)
    {
        List<Carro> listaCarros = new ArrayList<>();

        while (true)
        {
            int opcao = Menu();

            switch (opcao)
            {
                case 1:
                    Create(listaCarros);
                    break;
                case 2:
                    ReadAll(listaCarros);
                    break;
                case 3:
                    Read(listaCarros);
                    break;

                case 4:
                    Update(listaCarros);
                    break;

                case 5:
                    Delete(listaCarros);
                    break;

                default:
                    System.out.println("Opcao Invalida!");
            }
        }
    }

    public static void Create(List<Carro> listaCarros)
    {
        System.out.println();

        System.out.print("Informe o modelo do carro: ");
        String modelo = LerValorString();

        System.out.print("Informe a marca do carro: ");
        String marca = LerValorString();

        System.out.print("Informe o ano do carro: ");
        int ano = LerValorInt();

        System.out.print("Informe a cor do carro: ");
        String cor = LerValorString();

        System.out.print("Informe o chassi do carro: ");
        String chassi = LerValorString();

        Carro carro = new Carro(modelo, marca, ano, cor, chassi);

        listaCarros.add(carro);

        System.out.println("Carro criado!");

        System.out.println();
    }

    public static void ReadAll(List<Carro> listaCarros)
    {
        for (Carro carro : listaCarros)
        {
            System.out.println();
            System.out.println("Marca: " + carro.marca);
            System.out.println("Modelo: " + carro.modelo);
            System.out.println("Ano: " + carro.ano);
            System.out.println("Cor: " + carro.cor);
            System.out.println("Chassi: " + carro.chassi);
            System.out.println("Revisoes: " + carro.revisoes);
            System.out.println("Km: " + carro.km);
            System.out.println();
            System.out.println("-----------------------------");
        }
    }

    public static void Read(List<Carro> listaCarros)
    {
        System.out.print("Informe o chassi desejado: ");
        String chassi = LerValorString();

        Carro carro = listaCarros.stream().filter(c -> c.chassi.equals(chassi)).findFirst().orElse(null);
        //List<Carro> carros = listaCarros.stream().filter(c -> c.chassi.equals(chassi)).collect(Collectors.toList()); quando retorna varioos carros

        if (carro != null)
        {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Marca: " + carro.marca);
            System.out.println("Modelo: " + carro.modelo);
            System.out.println("Ano: " + carro.ano);
            System.out.println("Cor: " + carro.cor);
            System.out.println("Chassi: " + carro.chassi);
            System.out.println("Revisoes: " + carro.revisoes);
            System.out.println("Km: " + carro.km);
            System.out.println();
            System.out.println("-----------------------------");
        }
        else
        {
            System.out.println("O carro nao existe!");
        }
    }

    public static void Update(List<Carro> listaCarros)
    {
        System.out.print("Informe o chassi desejado: ");
        String chassi = LerValorString();

        Carro carro = listaCarros.stream().filter(c -> c.chassi.equals(chassi)).findFirst().orElse(null);

        if (carro != null)
        {
            System.out.println();

            System.out.print("Informe o modelo do carro: ");
            carro.modelo = LerValorString();

            System.out.print("Informe a marca do carro: ");
            carro.marca = LerValorString();

            System.out.print("Informe o ano do carro: ");
            carro.ano = LerValorInt();

            System.out.print("Informe a cor do carro: ");
            carro.cor = LerValorString();

            System.out.println();
        }
        else
        {
            System.out.println("O carro nao existe!");
        }

    }

    public static void Delete(List<Carro> listaCarros)
    {
        System.out.print("Informe o chassi desejado: ");
        String chassi = LerValorString();

        Carro carro =  listaCarros.stream().filter(c -> c.chassi.equals(chassi)).findFirst().orElse(null);

        if (carro != null)
        {
            listaCarros.remove(carro);
        }
        else
        {
            System.out.println("O carro nao existe!");
        }
    }

    public static int Menu()
    {
        System.out.println("Menu");
        System.out.println("-----------------------------");
        System.out.println("1 - Cadastrar um novo carro");
        System.out.println("2 - Ler todos os carros");
        System.out.println("3 - Ler apenas um carro");
        System.out.println("4 - Atualizar um carro");
        System.out.println("5 - Deletar um carro");
        System.out.println("-----------------------------");
        System.out.print("opcao: ");
        int opcao = LerValorInt();
        System.out.println("-----------------------------");
        return opcao;
    }

    public static int LerValorInt()
    {
        Scanner valor = new Scanner(System.in);
        return valor.nextInt();
    }

    public static String LerValorString()
    {
        Scanner valor = new Scanner(System.in);
        return valor.nextLine();
    }
}