package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    //esses são os atributos, ou seja, as características de um objeto:
    //os atributos precisam ser sempre private

    //@SerializedName("Title") //anotação para indicar a alteração de nomes de forma que fique compatível com o json
    private String nome;
    //@SerializedName("Year") - o serialized não é mais necessário pq agora usei o record
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes; //private: modificador de acesso ou modificador de visibilidade.
    //não deixa ler e nem alterar o valor de um atributo, devemos fazer isso através de um método

    //os construtores geralmente ficam logo depois dos atributos:
    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if(meuTituloOmdb.year().length() > 4){//se o ano tiver mais de 4 caracteres, lançar exception
            throw new ErroDeConversaoDeAnoException("Não é possível converter o ano, pois tem mais de 4 caracteres");
            //lança o erro e cria uma exceção que criamos com a classe ErroDeConversaoDeAnoException
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());//para converter o year para int
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,3));//para converter o runtime
        //para int e excluir o "min"
    }

    //GET: obter valor
    //SET: atribuir valor
    //método Acessor:
    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setNome(String nome) {
        this.nome = nome; /*this: serve para referenciar corretamente e eliminar a confusão entre atributos e parâmetros.
        o NOME em questão é o atributo da classe/objeto atual, não o parâmetro,
        mas também existe um parâmetro chamado nome, então precisamos especificar do que estamos falando.*/
    }
    //^^^atalho: botão direito do mouse > generate > selecionar setters ou getters > selecionar o atributo

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    /*Em Java, os modificadores de acesso são palavras-chave que definem o nível de visibilidade de classes,
    atributos e métodos, sendo que eles ajudam a garantir a segurança e encapsulamento do código.

    Existem quatro tipos de modificadores de acesso em Java: public, protected, private e default
    (também conhecido como package-private).*/

    /*PUBLIC: é o mais permissivo de todos. Uma classe, atributo ou método declarado como public pode ser acessado
    por qualquer classe em qualquer pacote. Ou seja, ele possui visibilidade pública e pode ser utilizado livremente.

    DEFAULT (PACKAGE PRIVATE): não especifica nenhum modificador de acesso. Quando nenhum modificador de acesso é
    especificado, a classe, atributo ou método pode ser acessado apenas pelas classes que estão no mesmo pacote.

    PRIVATE: é o mais restritivo de todos. Uma classe, atributo ou método declarado como private só pode ser
    acessado dentro da própria classe. Ou seja, ele possui visibilidade restrita e não pode ser utilizado por outras classes.
    */


    /*Uma classe é uma estrutura que define um tipo de objeto. A classe é como um molde, que define quais são as
características (atributos) e comportamentos (métodos) que os objetos desse tipo vão possuir.
Por exemplo, podemos definir uma classe chamada Pessoa que tenha os atributos nome e idade,
além do método fazAniversario()
 */

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
    }
    //void é um método sem return, significa que será usado em outro file mas não retorna nada em si
//podemos ler o método como se fosse A MANEIRA DE FAZER ALGO
//ex: a maneira de exibir a ficha técnica, a maneira de avaliar um filme (damos uma nota e o método void não retorna nada, apenas
// armazena coisas e as exibe)
    public void avalia(double nota){
        somaDasAvaliacoes += nota; // somaDasAvaliacoes = somaDasAvaliacoes + nota
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    @Override //Comparable usado na classe PrincipalComListas para utilizar Collections.sort
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());//defino que o nome do Título será comparado com o nome
        //de outro Título
    }

    @Override //anotação para sobrescrever o toString da classe mãe implícita Object, nesse caso precisamos sobrescrever
    //para que o retorno do json na classe PrincipalComBusca venha concatenado e em forma de texto.
    public String toString() {
        return "nome: " + nome + "; ano de lançamento: " + anoDeLancamento + "; duração em minutos: " + duracaoEmMinutos;
    }
}

/* PACKAGES: organiza o código pela funcionalidade de suas classes
é comum que seja escrito ao contrário. Exemplo: ao invés de ser screenmatch.alura.com.br, ele vai ser br.com.alura.screenmatch
 */

/*Sobre o uso do nome de domínio reverso da empresa ou organização como parte do nome do pacote: Por exemplo,
se o nome de domínio da empresa fosse "minhaempresa.com.br" e o projeto Java fosse chamado de "meuprojeto",
o nome do pacote de domínio reverso seria br.com.minhaempresa.meuprojeto, sendo que dentro desse pacote principal
podemos ter diversos subpacotes, para melhor organização do código do projeto.*/




