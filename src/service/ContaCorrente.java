package service;

import java.time.LocalDate;

public class ContaCorrente extends Conta{

    public ContaCorrente(String nome, LocalDate dataNascimento, String endereco){
        super(nome, dataNascimento, endereco);
    }

    @Override
    public void saque(double valor){
       saldo -= valor;
    }
}
