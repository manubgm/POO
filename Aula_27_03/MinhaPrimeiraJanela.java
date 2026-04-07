package Aula_27_03;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MinhaPrimeiraJanela {
    public static void main(String[] args){
        JFrame janela = new JFrame("Minha primeria tela");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton botao = new JButton("Clique aqui");
        janela.getContentPane().add(botao);

        janela.setSize(300,200);
        janela.setVisible(true);
    }
}
