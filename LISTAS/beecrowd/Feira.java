package LISTAS.beecrowd;
import java.util.*;

public class Feira {
    public static void main(String[]args){
        Scanner leitor = new Scanner(System.in);

        int n = leitor.nextInt();
        for(int i=0;i<n;i++){
            int m= leitor.nextInt();
            String nome;
            int preco;
            List<int> listaPreco = new ArrayList<>(Arrays.asList(preco));
            List<String> listaProd = new ArrayList<>(Arrays.asList(nome));
            for(int j=0;j<m;j++){
                nome = leitor.nextLine();
                listaProd.add(nome);
            }
        }
    }    
}
