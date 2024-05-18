class RetanguloColorido extends Retangulo{
    public RetanguloColorido(String texto) {
        super(texto);
    }

    @Override
    public void desenhar() {
        final String ANSI_RESET = "\u001B[0m";
        final String PURPLE = "\033[0;35m";
        int comprimento = texto.length() + 4;
        System.out.println(PURPLE + " " + "-".repeat(comprimento - 2) + ANSI_RESET);
        System.out.println(PURPLE + "| " + texto + " |" + ANSI_RESET);
        System.out.println(PURPLE +" " + "-".repeat(comprimento - 2) + ANSI_RESET);
    }
}
