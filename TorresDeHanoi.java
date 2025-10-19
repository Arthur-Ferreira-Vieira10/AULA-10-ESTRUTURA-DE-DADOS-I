import java.text.DecimalFormat;

public class TorresDeHanoi {

    public static void main(String[] args) {
        int[] instancias = {1, 10, 20, 30, 40, 41};

        for (int n : instancias) {
            executarInstancia(n);
        }
    }

    public static void executarInstancia(int n) {
        System.out.println("\nExecutando instância com " + n + " discos...");

        long inicio = System.currentTimeMillis();

        // Executa com impressão para n pequeno
        if (n <= 10) {
            hanoi(n, 'A', 'C', 'B');
        } else {
            // Executa sem imprimir para n grande
            hanoiSemImprimir(n, 'A', 'C', 'B');
        }

        long fim = System.currentTimeMillis();
        long tempoTotal = fim - inicio;

        // Formata tempo em HH:MM:SS:mmm
        long horas = tempoTotal / 3600000;
        long minutos = (tempoTotal % 3600000) / 60000;
        long segundos = (tempoTotal % 60000) / 1000;
        long milissegundos = tempoTotal % 1000;

        String tempoFormatado = String.format("%02d:%02d:%02d:%03d",
                horas, minutos, segundos, milissegundos);

        // Fórmula do número de movimentos: (2^n) - 1
        double totalMovimentos = Math.pow(2, n) - 1;
        DecimalFormat df = new DecimalFormat("#");

        System.out.println("→ Tempo gasto: " + tempoFormatado);
        System.out.println("→ Total de movimentos: " + df.format(totalMovimentos));

        if (n > 10) {
            System.out.println("Execução completa (movimentos não exibidos por serem muitos).");
        }
    }

    // Função recursiva com impressão (para n pequeno)
    public static void hanoi(int n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origem + " para " + destino);
            return;
        }
        hanoi(n - 1, origem, auxiliar, destino);
        System.out.println("Mover disco " + n + " de " + origem + " para " + destino);
        hanoi(n - 1, auxiliar, destino, origem);
    }

    // Função recursiva sem impressão (para n grande)
    public static void hanoiSemImprimir(int n, char origem, char destino, char auxiliar) {
        if (n == 1) return;
        hanoiSemImprimir(n - 1, origem, auxiliar, destino);
        hanoiSemImprimir(n - 1, auxiliar, destino, origem);
    }
}
