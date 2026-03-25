import java.util.Scanner;

//interface
interface FormaGeometrica {
    float PI = 3.14159f; // Constante 

    //"metodos"
    float calcularArea();      // Assinatura (sem corpo) 
    float calcularPerimetro(); // Assinatura 
}

class Circulo implements FormaGeometrica{
    float raio;

    //construtor
    public Circulo(float raio){
        this.raio=raio;
    }

    //override
    public float calcularPerimetro(){
        return 2*PI*this.raio;
    }
    public float calcularArea() { // Sem parâmetros aqui!
    return PI * this.raio * this.raio; // Usa o raio que já está no objeto
}
}

class Retangulo implements FormaGeometrica{
    float base, altura;

    //construtor
    public Retangulo(float base, float altura){
        this.base=base;
        this.altura=altura;
    }

    //metodos override
    public float calcularPerimetro(){
        return 2*this.altura + 2*this.base;
    }
    public float calcularArea(){
        return this.base*this.altura;
    }
}

public class Principal {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        // Criando o vetor de 5 posições
        FormaGeometrica[] formas = new FormaGeometrica[5];
         

        for (int i = 0; i < 5; i++) {
            System.out.println("O que deseja inserir? (1-Circulo, 2-Retangulo)");
            int escolha = leitor.nextInt();//lendo

            if (escolha == 1) {
                System.out.print("Digite o raio: ");
                float r = leitor.nextFloat();//lendo
                formas[i] = new Circulo(r); // Instanciando 
            } else {
                System.out.print("Digite a base e a altura: ");
                float b = leitor.nextFloat();//lendo
                float a = leitor.nextFloat();//lendo
                formas[i] = new Retangulo(b, a);//instanciando
            }
        }

        System.out.println("\n--- RESULTADOS ---");
        for (int i = 0; i < 5; i++) {
            // Aqui acontece o Polimorfismo: o Java sabe qual método chamar
            //pois criei um vetor do tipo FormaGeometrica que possui elementos 
            //instâncias de círculo e retangulo
            System.out.println("Forma " + (i+1) + ":");
            System.out.println("Área: " + formas[i].calcularArea()); 
            System.out.println("Perímetro: " + formas[i].calcularPerimetro());
            //aqui o compilafor só sabe que forma[i] é uma FormaGeometrica
            //mas consegue usas o metodo correspondente para circulo e retangulo corretamente

        }
    }
}