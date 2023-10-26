import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    Scanner sc = new Scanner(System.in);
    private List<Pergunta> perguntasFaceis;
    private List<Pergunta> perguntasMedias;
    private List<Pergunta> perguntasDificeis;
    private List<Jogador> jogadores;

    public QuizApp() {
        perguntasFaceis = new ArrayList<>();
        perguntasMedias = new ArrayList<>();
        perguntasDificeis = new ArrayList<>();
        jogadores = new ArrayList<>();

        perguntasFaceis.add(new Pergunta("O que é o encapsulamento em programação orientada a objetos? Como" +
                " você pode implementá-lo em Java?\na) Encapsulamento é um conceito que não se aplica a Java.\n" +
                "b) Encapsulamento é a capacidade de criar objetos em Java.\n" +
                "c) Encapsulamento é o princípio de esconder os detalhes internos de uma classe e expor apenas o necessário por meio de métodos. (Alternativa correta)\n" +
                "d) Encapsulamento é um termo relacionado à herança em Java.\n" +
                "e) Encapsulamento é uma técnica de otimização de código.", "c", 40));
        perguntasMedias.add(new Pergunta("Explique o conceito de herança em Java. Dê um exemplo de como " +
                "criar uma classe filha que herda de uma classe pai.\na) Herança é a capacidade de criar objetos em Java.\n" +
                "b) Herança é a reutilização de código em Java.\n" +
                "c) Herança é o conceito de uma classe derivada (filha) herdar atributos e métodos de uma classe base (pai).\n" +
                "d) Herança é a capacidade de criar múltiplas instâncias de uma classe.\n" +
                "e) Herança é um método de ordenação de objetos em Java.", "c", 40));
        perguntasMedias.add(new Pergunta("O que são interfaces em Java e como elas diferem das classes " +
                "abstratas? Dê um exemplo de uso de interfaces em Java.\na) Interfaces são usadas para criar objetos em Java e são idênticas a classes abstratas.\n" +
                "b) Interfaces são utilizadas apenas em linguagens de programação diferentes de Java.\n" +
                "c) Interfaces são uma forma de definir métodos que as classes devem implementar, e uma classe pode implementar múltiplas interfaces.\n" +
                "d) Interfaces são usadas apenas para fins de documentação em Java.\n" +
                "e) Interfaces são usadas para criar classes concretas em Java.", "c", 60));
        perguntasDificeis.add(new Pergunta("O que é polimorfismo em Java?\nA) Uma técnica de otimização de código.\n" +
                "B) A capacidade de uma classe ter várias interfaces.\n" +
                "C) A capacidade de uma classe ser final.\n" +
                "D) A capacidade de objetos de diferentes classes serem tratados como objetos de uma classe comum.\n" +
                "E) A habilidade de acessar membros privados de uma classe.", "D", 100));
        perguntasDificeis.add(new Pergunta("I - A operação de casting é usada quando o objetivo é ajustar o retorno de um método com a atribuição a uma variável. Esse tipo de conversão é possível quando os tipos de dados são objetos (por exemplo com o uso de herança) e não em tipos primitivos.\n" +
                "II - O uso de polimorfismo está intimamente relacionado ao mecanismo de upcasting.\n" +
                "III - Uma interface não pode ser instanciada, mas podem ser definidas referências do seu tipo.\n" +
                "IV - Uma interface é formalmente uma classe abstrata, somente com atributos constantes" +
                "(final) e estáticos(static) e métodos sem corpo. Estes deverão ser implementados pelas " +
                "classes que irão implementar a interface.\n" +
                "a) Os itens I e II estão corretos\n" +
                "b) Somente o item I é falso.\n" +
                "c) Os itens III e IV são falsos.\n" +
                "d) Somente o item II é verdadeiro.\n" +
                "e) Os itens I e II são verdadeiros.\n", "a", 100));
    }

    public void adicionarJogador(String nome) {
        Jogador jogador = new Jogador(nome);
        jogadores.add(jogador);
    }

    public void executarQuiz() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < jogadores.size(); i++) {
            Jogador jogador = jogadores.get(i);
            System.out.println("Jogador: " + jogador.getNome());
            int totalPontos = 0;

            totalPontos += realizarPerguntas(perguntasFaceis, "Fácil");
            totalPontos += realizarPerguntas(perguntasMedias, "Média");
            totalPontos += realizarPerguntas(perguntasDificeis, "Difícil");

            jogador.ganharPontos(totalPontos);
            System.out.println("Pontuação total de " + jogador.getNome() + ": " + totalPontos);

            if (i < jogadores.size() - 1) {
                System.out.println("Próximo jogador, prepare-se para jogar. Aperte 'Enter' para continuar.");
                sc.nextLine(); // espera um enter pra continuar
            }
        }

        // ranking
        jogadores.sort((j1, j2) -> Integer.compare(j2.getPontos(), j1.getPontos()));

        System.out.println("\nClassificação final:");
        int posicao = 1;
        for (Jogador jogador : jogadores) {
            System.out.println(posicao + ". " + jogador.getNome() + " - Pontuação: " + jogador.getPontos());
            posicao++;
        }
    }



    private int realizarPerguntas(List<Pergunta> listaPerguntas, String nivel) {
        int pontosNivel = 0;

        for (Pergunta pergunta : listaPerguntas) {
            System.out.println("Nível " + nivel + ":");
            System.out.println(pergunta.getPergunta());

            System.out.print("Resposta: ");
            String resposta = sc.nextLine();

            if (resposta.equalsIgnoreCase(pergunta.getResposta())) {
                System.out.println("Resposta correta! Você ganhou " + pergunta.getPontos() + " pontos.");
                pontosNivel += pergunta.getPontos();
            } else {
                System.out.println("Resposta incorreta.");
                int nivelDeDificuldade = (nivel.equals("Fácil")) ? 1 : (nivel.equals("Média")) ? 2 : 3;


            }
        }

        return pontosNivel;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuizApp quiz = new QuizApp();
        boolean jogarDeNovo = true;

        while(jogarDeNovo){
            System.out.println("Digite o nickname do jogador 1: ");
            quiz.adicionarJogador(sc.nextLine());
            System.out.println("Digite o nickname do jogador 2: ");
            quiz.adicionarJogador(sc.nextLine());
            quiz.executarQuiz();

            try {
                System.out.println("Deseja jogar novamente? (s/n)");
                String opcao = sc.nextLine().toLowerCase();
                jogarDeNovo = opcao.equals("s");
            } catch (Exception e) {
                System.out.println("Erro ao ler a opção de jogar novamente. O jogo será encerrado.");
                break;
            }
            /* Reinicia os jogadores para uma nova partida */
            quiz.jogadores.clear();
        }

    }
}
