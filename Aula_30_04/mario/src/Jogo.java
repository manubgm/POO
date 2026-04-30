import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Jogo extends JPanel {
    private Mario mario;
    private boolean[] teclas = new boolean[256]; // controle de teclas pressionadas

    //construtor
    public Jogo() throws Exception {
        setPreferredSize(new Dimension(800, 600));
        setBackground(new Color(92, 148, 252)); // azul "céu" do Mario

        mario = new Mario(380, 600);

        setFocusable(true);

        //ouvinte de teclado
        addKeyListener(new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode()<256) teclas[e.getKeyCode()]=true;
                }
    
                @Override
                public void keyReleased(KeyEvent e) {
                    if(e.getKeyCode()<256) teclas[e.getKeyCode()]=false;
                } 
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Chão verde
        g.setColor(new Color(0, 168, 0));
        g.fillRect(0, getHeight() - 8, getWidth(), 8);

        // Mario (o método desenhar já está pronto na classe Mario)
        mario.desenhar(g);
    }

    public void game_loop() {
        //verifica os movimentos 
        if(teclas[KeyEvent.VK_LEFT]){
            mario.movLeft();
        }else if(teclas[KeyEvent.VK_RIGHT]){
            mario.movRight();
        }else if(teclas[KeyEvent.VK_SPACE]||teclas[KeyEvent.VK_UP]){
            mario.jump();
        }else{
            mario.stop();
        }

        //atualiza a fisica do pulo
        mario.atualizaFisica();

        //redesenha a tela
        repaint();

        try {
            Thread.sleep(16); // ~60 FPS
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Mario");
        Jogo jogo = new Jogo();
        frame.add(jogo);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (true) {
            jogo.game_loop();
        }
    }
}
