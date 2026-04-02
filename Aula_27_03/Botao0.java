import javax.swing.*;

public class Botao0 {
    public static void main(String[] args) {
        
        // 1. CRIANDO O PALCO (Janela)
        JFrame janela = new JFrame("Meu Primeiro Botão Flutuante");
        janela.setSize(500, 500); // Largura 500, Altura 500
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Faz o "X" fechar o programa de verdade
        
        // 2. DEMITINDO O ORGANIZADOR
        janela.setLayout(null); 
        
        // 3. CRIANDO O ATOR (Botão)
        JButton botao = new JButton("Ok");
        botao.setSize(80, 30); // Largura 80, Altura 30
        
        // Coordenadas iniciais do botão
        int x = 50;
        int y = 50;
        botao.setLocation(x, y); 
        
        // 4. COLOCANDO O ATOR NO PALCO E ABRINDO AS CORTINAS
        janela.add(botao);
        janela.setVisible(true); // Mostra a janela na tela
        
        // --- AQUI COMEÇA A LÓGICA DA ANIMAÇÃO ---
        
        // Variáveis que controlam a "velocidade" e direção (ex: anda de 2 em 2 pixels)
        int movimentoX = 2; 
        int movimentoY = 2;
        
        while (true) {
            
            // Aqui dentro você vai:
            // 1. Somar o movimentoX no 'x' e o movimentoY no 'y'
            // 2. Usar botao.setLocation(x, y) para atualizar a posição
            // 3. Fazer os IFs para bater e voltar nas paredes (getWidth e getHeight)
            
            
            // O comando de pausa obrigatório para a animação funcionar (e não teleportar)
            try {
                Thread.sleep(10); // Pausa de 10 milissegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}