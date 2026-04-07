package service;

import java.time.LocalDate;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(String nome, LocalDate dataNascimento, String endereco){
        super(nome, dataNascimento, endereco);
    }


    @Override
    public void saque(double valor){
        double taxa = 1.01;
        double valorSaque = valor * taxa;

        if(saldo < valorSaque){
            throw new IllegalArgumentException("Saldo insuficiente para realizar a operação.");
        }
        if(valor <= 0){
            throw new IllegalArgumentException("valor incorreto para realizar a operação.");
        }

        saldo -= valorSaque;
    }
}
