public class RetanguloEstrela extends Retangulo{
    public RetanguloEstrela(String texto) {super(texto);}

    @Override
    public void desenhar() {
        int comprimento = texto.length() + 4;
        System.out.println(" " + "*".repeat(comprimento - 2));
        System.out.println("| " + texto + " |");
        System.out.println(" " + "*".repeat(comprimento - 2));
    }
}
