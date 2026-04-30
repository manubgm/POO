public class Quadrado {
    private int x, y;
    private int largura, altura;
    
    // Variáveis para a física
    private double velX = 0;
    private double velY = 0;
    private final double gravidade = 0.5;
    private final double forcaPulo = -10.0;
    private final double velocidadeMov = 5.0;
    private boolean noChao = true; // Impede que ele pule no ar

    public Quadrado(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    // Métodos de Movimentação (Comportamentos)
    public void moverEsquerda() {
        velX = -velocidadeMov;
    }

    public void moverDireita() {
        velX = velocidadeMov;
    }

    public void pararX() {
        velX = 0;
    }

    public void pular() {
        if (noChao) {
            velY = forcaPulo;
            noChao = false;
        }
    }

    // Aplica as forças a cada frame do game loop
    public void atualizarFisica() {
        // Movimento horizontal
        x += velX;

        // Movimento vertical (Gravidade)
        velY += gravidade;
        y += velY;

        // Colisão com o chão (Sabemos que o y inicial era 560)
        if (y >= 560) {
            y = 560;
            velY = 0;
            noChao = true;
        }
        
        // (Opcional) Impede o quadrado de sair da tela pelas laterais
        if (x < 0) x = 0;
        if (x > 800 - largura) x = 800 - largura;
    }

    // Getters para o desenho
    public int getX() { return x; }
    public int getY() { return y; }
    public int getLargura() { return largura; }
    public int getAltura() { return altura; }
}