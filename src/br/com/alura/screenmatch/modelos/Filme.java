package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    /*extends aplica herança à uma classe, ou seja, nesse caso o Filme tem tudo que o Titulo tem, é uma extensão. com
    o atributo diretor como complemento (só Filme tem esse atributo)*/
    //filme extende de título e implementa classificavel
    private String diretor;


    //construtor: "método" que tem como função a criação de um objeto em memória
    //o construtor obrigatoriamente tem o mesmo nome da classe
    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);//recebe o nome que chega na string e o ano
    }
    //Em Java, um construtor é um método especial usado para criar e inicializar um objeto recém-criado.
    // Quando uma classe é definida, ela pode ter um ou mais construtores, sendo que se nenhum construtor
    // for definido explicitamente, o Java criará um construtor default (padrão) automaticamente. Um construtor
    // default é um construtor que não possui parâmetros e não executa nenhuma instrução. Ele é chamado sempre que
    // um objeto da classe é criado sem argumentos.

    /*É importante ressaltar que mesmo que um construtor default possa ser útil em alguns casos, é sempre
    recomendável definir explicitamente os construtores da classe, especialmente se a classe tiver atributos
    que precisam ser inicializados com valores específicos ou obrigatórios. Isso também torna o código mais claro
    e fácil de entender.*/


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
    //implícita no java), porque nesse caso queremos que o programa retorne a lista de filmes em texto, e não em objeto
    // (br.com.alura@ etc)
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }


}