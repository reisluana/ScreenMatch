package br.com.alura.screenmatch.calculos;

public interface Classificavel {
    //interface é um recurso utilizado também para ser implementado por uma classe que já é uma extensão
    //a classe que utiliza uma interface precisa utilizar todos os métodos presentes na interface
    //nesse caso aqui definimos os métodos que queremos que sejam comuns a episodio, titulo etc e qualquer outra classe
    //que irá implementar a interface Classificavel
    int getClassificacao();
}

/*interfaces são uma forma de definir um contrato que as classes devem seguir, sendo que ele define quais métodos
devem ser implementados pelas classes que o implementarem. Interfaces permitem que diferentes classes possam ser
tratadas de maneira padronizada, via polimorfismo, tornando assim o código fácil de estender com novos comportamentos.*/

/* numa interface todos os métodos são públicos, não sendo então necessário utilizar a palavra reservada public
na declaração deles;*/
