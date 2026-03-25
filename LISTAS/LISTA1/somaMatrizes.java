package LISTAS.LISTA1;

import java.util.Scanner;

public class somaMatrizes { //classe principal

    public static void main(String[] args){//metodo principal

        //leitura
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o numero de linhas: ");
        int l = leitor.nextInt();
        System.out.println("Digite o numero de colunas: ");
        int c = leitor.nextInt();

        int A[][] = new int[l][c];
        int B[][] = new int[l][c];
        int C[][] = new int[l][c];

        //leitura
        System.out.println("digite os elementos da matriz a:");
        for(int i = 0; i < l; i++){
            for(int j = 0; j < c; j++){
                A[i][j] = leitor.nextInt();
            }
        }
        
        System.out.println("digite os elementos da matriz B:");
        for(int i = 0; i < l; i++){
            for(int j = 0; j < c; j++){
                B[i][j] = leitor.nextInt();
            }
        }

        //soma
        for(int i=0;i<l;i++){
            for(int j=0;j<c;j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        System.out.println("a matriz final eh: ");
        for(int i=0;i<l;i++){
            for(int j=0;j<c;j++){
               System.out.println(C[i][j]+ " ");
            }
        }
        leitor.close();
    }
    
}
