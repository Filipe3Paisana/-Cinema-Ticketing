
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Lugar;
import models.Pessoa;
import models.Planta;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 9;
        int m = 29;
        Planta planta = new Planta(n, m);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                planta.getM()[i][j] = new Lugar(0, 0, null); // Inicializa todos os lugares como vazios
            }
        }

        // Configuração inicial dos preços e estados dos lugares
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 2 || i == 5 || i == 8) {
                    planta.getM()[i][j].setState(-1);
                    planta.getM()[i][j].setPrice(0);
                } else if (i < 2) {
                    planta.getM()[i][j].setState(0);
                    planta.getM()[i][j].setPrice(15);
                } else if (i < 5) {
                    planta.getM()[i][j].setState(0);
                    planta.getM()[i][j].setPrice(10);
                } else {
                    planta.getM()[i][j].setState(0);
                    planta.getM()[i][j].setPrice(5);
                }
            }
        }
        planta.displayM();
        // Lista para armazenar os clientes que compraram bilhetes
        //ArrayList<Pessoa> clientes = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("=== Menu ===");
            System.out.println("1. Comprar bilhete");
            System.out.println("2. Ver total das vendas");
            System.out.println("3. Ver lista de clientes que compraram bilhetes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o seu nome: ");
                    String nome = scanner.next();
                    Pessoa pessoa = new Pessoa(nome);
                    pessoa.setName(nome);
                    System.out.print("Digite a linha do lugar que deseja comprar: ");
                    int linha = scanner.nextInt() -1;
                    System.out.print("Digite a coluna do lugar que deseja comprar: ");
                    int coluna = scanner.nextInt() -1;

                    // Verificar se a linha e a coluna estão dentro dos limites da planta
                    if (linha >= 0 && linha < n && coluna >= 0 && coluna < m) {
                        // Verificar se o lugar está disponível
                        if (planta.getM()[linha][coluna].getState() == 0) {
                            planta.getM()[linha][coluna].setState(1);
                            planta.getM()[linha][coluna].setPessoa(pessoa);
                            System.out.println("Bilhete comprado com sucesso!");

                            planta.displayM();
                        } else {
                            System.out.println("Desculpe, este lugar já está ocupado.");
                        }
                    } else {
                        System.out.println("Desculpe, linha ou coluna inválida.");
                    }
                    break;


                case 2:

                    double totalVendas = 0;
                    for (int i = 0; i < n; ++i) {
                        for (int j = 0; j < m; ++j) {
                            if (planta.getM()[i][j].getState() == 1) {
                                totalVendas += planta.getM()[i][j].getPrice();
                            }
                        }
                    }
                    System.out.println("Total das vendas:" + totalVendas + "€");
                    break;
                case 3:
                    System.out.println("=== Lista de clientes que compraram bilhetes ===");
                    System.out.printf("%-20s %-10s %-10s %-10s%n", "Nome", "Linha", "Coluna", "Preço (€)");
                    for (int i = 0; i < n; ++i) {
                        for (int j = 0; j < m; ++j) {
                            if (planta.getM()[i][j].getState() == 1) {
                                Pessoa cliente = planta.getM()[i][j].getPessoa();
                                System.out.printf("%-20s %-10d %-10d %-10.2f%n", cliente.getName(), (i + 1), (j + 1), planta.getM()[i][j].getPrice());
                            }
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
        scanner.close();
    }
}
