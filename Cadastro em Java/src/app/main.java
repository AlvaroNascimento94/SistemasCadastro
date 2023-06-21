package app;

import java.util.Scanner;

import entities.Produto;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n=== CADASTRO DE PRODUTOS ===");
            System.out.println("1. Listar produtos");
            System.out.println("2. Cadastrar novo produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Produto.listarProdutos();
                    System.out.print("Deseja cadastar outro produto?(sim/nao) ");
                    String opcao2 = scanner.nextLine();

                    if (opcao2.equalsIgnoreCase("sim")) {
                        Produto.cadastrarProduto(scanner);                       
                    }
                    break;
                case 2:
                    Produto.cadastrarProduto(scanner);
                    Produto.listarProdutos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.err.println("Opcao invalida! Tente novamente.");
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
}
