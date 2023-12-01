package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Episodio implements Classificavel {
    private int numero;
    private String nome;
    private Serie serie;
    private int totalVisualizacoes;

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override //implementação do getClassificacao, o método presente na interface Classificavel
    //aqui nesse caso a regra é diferente da regra aplicada na classificacao de Filme, só para exemplificar que é
    //possível aplicar regras diferentes por classe quando a implementação da interface é utilizada em mais de uma classe
    public int getClassificacao() {
        if (totalVisualizacoes > 100){
            return 4;
        } else {
            return 2;
        }
    }
}
