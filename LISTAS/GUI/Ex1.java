package LISTAS.GUI;
import java.awt.*;
import javax.swing.*;

public class Ex1 {

    public static void main(String[] args){
        //configurando a janela 
        JFrame janela = new JFrame("Editor de Texto");
        janela.setSize(600,400); 
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //crio os botoes
        JButton one = new JButton("Abrir");
        JButton two = new JButton("Salvar");
        JButton three = new JButton("Salvar Como");
        JButton four = new JButton("Fechar");

        //painel pros botoes
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(4,1));//4 linhas 1 coluna

        //agora conseguimos add os botoes corretamente no PAINEL
        painelBotoes.add(one);
        painelBotoes.add(two);
        painelBotoes.add(three);
        painelBotoes.add(four);
        
        
        janela.add(painelBotoes, BorderLayout.WEST);//gruda esse painel no west da janela

        //cria a area do texto
        JTextArea areaTexto = new JTextArea("Digite texto nessa area....");
        janela.add(areaTexto, BorderLayout.CENTER);//coloca no centro da janela

        janela.setVisible(true);
    }
    
}
