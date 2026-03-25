package LISTAS.LISTA1;

public class Aluno {

    private String nome;
    private String rg;
    private String telefone;
    private String ra;
    private double cr;

    public Aluno(String nome, String rg, String telefone, String ra, double cr){
        this.nome = nome;
        this.rg = rg;
        this.telefone = telefone;
        this.ra = ra;
        this.cr = cr;
    }

    public String getNome(){
        return nome;
    }

    public String getRa(){
        return ra;
    }

    public double getCr(){
        return cr;
    }

    public void imprimir(){

        System.out.println("Nome: " + nome);
        System.out.println("RA: " + ra);
        System.out.println("RG: " + rg);
        System.out.println("Telefone: " + telefone);
        System.out.println("CR: " + cr);

    }
}