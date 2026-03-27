package LISTAS.beecrowd;
import java.util.*;

public class Ordenacao {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        int n = leitor.nextInt();
        leitor.nextLine();//limpa o buffer
        //loop principal
        for(int i =0;i<n;i++){
            String linha = leitor.nextLine();
            //criei um vetor
            String[] vetorPalavras = linha.split(" "); //nova string sem os espaços
            
            //converte o vetor em uma list string
            List<String> lista = new ArrayList<>(Arrays.asList(vetorPalavras));
           
           //sort deixa em ordem alfabetica mas nao é o que queremos
           //o comparator é a regra que eu quero usar

            Collections.sort(lista, new Comparator<String>(){
               @Override
                //mini metodo de uma "mini classe"
                public int compare(String p1,String p2){
                    return p2.length() - p1.length();
                }
            });//atencao nesse parentese

           for (String p : lista) {
                System.out.print(p + " "); 
            }
            System.out.println();
        }
    }
}
