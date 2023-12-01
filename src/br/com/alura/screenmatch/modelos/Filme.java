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
}