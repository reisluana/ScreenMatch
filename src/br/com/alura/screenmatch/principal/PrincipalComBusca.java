package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca ="";
        List<Titulo> titulos = new ArrayList<>();
        //Gson gson = new Gson(); //gson é uma lib que converte objetos java em json e json em objetos java
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();//builder

        //enquanto o usuário for digitando o nome de um filme o programa vai continuar rodando e pedindo um novo nome
        //quando o usuário digitar SAIR, o programa encerra

        //enquanto a variável "busca" (ou seja, o que o usuário escreve) for diferente de SAIR
        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=10392a34";
            //o busca.replace substitui o espaço entre as palavras por um + para fazer a concatenação

            try { //"tente fazer isso, se houver erro faça isso" com o try-catch contornamos o erro e evitamos que o
                //programa seja interrompido

                //classes HttpClient, HttpRequest e HttpResponse
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);//criamos um record responsável por criar o tipo TituloOmdb

                System.out.println(meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);//recebe um TituloOmdb e devolve um Titulo
                //dessa maneira "convertemos" para os nossos atributos da classe Titulo (ou seja, nome e ano de lançamento, e não
                //title e year, como está no json)
                System.out.println("Título já convertido:");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);//adiciona à uma lista todos os títulos que o usuário digitar para busca


            } catch (
                    NumberFormatException e) { //e = exception (nesse caso, o erro é no formato da data de lançamento que o json retorna)
                System.out.println("Erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) { //essas duas exceptions são os erros que aparecem no terminal
                //(nesse caso, o erro é na busca quando o user digita um filme com 2 nomes e espaço entre eles, exemplo: top gun)
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos); //dá o println de todos os filmes que o usuário digitou e adicionou à lista


        //a classe File pertence ao pacote java.io, um dos mais importantes pois fornece classes e interfaces para
        //entrada e saída de dados em vários formatos, como arquivos, rede, teclado, dentre outros.
        //essa classe representa um arquivo ou diretório no sistema de arquivos do computador, permitindo que
        //você crie, delete, liste e manipule arquivos e diretórios.
        //o construtor abaixo cria um arquivo e escreve nele todos os filmes que buscamos no programa:
        FileWriter escrita = new FileWriter("filmes.json");//o argumento do construtor é o caminho do arquivo ou diretório
        escrita.write(gson.toJson(titulos));//o gson transforma o texto em json
        escrita.close();

        System.out.println("O programa finalizou corretamente");
    }
}

/*
* exceções =  são "erros" que podem ser previstos, tratáveis e antecipados.
*
* No Java, as exceções são organizadas em uma hierarquia de classes. Todas as exceções são subclasses da
* classe Throwable, sendo que ela possui duas subclasses principais: Exception e Error.
*
* As exceções que herdam da classe Exception são chamadas de exceções verificadas (checked exceptions).
* Isso significa que essas exceções devem ser tratadas explicitamente em um bloco try-catch ou declaradas em uma
* cláusula throws na assinatura do método.
*
* erros = As exceções que herdam da classe Error representam erros irrecuperáveis pelo sistema, como falta de
* memória ou falhas internas.
*
* RuntimeException = Além disso, existe ainda a classe de exceção RuntimeException, que é uma subclasse direta de
* Exception, e as classes que herdam dela são chamadas de exceções não verificadas (unchecked exception, é opcional dar try-catch).
 * */


/*
* sobre o try-catch e tratamento de erros/exceções:
* O bloco finally é opcional, mas pode ser útil em algumas situações. O finally é usado para executar um bloco de
* código independentemente de ocorrer uma exceção ou não, ou seja, ele sempre é executado.
* Isso pode ser útil quando precisamos executar um código tanto no try, caso não ocorra uma
* exceção, quanto no catch, caso uma exceção seja lançada.
*
* exemplo:
* try {
  metodoQuePodeLancarExcecao();
  System.out.println("Executou");
} catch (Exception e) {
  System.out.println("Deu erro!");
} finally {
  System.out.println("Finalizou!");
}
*
* nesse caso, a mensagem "finalizou" sempre será executada, independente se o programa caiu no try ou no catch.
* */



/* LENDO UM ARQUIVO COM A CLASSE SCANNER:
No código abaixo, estamos lendo um arquivo chamado arquivo.json e imprimindo o conteúdo do arquivo linha por linha
no console. O método hasNextLine() verifica se há mais linhas a serem lidas, enquanto o método nextLine() lê a próxima
linha do arquivo.



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraDeArquivo {
    public static void main(String[] args) {
        try {
            File arquivo = new File("arquivo.json");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.println(linha);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }
}
* */