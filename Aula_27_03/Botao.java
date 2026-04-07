package Aula_27_03;
import java.awt.*;

public class Botao extends Frame{
    Teste1 b = new Teste1("Aperte-me");

    Botao(){
        super("Botao");
        add(b);
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        new Botao();
    }
}