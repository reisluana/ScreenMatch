package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {
    public static void main(String[] args) {
        //No Java, toda variável de objeto é na verdade uma referência a esse objeto que foi alocado na memória.
        Filme meuFilme = new Filme("O Poderoso Chefão", 1978);
        //No exemplo de código acima, criamos um novo objeto da classe Filme e armazenamos uma referência a ele na variável meuFilme.
        meuFilme.avalia(9);
        Filme meuFilme2 = new Filme("Interstellar", 2014);
        meuFilme2.avalia(10);
        Filme meuFilme3 = new Filme("Dogville", 2003);
        meuFilme3.avalia(10);
        var filmeDaLuana = new Filme("Jogos Vorazes", 2012);
        filmeDaLuana.avalia(8);
        Serie minhaSerie = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(meuFilme2);
        lista.add(meuFilme3);
        lista.add(filmeDaLuana);
        lista.add(minhaSerie);

        for (Titulo item: lista) { //para cada variável tipo Titulo (que aqui chamamos de item) que está dentro da lista
            System.out.println(item.getNome());
            if (item instanceof Filme filme){ //se o item é um filme, mostrar a classificação + declaração da var na mesma linha
                //(essa prática do instanceof não é muito recomendada, é bom evitar, mas é possível encontrar em códigos legados por aí)
                System.out.println("Classificação: " + filme.getClassificacao());
            }
            //nesse caso, getClassificacao() só existe em Filme, não existe em Titulo, então aplicamos o instanceof
        }

        //A forma mais comum de percorrer uma lista no Java é utilizando o laço foreach tradicional, também conhecido
        // como for-each. Esse laço permite que se percorra todos os elementos de uma lista, sem a necessidade de se preocupar
        // com índices ou o tamanho dela, tornando o código mais simples e legível.
        //Esse loop for percorre todos os elementos da lista, atribuindo cada um deles à variável nome, que é usada
        // para imprimir o valor na tela.

        /*
        No entanto, a partir do Java 8, foi adicionado na interface List, a qual a classe ArrayList implementa,
        um novo método chamado forEach, que possibilita a iteração sobre os elementos da lista de forma mais concisa
        e elegante. Por exemplo, o exemplo anterior pode ser reescrito utilizando o método forEach da seguinte forma:

        nomes.forEach(nome -> System.out.println(nome));

        Nesse caso, o método forEach é chamado sobre a lista nomes e recebe como parâmetro uma expressão
        lambda que realiza a impressão do valor na tela. A expressão lambda nome -> System.out.println(nome) é
        uma forma compacta de definir uma função que recebe um parâmetro nome e realiza a operação de impressão.

        É possível simplificar ainda mais o exemplo de código anterior, utilizando o recurso conhecido como Method
        Reference, que nada mais é do que uma forma reduzida de uma expressão lambda:

        nomes.forEach(System.out::println);

        No código anterior, o símbolo :: é a sintaxe do Method Reference
        */
    }
}