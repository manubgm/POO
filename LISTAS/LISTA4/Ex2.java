package LISTAS.LISTA4;

import java.util.Scanner;
import java.util.InputMismatchException;

//nao preciso criar minha exception pq vou usar 2 que ja existem

public class Ex2 {
    public static void main(String[] args){
        Scanner leitor=new Scanner(System.in);
        //cria o vetor de acordo com o enunciado
        int[] vetor = new int[10];
        int i=0;
        System.out.println("insira os valores (0 para parar)");

        try{
                int num=1;
            while(num!=0&&i<10){
                num = leitor.nextInt();
                vetor[i]=num;
                i++;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("erro: voce passou do limite de 10 itens");
        }catch(InputMismatchException e){
            System.out.println("erro: voce digitou algo que nao era um int");
        }
        
        System.out.println("\n--- Valores guardados no vetor ---");
        for(int j = 0; j < i; j++){ 
            System.out.println("Posição [" + j + "]: " + vetor[j]);
        leitor.close();
        }   
    }
}
