import javax.swing.*;

public class Teste1 {

    public static void main(String args[]) {
        JFrame jframe=new JFrame();    
        JButton bt = new JButton("Ok");
        jframe.setSize(350, 300);
        jframe.setLayout(null);
        jframe.add(bt);
        bt.setSize(50, 20);



        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);

        }
      }
