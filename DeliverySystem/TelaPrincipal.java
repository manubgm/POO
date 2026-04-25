import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

    // Componentes da tela
    private JLabel labelNome;
    private JTextField campoNome;
    private JButton botaoSalvar;
    private JTextField campoEmail;
    private JLabel labelEmail;

    public TelaPrincipal() {
        super("Sistema de Delivery");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // criando painel
        JPanel painelPrincipal = new JPanel(new FlowLayout());

        // criando os componentes
        labelNome = new JLabel(">Digite seu nome:");
        campoNome = new JTextField(20);
        botaoSalvar = new JButton("Salvar");
        labelEmail = new JLabel(">Digite seu email:");
        campoEmail = new JTextField(30);

        // adicionando eles no painel q eu criei
        painelPrincipal.add(labelNome);
        painelPrincipal.add(campoNome);
        painelPrincipal.add(labelEmail);
        painelPrincipal.add(campoEmail);
        painelPrincipal.add(botaoSalvar);

        // adicionando o painel principal na janela
        getContentPane().add(painelPrincipal);

        //botoes
        botaoSalvar.addActionListener(new ActionListener() { //<-
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoNome = campoNome.getText();
                String textoEmail = campoEmail.getText();
                if (textoNome.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, digite seu nome.");
                } else if (textoEmail.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, digite seu email.");
                } else {
                    JOptionPane.showMessageDialog(null, "Olá, " + textoNome + "! Bem-vindo ao sistema de delivery.");
                    campoNome.setText("");
                    campoEmail.setText("");
                }
            }
        }); // <-

        //deicxa ver
        setVisible(true); 
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}