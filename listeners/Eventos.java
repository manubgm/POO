import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Eventos extends JFrame implements ActionListener {
    
    public Eventos(){
        super("Eventos");

        JButton botao = new JButton("clique aqui");
        getContentPane().add(botao);
        botao.addActionListener(this);

        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new Eventos();
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        System.out.println("clicou!");
    }
}