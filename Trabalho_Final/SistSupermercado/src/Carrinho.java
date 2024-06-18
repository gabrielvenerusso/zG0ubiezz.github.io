import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void visualizarCarrinho() {
        if (produtos.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;
    }

    public void finalizarCompra() {
        double total = calcularTotal();
        System.out.println("Compra finalizada. Total a pagar: R$" + total);
        produtos.clear();
    }
}
