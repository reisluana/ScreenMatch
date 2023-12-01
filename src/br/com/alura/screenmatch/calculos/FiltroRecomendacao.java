package br.com.alura.screenmatch.calculos;

public class FiltroRecomendacao {
//quando chamar o FiltroRecomendacao para filtrar alguém que implementou a interface Classificavel, o filtro vai identificar
//a quantidade de estrelas (através da lógica de avaliação de cada classe - filme ou episodio) e vai mostrar a mensagem equivalente
//à quantidade
    public void filtra(Classificavel classificavel){
        if (classificavel.getClassificacao() >= 4){
            System.out.println("Está entre os preferidos do momento");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Para assistir mais tarde");
        }
    }
}
