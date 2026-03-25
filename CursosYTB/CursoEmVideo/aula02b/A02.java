package CursosYTB.CursoEmVideo.aula02b;

public class A02 {
    public static void main(String[] args){
        
        c1.cor = "Azul";
        c1.ponta = 0.7f;
        c1.carga = 75;
        c1.tatampada = false;
        c1.status();
        c1.rabiscar();

        Menu menu = new Menu();
        do { 
            int op;
            op = menu.mostrar();
            switch(op){
                case 1:
                    Caneta c1 = new Caneta();
                case 2:

                case 3:
                case 4:
                case 5:
                    c1.status();
                default:
                    System.out.println("opcao invalida");
                    break;
            }
            
        } while (menu.mostrar()!=6);
    }
}


