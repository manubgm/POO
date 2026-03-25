package CursosYTB.CursoEmVideo.aula02b;
import java.util.Scanner;

public class Menu {
    private Scanner leitor;
    
    public Menu(){
        this.leitor = new Scanner(System.in);
    }

    public int mostrar(){
        System.out.println(">>>>MENU<<<<");
        System.out.println("1. Cadastrar caneta");
        System.out.println("2. Destampar");
        System.out.println("3. tampar");
        System.out.println("4. rabiscar");
        System.out.println("5. status da caneta");
        System.out.println("6. sair");
        System.out.print("Escolha: ");
        return leitor.nextInt();
    }
}
