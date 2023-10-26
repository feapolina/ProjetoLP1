public class Pergunta {
    private String pergunta;
    private String resposta;
    private int pontos;

    /* construtor da classe */
    public Pergunta(String pergunta, String resposta, int pontos) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.pontos = pontos;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public int getPontos() {
        return pontos;
    }
}
