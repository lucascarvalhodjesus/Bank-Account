package app;

import service.Conta;
import service.ContaCorrente;
import service.ContaPoupanca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Conta minhaConta = null;

        boolean sair = false;
        do{
            System.out.println("1 - Abrir uma conta:");
            System.out.println("2 - Operação bancaria:");
            System.out.println("3 - sair!");
            int menu = sc.nextInt();
            System.out.println();
            sc.nextLine();

            switch (menu){

                case 1:
                    System.out.println("Seu nome:");
                    String nome = sc.nextLine();
                    System.out.println("Digite a data de nascimento (dd/mm/aaaa):");
                    String dataDigitada = sc.nextLine();
                    LocalDate nascimento = LocalDate.parse(dataDigitada, formatoBR);
                    System.out.println("Seu endereço:");
                    String endereco = sc.nextLine();
                    System.out.println("Qual deseja criar:");
                    System.out.println("1 - conta corrente | 2 - conta poupança");
                    int menu_2 = sc.nextInt();

                    if(menu_2 == 1){
                        minhaConta = new ContaCorrente(nome, nascimento, endereco);
                        System.out.println();
                        break;
                    }

                    if(menu_2 == 2){
                        minhaConta = new ContaPoupanca(nome, nascimento, endereco);
                        System.out.println();
                        break;
                    }

                    break;

                case 2:
                    try{
                        if(minhaConta != null){
                            boolean voltar = false;
                            do {
                                System.out.println("saldo em conta: " + minhaConta.getSaldo());
                                System.out.println("Qual operação deseja fazer:");
                                System.out.println("1 - Depositar | 2 - Sacar | 3 - Sair para o menu");
                                int menu_3 = sc.nextInt();
                                System.out.println();
                                sc.nextLine();

                                switch (menu_3) {
                                    case 1:
                                        System.out.println();
                                        System.out.println("Qual valor deseja depositar:");
                                        double valorDeposito = sc.nextDouble();
                                        minhaConta.depositar(valorDeposito);
                                        System.out.println();

                                        break;

                                    case 2:
                                        System.out.println("Qual valor deseja sacar:");
                                        double valorSaque = sc.nextDouble();
                                        minhaConta.saque(valorSaque);
                                        System.out.println();

                                        break;

                                    case 3:
                                        System.out.println();
                                        voltar = true;
                                }
                            }while(!voltar);
                        }else {
                            System.out.println("Erro: Crie uma conta no menu 1 primeiro!");
                        }
                    }catch(IllegalArgumentException e){
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }

                    break;

                case 3:
                    System.out.println();
                    System.out.println("Obrigado!!");
                    sair = true;
            }
        }while(!sair);

        sc.close();
    }
}
