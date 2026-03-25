package CursosYTB.CursoEmVideo.aula02b;

public class Caneta {
    String modelo;
    String cor;
    float ponta;
    int carga;
    boolean tatampada;

    void status(){
        System.out.println("Caneta");
        System.out.println("Modelo: "+ this.modelo);
        System.out.println("Cor " + this.cor);
        System.out.println("Ponta: "+ this.ponta);
        System.out.println("Nivel: "+ this.carga);
        System.out.println("Está tampada? "+ this.tatampada);
    }

    void rabiscar(boolean tatampada){
        if(!tatampada){
            System.out.println("rabiscando");
        }else{
            System.out.println("epa ta tampada");
            destampar();
            System.out.println("destampei pae");
            System.out.println("rabiscando");
        }
    }

    void tampar(){
        this.tatampada=true;
    }
    
    void destampar(){
        this.tatampada = false;
    }
}
