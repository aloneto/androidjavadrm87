package br.faculdade.projetomultiplastelas;

import java.io.Serializable;

public class PessoaVO implements Serializable {
    private String nome;
    private int idade;
    private double valorHora;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
