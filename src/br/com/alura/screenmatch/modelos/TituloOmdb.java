package br.com.alura.screenmatch.modelos;
//no record só declaramos o cabeçalho, já que é imutável. Pois, não queremos mexer com os dados, simplesmente traduzir
//para transferir de um lugar para o outro.
//o record é responsável por criar o tipo TituloOmdb para "converter", ou seja, fazer a assimilação entre os atributos do json
//e os nossos atributos da classe Titulo, pois os atributos da classe Titulo e do json são diferentes. ex: na Titulo temos nome,
//no json esse atributo é chamado "title"
//usando o record dessa maneira, evito fazer o @SerializedName de cada atributo, o que seria passível a erro e mais demorado.
//principalmente se eu decidir consumir APIs diferentes
public record TituloOmdb(String title, String year, String runtime) { //os parâmetros são os atributos que precisamos do json
    //os atributos do json estão com letra maiúscula inicial, o que fará com que retorne NULL. sendo assim, para resolver isso,
    //criamos um builder na classe PrincipalComBusca dizendo qual é o padrão de nomenclatura do json ("JSON Field Naming Support" na documentação do GSON)

}

/*o Record é um recurso que permite representar uma classe imutável, contendo apenas atributos, construtor e métodos
de leitura, de uma maneira muito simples e enxuta.

Esse recurso se encaixa perfeitamente quando precisamos criar um objeto apenas para representar dados,
sem nenhum tipo de comportamento.*/