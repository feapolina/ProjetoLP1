public class Jogador extends Pessoa{


    /* construtor do jogador */
    public Jogador(String nome) {
        this.nome = nome;
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void ganharPontos(int pontos) {
        this.pontos += pontos;
    }

    public void perderPontos(int nivelDeDificuldade){
        if (nivelDeDificuldade == 1){
            pontos -= 10;
        } else if (nivelDeDificuldade == 2){
            pontos -= 20;
        } else{
            pontos -= 30;
        }
    }

}
