package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;
//o import é a forma que uma classe se referencia a outra quando estão em pacotes diferentes

public class Principal {
    public static void main(String[] args) {
        //o tipo abaixo é chamado de tipo referência
        Filme meuFilme = new Filme("O Poderoso Chefão", 1978);//essa parte "new Filme" cria um
        // objeto, um espaço na memória. o nome disso é instanciar
        //enquanto que a parte da esquerda vai referenciar, ou seja, está "guardando" onde o objeto está

        /*um objeto, é uma instância de uma classe, sendo por meio dele que conseguimos representar informações
        na aplicação, pois a classe serve apenas para padronizar os objetos, mas não para representar um objeto em si.
        Para criar um objeto em Java, precisamos utilizar a palavra reservada new seguida do nome da classe
        e de parênteses vazios.*/

        /*Podemos criar vários objetos do tipo FILME, sendo que todos eles terão os mesmos atributos e métodos,
        já que são da mesma classe, mas cada um pode possuir informações distintas. Exemplo: meuFilme2 será
        outro filme, por exemplo, Interstellar

        Filme meuFilme2 = new Filme();

        meuFilme2.setNome("Interstellar");*/

        //meuFilme.setNome("O Poderoso Chefão"); - essa linha não é mais necessária, pois usamos o construtor
        //meuFilme.setAnoDeLancamento(1978); - essa linha não é mais necessária, pois usamos o construtor
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
            System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
            System.out.println(meuFilme.pegaMedia());


        Filme meuFilme2 = new Filme("Interstellar", 2014);
        //meuFilme2.setNome("Interstellar"); - essa linha não é mais necessária, pois usamos o construtor
        //meuFilme2.setAnoDeLancamento(2014); - essa linha não é mais necessária, pois usamos o construtor
        meuFilme2.setDuracaoEmMinutos(200);


        Serie minhaSerie = new Serie("Lost", 2000);
        //minhaSerie.setNome("Lost"); - essa linha não é mais necessária, pois usamos o construtor
        //minhaSerie.setAnoDeLancamento(2000); - essa linha não é mais necessária, pois usamos o construtor
        minhaSerie.exibeFichaTecnica();
        minhaSerie.setTemporadas(10);
        minhaSerie.setEpisodiosPorTemporada(10);
        minhaSerie.setMinutosPorEpisodio(50);
            System.out.println("Duração para maratonar: " + minhaSerie.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(meuFilme2);
        calculadora.inclui(minhaSerie);
            System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(minhaSerie);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        Filme meuFilme3 = new Filme("Dogville", 2003);
        meuFilme3.setDuracaoEmMinutos(200);
        //meuFilme3.setNome("Dogville"); - essa linha não é mais necessária, pois usamos o construtor
        //meuFilme3.setAnoDeLancamento(2003); - essa linha não é mais necessária, pois usamos o construtor
        meuFilme3.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();//também seria possível usar var listaDeFilmes = new ArrayList
        //limitações:
        //ao usar var, o tipo da variável será inferido automaticamente pelo compilador com base no valor atribuído.
        //Não é possível usar var em variáveis sem valor inicial. É necessário atribuir um valor à variável na mesma
        // linha em que ela é declarada.
        //O tipo da variável deve ser inferido automaticamente pelo compilador. Isso significa que não é possível
        // utilizar var em variáveis cujo tipo não possa ser inferido automaticamente.
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(meuFilme2);
        listaDeFilmes.add(meuFilme3);
            System.out.println("Tamanho da lista: " + listaDeFilmes.size());
            System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
            System.out.println(listaDeFilmes); //método toString implementado na classe Filme:
            System.out.println("toString do filme " + listaDeFilmes.get(0).toString());

        //Em Java, arrays são estruturas de dados que permitem armazenar uma coleção de elementos do mesmo tipo.
        //Para declarar um array em Java, é preciso definir seu tipo e tamanho. Por exemplo, para criar um array
        // de inteiros com tamanho 5, podemos escrever o seguinte código:
        //int[] numeros = new int[5];
        //Aqui, estamos declarando um array chamado "numeros" do tipo "int" e com tamanho 5.
        //Após declarar um array, podemos inicializá-lo com valores. Por exemplo, podemos preencher o array "numeros"
        // com os números de 1 a 5 da seguinte forma:
        //for (int i = 0; i < numeros.length; i++) {
        //    numeros[i] = i + 1;
        //Aqui, estamos percorrendo o array "numeros" utilizando um loop for e preenchendo cada posição com seu
        // respectivo índice mais 1.

        //Também é possível criar arrays de objetos e não apenas de tipos primitivos. Por exemplo:
        //Filme[] filmes = new Filme[2];
        //Filme filme1 = new Filme("Avatar", 2009);
        //Filme filme2 = new Filme("Dogville", 2003);
        //
        //filmes[0] = filme1;
        //filmes[1] = filme2;

        //limitações do array:
        //Tamanho fixo: o tamanho de um array é fixo e não pode ser alterado após a sua criação. Isso pode ser
        //problemático em situações em que o tamanho dos dados a serem armazenados é desconhecido ou variável.
        //Ausência de métodos: arrays não possuem métodos que permitam a inserção, remoção ou pesquisa de elementos
        //de forma eficiente. Isso pode levar a soluções de código complicadas e ineficientes para tarefas simples.

        //Justamente por conta desses problemas e dificuldades é que não devemos utilizar arrays para representar
        //uma coleção de elementos, mas sim alguma classe do Java, como a ArrayList, que encapsula e abstrai um array,
        //facilitando a sua utilização via métodos e deixando o código do projeto mais simples de entender e evoluir.


        //DESAFIO: carrinho de compras que permite até 10 itens por carrinho:
        //public class Carrinho {
        //
        //  ArrayList<Produto> produtos = new ArrayList<>();
        //
        //  public void adicionaProduto(Produto produto) {
        //  if (produtos.size() < 10) {
        //    produtos.add(produto);
        //  } else {
        //    System.out.prinln("Carrinho cheio!");
        //  }
        // }
        //
        //}

        //construtor: método que tem como função a criação de um objeto em memória (construtor está na classe Filme,
        // que, por sua vez, chama o construtor da classe mãe - palavra reservada super)
        var filmeDaLuana = new Filme("Jogos Vorazes", 2012);
        //filmeDaLuana.setNome("Jogos Vorazes"); - essa linha não é mais necessária, pois usamos o construtor
    }

}
