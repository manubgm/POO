package CursosYTB.CursoEmVideo.aula02a;

class Objeto {
    float altura;
    float largura;
    String funcao;
    String nome;

    void existe(){
        System.out.println("esse objeto existe");
    }

}


class Cadeira extends Objeto{
    String cor;
    String tipo;

    void sentar(){
        System.out.println("esse objeto é para sentar");
    }
}

class Linahu extends Objeto{
    int abcde;

    void edcba(){
        System.out.println("esse objeto nao serve pra nada");
    }
}

public class Main{
    public static void main(String[] args){
        Cadeira gamer = new Cadeira();
        Linahu jure = new Linahu();

        gamer.nome = "cadeira da manu";
        System.out.println(gamer.nome);
        gamer.cor="azul";
        System.out.println(gamer.cor);

        jure.nome = "nome de nada";
        jure.abcde = 10;
        System.out.println(jure.nome);
        System.out.println(jure.abcde);
    }
}