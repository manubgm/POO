package LISTAS.Lista_Collections;
import java.util.*;

public class Ex1 {
    public static void main(String[] args){
        int n;
        Scanner leitor = new Scanner(System.in);
        System.out.println(">quantos alunos voce quer ccadastrar?");
        n=leitor.nextInt();
        leitor.nextLine();


        Vector<String> alunos = new Vector<String>();//cria o vector de strings
        for(int i=0;i<n;i++){
            System.out.println(">insira o nome do aluno #"+(i+1));
            String nome = leitor.nextLine();
            alunos.add(nome);
        }

        Collections.sort(alunos);//ja ordena 
        System.out.println("nomes inseridos em ordem alfabetica:");
        for(String aluno : alunos){
            System.out.println(">aluno: " + aluno);
        }

        leitor.close();
    }
}
