package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Produto implements Comparable<Produto> {

    private String nome;
    private String descricao;
    private double valor;
    private boolean disponivel;
    private static List<Produto> produtos = new ArrayList<>();

    public Produto(String nome, String descricao, double valor, boolean disponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public int compareTo(Produto outroProduto) {
        return Double.compare(this.valor, outroProduto.valor);
    }

    public static void cadastrarProduto(Scanner scanner) {
        System.out.println("=== CADASTRO DE PRODUTO === ");

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Descricao do produto: ");
        String descricao = scanner.nextLine();

        System.out.print("Valor do produto: R$");
        double valor = scanner.nextDouble();

        System.out.print("Disponivel para venda (sim/nao): ");
        boolean disponivel = scanner.next().equalsIgnoreCase("sim");

        Produto novoProduto = new Produto(nome, descricao, valor, disponivel);
        produtos.add(novoProduto);

        System.out.println("Produto cadastrado com sucesso!\n");

    }

    public static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado.\n");
        } else {
            Collections.sort(produtos);
            System.out.println("\n=== LISTAGEM DE PRODUTOS ===");
            System.out.println("Nome\tValor");
            for (Produto produto : produtos) {
                System.out.println(produto.getNome() + "\tR$" + produto.getValor());
            }
        }
    }

}