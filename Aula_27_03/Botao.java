package Aula_27_03;
import java.awt.*;

public class Botao extends Frame{
    Button b = new Button("Aperte-me");

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