public class Main {
    public static void main(String[] args) {
        Retangulo retanguloNormal = new RetanguloNormal("normal");
        retanguloNormal.desenhar();

        Retangulo retanguloColorido = new RetanguloColorido("colorido");
        retanguloColorido.desenhar();

        Retangulo retanguloEstrela = new RetanguloEstrela("arredondado");
        retanguloEstrela.desenhar();
    }
}
