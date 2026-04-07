package service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivos {

    public static void salvarDados(Conta conta){
        try(FileWriter fw = new FileWriter("dados_bancario.txt");
            PrintWriter pw = new PrintWriter(fw)){

            pw.println("========Dados do Cliente========");
            pw.println("Nome: " + conta.getNome());
            pw.println("Endereço: " + conta.getEndereco());
            pw.println("Data de Nascimento: " + conta.getDataNascimento());
            pw.println("Saldo Final: R$" + conta.getSaldo());
            pw.println("================================");

            System.out.println("Arquivo 'dados_bancarios.txt' gerado com sucesso!");
            System.out.println();

        }catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
