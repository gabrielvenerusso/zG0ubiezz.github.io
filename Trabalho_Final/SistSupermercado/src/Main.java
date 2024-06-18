import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carrinho carrinho = new Carrinho();

        while (true) {
            System.out.println("Bem-vindo ao supermercado! Escolha uma opção:");
            System.out.println("1. Adicionar produto ao carrinho");
            System.out.println("2. Visualizar carrinho");
            System.out.println("3. Finalizar compra");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço do produto: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    Produto produto = new Produto(nome, preco, quantidade);
                    carrinho.adicionarProduto(produto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 2:
                    carrinho.visualizarCarrinho();
                    break;
                case 3:
                    carrinho.finalizarCompra();
                    break;
                case 4:
                    System.out.println("Obrigado por usar o sistema do supermercado!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}