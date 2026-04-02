import java.util.*;

public class Bee {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        if (!leitor.hasNextInt()) return;

        int n = leitor.nextInt();
        leitor.nextLine(); // Limpa o buffer do Int
        leitor.nextLine(); // Pula a linha em branco inicial

        for (int i = 0; i < n; i++) {
            TreeMap<String, Integer> trees = new TreeMap<>();
            int totalArvores = 0;

            while (leitor.hasNextLine()) {
                String nameTree = leitor.nextLine();

                // Se encontrar linha vazia, acabou este caso de teste
                if (nameTree.isEmpty()) {
                    break;
                }

                trees.put(nameTree, trees.getOrDefault(nameTree, 0) + 1);
                totalArvores++;
            }

            for (Map.Entry<String, Integer> par : trees.entrySet()) {
                String nome = par.getKey();
                int quantidade = par.getValue();
                double porcentagem = (quantidade * 100.0) / totalArvores;

                System.out.printf(Locale.US, "%s %.4f\n", nome, porcentagem);
            }

            // Linha em branco entre os casos (mas não após o último)
            if (i < n - 1) {
                System.out.println();
            }
        }
        leitor.close();
    }
}