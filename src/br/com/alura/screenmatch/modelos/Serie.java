package br.com.alura.screenmatch.modelos;

public class Serie extends Titulo {
    private int temporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;


    //construtores:
    //se a classe mãe tem um construtor, então obrigatoriamente a classe filha Serie precisa ter também
    //NÃO HÁ HERANÇA DE CONSTRUTORES
    //um construtor pode testar, validar, fazer conexão com o banco etc
    //o construtor é mais um recurso para encapsular objetos

    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);//a palavra reservada super chama o construtor da classe mãe
    }



    public int getTemporadas() {
        return temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override /*possibilita a sobrescrita de um método. indica que já existe esse método na classe mãe/super classe (Titulo).
    nesse caso, foi adotado pois não sabemos quantos minutos uma série ativa terá no total, então precisamos de um
    método DuracaoEmMinutos() específico para as series*/
    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }
}

//classe mãe ou superclasse: generalização
//classe filha ou subclasse: especialização
//métodos ou funções
//atributos ou campos
