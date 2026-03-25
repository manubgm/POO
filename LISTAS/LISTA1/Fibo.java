package LISTAS.LISTA1;

import java.util.Scanner;

public class Fibo {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o valor de n: ");
        int n = leitor.nextInt();

        int f1 = 1;
        int f2 = 1;
        int f = 1;

        if(n == 1 || n == 2){
            f = 1;
        }
        else{
            for(int i = 3; i <= n; i++){
                f = f1 + f2;
                f1 = f2;
                f2 = f;
            }
        }

        System.out.println("O termo " + n + " da sequencia de Fibonacci eh: " + f);

        leitor.close();
    }
}