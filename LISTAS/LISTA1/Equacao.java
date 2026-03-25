import java.util.Scanner;

public class Equacao {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in); // instanciei o objeto de leitura

        System.out.println("digite o valor  de a: ");
        double a = leitor.nextDouble();
        System.out.println("digite o valor  de b: ");
        double b = leitor.nextDouble();
        System.out.println("digite o valor  de c: ");
        double c = leitor.nextDouble();

        // delta
        double delta = b*b - 4*a*c;

        if(delta > 0){
            // Usamos Math.sqrt() para extrair a raiz quadrada
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("x1 = " + x1 + " e x2 = " + x2);
        }
        
        if(delta == 0){
            double x = -b / (2 * a);
            System.out.println("x1 = x2 = " + x);
        }
        
        if(delta < 0){
            System.out.println("A equacao nao possui raizes reais.");
        }

        leitor.close(); 
    }
}
