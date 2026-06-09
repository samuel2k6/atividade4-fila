import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    executarExercicio01();
                    break;
                case 2:
                    executarExercicio02();
                    break;
                case 3:
                    executarExercicio03(scanner);
                    break;
                case 4:
                    executarExercicio04(scanner);
                    break;
                case 5:
                    executarExercicio05(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("=== Exercicios com Fila ===");
        System.out.println("1 - Fila com valores fixos");
        System.out.println("2 - Fila de nomes");
        System.out.println("3 - Remover 10 numeros da fila");
        System.out.println("4 - Fila de atendimento");
        System.out.println("5 - Fila de impressao");
        System.out.println("0 - Sair");
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }

            System.out.println("Entrada invalida. Digite um numero inteiro.");
            scanner.nextLine();
        }
    }

    private static void executarExercicio01() {
        Queue<Integer> fila = criarFilaValoresFixos();
        System.out.println(fila);
        fila.poll();
        System.out.println(fila);
    }

    private static void executarExercicio02() {
        Queue<String> fila = criarFilaNomes();
        System.out.println(fila.peek());
        System.out.println(fila.size());
    }

    private static void executarExercicio03(Scanner scanner) {
        Queue<Integer> fila = new LinkedList<>();

    for (int i = 1; i <= 10; i++) {
        fila.add(i);
    }

    List<Integer> removidos = removerTodosElementos(fila);

    System.out.println("Elementos removidos: " + removidos);
    System.out.println("Fila vazia? " + fila.isEmpty());
    }

    private static void executarExercicio04(Scanner scanner) {
        Queue<String> fila = new LinkedList<>();
    fila.add("Ana");
    fila.add("Carlos");
    fila.add("Pedro");

    List<String> atendidos = atenderClientes(fila);

    System.out.println("Clientes atendidos: " + atendidos);
    System.out.println("Fila vazia? " + fila.isEmpty());
    }

    private static void executarExercicio05(Scanner scanner) {
        Queue<String> fila = new LinkedList<>();

    adicionarDocumento(fila, "relatorio.pdf");
    adicionarDocumento(fila, "boleto.pdf");

    System.out.println("Proximo documento: " + proximoDocumento(fila));
    System.out.println("Imprimindo: " + imprimirDocumento(fila));
    System.out.println("Proximo documento: " + proximoDocumento(fila));
    }

    public static Queue<Integer> criarFilaValoresFixos() {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(10);
        fila.add(20);
        fila.add(30);
        fila.add(40);
        fila.add(50);

        return fila;
    }

    public static Queue<String> criarFilaNomes() {
        Queue<String> fila = new LinkedList<>();
        fila.add("Ana");
        fila.add("Carlos");
        fila.add("Pedro");
        fila.add("Juliana");

        return fila;
    }

    public static List<Integer> removerTodosElementos(Queue<Integer> fila) {
        List<Integer> removidos = new ArrayList<>();

    while (!fila.isEmpty()) {
        removidos.add(fila.poll());
    }

    return removidos;
    }

    public static List<String> atenderClientes(Queue<String> fila) {
        List<String> atendidos = new ArrayList<>();

    while (!fila.isEmpty()) {
        atendidos.add(fila.poll());
    }

    return atendidos;
    }

    public static void adicionarDocumento(Queue<String> fila, String documento) {
        fila.add(documento);
    }

    public static String imprimirDocumento(Queue<String> fila) {
        return fila.poll();
    }

    public static String proximoDocumento(Queue<String> fila) {
        return fila.peek();
    }
}
