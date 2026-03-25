package LISTAS.LISTA4;

import java.util.InputMismatchException;
import java.util.Scanner; 

// declarando a classe descendente de exception
class EquacaoInvalidaException extends Exception {
    public EquacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}

public class SegundoGrau {
    public static void calcularRaizes(double a, double b, double c) throws EquacaoInvalidaException {
        if (a == 0) {
            throw new EquacaoInvalidaException("Coeficiente 'a' não pode ser 0");
        }
        double delta = (b * b) - (4 * a * c);
        if (delta < 0) {
            throw new EquacaoInvalidaException("Delta negativo, não existem raízes reais");
        }
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        System.out.println("Raízes: x1= " + x1 + " | x2= " + x2);
    }

    public static void main(String[] args) {

        try (Scanner leitor = new Scanner(System.in)) {
            System.out.println("Tentando calcular...");

            System.out.println("Insira os coeficientes:");
            double a, b, c;
            a = leitor.nextDouble();
            b = leitor.nextDouble();
            c = leitor.nextDouble();
            
            calcularRaizes(a, b, c);
            System.out.println("Cálculo feito com sucesso");

        } catch (EquacaoInvalidaException e) {
            System.out.println("Erro capturado: " + e.getMessage()); // informa o erro identificado pelo java

        } catch (InputMismatchException e) {
            System.out.println("Erro de digitação: Você digitou uma letra em vez de número");
        }
        
    }
}