package LISTAS.Lista_Collections;
import java.util.*;
/*usando TreeSet
o TreeSet ignora dados iguais
ex: se eu digito Ana duas vezes ele vai ignorar a segunda Ana */

public class Ex2 {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        System.out.println("quantos alunos voce quer inserir?");
        int n=leitor.nextInt();
        leitor.nextLine();//limpa

        //declara e cria TreeSet
        Set<String> alunos = new TreeSet<String>();
            for(int i=0;i<n;i++){
                System.out.println(">insira o nome do aluno #"+(i+1));
                String nome = leitor.nextLine();
                alunos.add(nome);
        }
//nao precisa d enenhum comando .sort
System.out.println("imprimindo ordenado com TreeSet");
        for(String aluno : alunos){
            System.out.println("> "+aluno);
        }

        leitor.close();
    }    
}
