public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double somaDasAvaliacoes;
    int totalDeAvaliacoes;
    int duracaoEmMinutos;
//esses são os atributos, ou seja, as características de um objeto

    /*Uma classe é uma estrutura que define um tipo de objeto. A classe é como um molde, que define quais são as
características (atributos) e comportamentos (métodos) que os objetos desse tipo vão possuir.
Por exemplo, podemos definir uma classe chamada Pessoa que tenha os atributos nome e idade,
além do método fazAniversario()
 */

    void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
    }
//void é um método sem return, significa que será usado em outro file mas não retorna nada em si
//podemos ler o método como se fosse A MANEIRA DE FAZER ALGO
//ex: a maneira de exibir a ficha técnica, a maneira de avaliar um filme (damos uma nota e o método void não retorna nada, apenas
// armazena coisas e as exibe)
    void avalia(double nota){
        somaDasAvaliacoes += nota; // somaDasAvaliacoes = somaDasAvaliacoes + nota
        totalDeAvaliacoes++;
    }

    double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }
}

