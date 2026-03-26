package LISTAS.beecrowd;
import java.util.Scanner;
import java.util.Stack;

public class Diamantes {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        int n = leitor.nextInt();
        leitor.nextLine();//buffer limpado

        for(int i=0;i<n;i++){
            String linha = leitor.nextLine();
            int diamante=0;

            Stack<Character> pilha = new Stack<Character>();//cria coleçao

            //percorrendo cada linha
            for(int j=0;j<linha.length();j++){
                char carac = linha.charAt(j);
                if(carac=='<'){
                    pilha.push(carac);
                }else if(carac == '>'){
                    if(!pilha.isEmpty()){
                        pilha.pop();
                        diamante++;
                    }
                }
            }
            System.out.println(diamante);
        }

    }
}
