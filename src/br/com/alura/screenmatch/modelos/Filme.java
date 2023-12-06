package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    /*extends aplica herança à uma classe, ou seja, nesse caso o Filme tem tudo que o Titulo tem, é uma extensão. com
    o atributo diretor como complemento (só Filme tem esse atributo)*/
    //filme extende de título e implementa classificavel
    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override //implementação do getClassificacao, o método presente na interface Classificavel
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override//sobrescrever o toString da classe mãe object (essa classe existe em todos os programas, é uma classe
    //implícita no java), porque nesse caso queremos que o programa retorne a lista de filmes com os nomes, e não o endereço
    //deles (br.com.alura@ etc)
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}