public abstract class Pessoa implements interfaceQuiz{
    protected String nome;
    protected int pontos;

    @Override
    public abstract void ganharPontos(int pontos);


    @Override
    public abstract void perderPontos(int nivelDeDificuldade);
}
