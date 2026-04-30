import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Jogo extends JPanel {
    private Quadrado quadrado;
    
    // Array para rastrear quais teclas estão pressionadas
    private boolean[] teclas = new boolean[256];

    public Jogo() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        
        // Quadrado branco de 40x40, posicionado no canto inferior da tela
        quadrado = new Quadrado(380, 560, 40, 40);
        setFocusable(true);

        // Captura os eventos do teclado e atualiza o array 'teclas'
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() < 256) teclas[e.getKeyCode()] = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() < 256) teclas[e.getKeyCode()] = false;
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha o quadrado branco
        g.setColor(Color.WHITE);
        g.fillRect(quadrado.getX(), quadrado.getY(),
                   quadrado.getLargura(), quadrado.getAltura());
    }

    public void game_loop() {
        // 1. Processar a entrada do usuário
        if (teclas[KeyEvent.VK_LEFT]) {
            quadrado.moverEsquerda();
        } else if (teclas[KeyEvent.VK_RIGHT]) {
            quadrado.moverDireita();
        } else {
            quadrado.pararX(); // Se soltou as setas, ele para de andar
        }

        if (teclas[KeyEvent.VK_UP]) {
            quadrado.pular();
        }

        // 2. Atualizar a física (movimento e gravidade)
        quadrado.atualizarFisica();

        // 3. Redesenhar a tela com repaint()
        repaint();

        try {
            Thread.sleep(16); // ~60 FPS
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo do Quadrado");
        Jogo jogo = new Jogo();
        frame.add(jogo);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        // Game loop
        while (true) {
            jogo.game_loop();
        }
    }
}