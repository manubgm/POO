package LISTAS.LISTA1;

import java.util.Scanner;

public class vetor {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        System.out.println("digite o tamanho do vetor: ");
        int n = leitor.nextInt();
        int vetor[] = new int[n];
        System.out.println("digite os elementos");

        for(int i =0;i<n;i++){
            vetor[i]=leitor.nextInt();
        }

        for(int i=0; i<n-1;i++){
            for(int j=0; j<n-1-i;j++){
                if(vetor[j]>vetor[j+1]){
                    int temp = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = temp;

                }
            }
        }
        System.out.println("Vetor ordenado:");

        for(int i = 0; i < n; i++){
            System.out.print(vetor[i] + " ");
        }

        leitor.close();
    
    }
}
