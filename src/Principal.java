import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
//o import é a forma que uma classe se referencia a outra quando estão em pacotes diferentes

public class Principal {
    public static void main(String[] args) {
        //o tipo abaixo é chamado de tipo referência
        Filme meuFilme = new Filme();//essa parte "new Filme" cria um objeto, um espaço na memória. o nome disso é instanciar
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

        meuFilme.setNome("O Poderoso Chefão");
        meuFilme.setAnoDeLancamento(1978);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
            System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
            System.out.println(meuFilme.pegaMedia());


        Filme meuFilme2 = new Filme();
        meuFilme2.setNome("Interstellar");
        meuFilme2.setAnoDeLancamento(2014);
        meuFilme2.setDuracaoEmMinutos(200);


        Serie minhaSerie = new Serie();
        minhaSerie.setNome("Lost");
        minhaSerie.setAnoDeLancamento(2000);
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
    }

}
