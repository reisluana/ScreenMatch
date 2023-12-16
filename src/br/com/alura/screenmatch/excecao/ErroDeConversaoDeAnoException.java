package br.com.alura.screenmatch.excecao;

public class ErroDeConversaoDeAnoException extends RuntimeException {
    //atributo:
    private String mensagem;

    //construtor:
    public ErroDeConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override//sobrescrevendo o método getMessage para fazê-lo retornar a mensagem do construtor que está na classe Titulo
    // ("Não é possível converter o ano etc")
    public String getMessage() {
        return this.mensagem;
    }
}
