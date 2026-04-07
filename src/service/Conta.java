package service;

import java.time.LocalDate;

public abstract class Conta {
    protected final String nome;
    LocalDate dataNascimento;
    protected String endereco;
    protected double saldo;

    public Conta(String nome,LocalDate dataNascimento, String endereco){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public void depositar(double valor){
        if(valor > 0) this.saldo += valor;
        else throw new IllegalArgumentException("valor incorreto para realizar a operação.");
    }

    public double getSaldo(){
        return saldo;
    }

    public abstract void saque(double valor);
}