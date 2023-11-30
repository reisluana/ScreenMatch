package br.com.alura.screenmatch.modelos;

public class Filme extends Titulo{
    /*extends aplica herança à uma classe, ou seja, nesse caso o Filme tem tudo que o Titulo tem, é uma extensão. com
    o atributo diretor como complemento (só Filme tem esse atributo)*/
    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}