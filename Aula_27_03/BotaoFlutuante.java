import javax.swing.*;

public class BotaoFlutuante {

    static final int SUBINDO = 1;
    static final int DESCENDO = 0;
    static final int DIREITA = 1;
    static final int ESQUERDA = 0;

    public static void main(String args[]) {
        JFrame jframe=new JFrame();    
        JButton bt = new JButton("Ok");
        jframe.setSize(350, 300);
        jframe.setLayout(null);
        jframe.add(bt);
        bt.setSize(50, 20);

        int x = 0, y = 0;
        int sentido_horizontal = DIREITA;
        int sentido_vertical = DESCENDO;

        bt.setLocation(x, y);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);

        while(true){
            try
            {
                Thread.sleep(5);
            }
            catch (Exception ex)
            {
                System.out.println("Erro!");
            }

            if (sentido_horizontal == DIREITA)
            {
                x++;
                if (x + 50 >= jframe.getContentPane().getWidth())
                    sentido_horizontal = ESQUERDA;
            }
            else
            {
                x--;
                if (x <= 0)
                    sentido_horizontal = DIREITA;
            }
             
            if (sentido_vertical == DESCENDO)
            {
                y++;
                if (y + 20 >= jframe.getContentPane().getHeight())
                    sentido_vertical = SUBINDO;
            }
            else
            {
                y--;
                if (y <= 0)
                    sentido_vertical = DESCENDO;
            }
            
            bt.setLocation(x, y);
        }
      }
}