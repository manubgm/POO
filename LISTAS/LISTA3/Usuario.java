//varias classes para facilitar
//a main estara na SystemDelivery
package LISTAS.LISTA3;
import java.util.ArrayList;
import java.util.Scanner;

enum StatusPedido{
    REALIZADO, EM_PREPARO, EM_ENTREGA, ENTREGUE
}

public abstract class Usuario {
    protected String nome;
    protected int id;
    protected String email;

    public Usuario(String nome, int id, String email){
        this.nome = nome;
        this.id = id;
        this.email=email;
    }

    //metodos para as filhas
    public void viewPerfil(){
        System.out.println("ID: "+ id +"|Nome: "+ nome +"|Email: "+ email);
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }
    
}

class Customer extends Usuario{

    public Customer(String nome, int id, String email){
        super(nome,id,email);
    }

    @Override
    public void viewPerfil(){
        System.out.println(">CLIENTE<");
        super.viewPerfil();
    }


}

class Pizzamen extends Usuario{
    private String meioTransporte;
    private boolean statusDisponivel;

    public Pizzamen(String nome, int id, String email, String meioTransporte) {
        super(nome, id, email);
        this.meioTransporte = meioTransporte;
        this.statusDisponivel = true; 
    }

    public void setDisponivel(boolean status){
        this.statusDisponivel = status;
    }

    @Override
    public void viewPerfil(){
        System.out.println(">PERFIL DE ENTREGADOR<");
        super.viewPerfil();
        System.out.println(">Transporte: "+meioTransporte + "|Disponível: "+ statusDisponivel);
    }
}

class Restaurant extends Usuario{
    private String nomeFantasia;
    private ArrayList<String> cardapio = new ArrayList<>();

    public Restaurant(String nome, int id, String email,String nomeFantasia){
        super(nome,id,email);
        this.nomeFantasia= nomeFantasia;
    }
    
    @Override
    public void viewPerfil(){
        System.out.println(">PERFIL DE RESTAURANTE<");
        super.viewPerfil();
        System.out.println("Nome Fantasia: "+ nomeFantasia);    }
}

class Order{
    private Customer cliente;
    private Pizzamen entregador;
    private Restaurant restaurante;
    private StatusPedido status;
    private ArrayList<String> itens = new ArrayList<>();
    private double valorTotal;

    //construtor
    public Order(Customer cliente, Restaurant restaurante, String item, double valor){
        this.cliente=cliente;
        this.restaurante=restaurante;
        this.itens.add(item);
        this.valorTotal=valor;
        this.status = StatusPedido.REALIZADO;
    }

    public void atualizarStatus(StatusPedido novoStatus){
        this.status = novoStatus;
    }
    public void atribuirEntrega(Pizzamen entregador){
        this.entregador= entregador;
        this.atualizarStatus(StatusPedido.EM_ENTREGA);
        entregador.setDisponivel(false);
    }
    void resumoPedido(){
        System.out.println("\n=== RESUMO DO PEDIDO ===");
        System.out.println("Status: " + status);
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("Restaurante: " + restaurante.nome);
        if (entregador != null) {
            System.out.println("Entregador: " + entregador.nome);
        }
        System.out.println("Itens: " + itens);
        System.out.println("Total: R$ " + valorTotal);
    }
}


//classe que tem a main
class SystemDelivery{
    private ArrayList<Customer> clientes = new ArrayList<>();
    private ArrayList<Pizzamen> entregadores = new ArrayList<>();
    private ArrayList<Restaurant> restaurantes = new ArrayList<>();
    private ArrayList<Order> pedidos = new ArrayList<>();

    void cadastrarCliente(Scanner leitor){
        System.out.println("Nome: ");
        String nome = leitor.nextLine();
        System.out.println("ID: ");
        int id = leitor.nextInt();
        leitor.nextLine();//limpa o buffer
        System.out.println("Email: ");
        String email = leitor.nextLine();

        clientes.add(new Customer(nome,id,email));
        System.out.println(">cadastro feito com sucesso!");
    }
    void cadastrarEntregador(Scanner leitor){
        System.out.print("Nome: ");
        String nome = leitor.nextLine();
        System.out.print("ID: ");
        int id = leitor.nextInt();
        leitor.nextLine();
        System.out.print("Email: ");
        String email = leitor.nextLine();
        System.out.print("Veículo : ");
        String veiculo = leitor.nextLine();

        entregadores.add(new Pizzamen(nome, id, email, veiculo));
        System.out.println("Entregador cadastrado!");
    }
    void cadastrarRestaurante(Scanner leitor){
        System.out.println("Nome: ");
        String nome = leitor.nextLine();
        System.out.println("ID: ");
        int id = leitor.nextInt();
        leitor.nextLine();
        System.out.print("Email: ");
        String email = leitor.nextLine();
        System.out.print("Nome Fantasia: ");
        String fantasia = leitor.nextLine();

        restaurantes.add(new Restaurant(nome, id, email, fantasia));
        System.out.println("Restaurante cadastrado!");
    } 

    void listarUsuarios(){
        for(Customer c : clientes) c.viewPerfil();
        for(Restaurant r : restaurantes) r.viewPerfil();
        for(Pizzamen p: entregadores) p.viewPerfil();

    }

    void fazerPedido(Scanner leitor){
        if(clientes.isEmpty()|| restaurantes.isEmpty()){
            System.out.println(">cadastre pelo menos um cliente e um restaurante eum entregador");
        }

        System.out.print("Nome do Cliente: ");
        String nomeCliente = leitor.nextLine();
        System.out.print("Nome do Restaurante: ");
        String nomeRestaurante = leitor.nextLine();
        leitor.nextLine(); // Limpa o buffer

        //busca
        Customer cliEncontrado = null;
        for(Customer c : clientes){
            if(c.getNome()==nomeCliente)cliEncontrado = c;
        }
        Restaurant restEncontrado = null;
        for (Restaurant r : restaurantes) {
            if (r.getNome() == nomeRestaurante) restEncontrado = r;
        }

        if(cliEncontrado !=null && restEncontrado!=null){
            System.out.print("O que deseja pedir? ");
            String item = leitor.nextLine();
            System.out.print("Qual o valor? R$ ");
            double valor = leitor.nextDouble();

            Order novoPedido = new Order(cliEncontrado,restEncontrado,item,valor);
            pedidos.add(novoPedido);
            novoPedido.resumoPedido();
        }else{
            System.out.println("Cliente ou restaurante não encontrado");
        }
    }

    //main
    public static void main(String[] args){
        SystemDelivery sistema = new SystemDelivery();//criando o objeto principal
        Menu menu = new Menu(sistema);//instanciando o menu
        menu.iniciar();//start 
    }
}

class Menu{
    private Scanner leitor = new Scanner(System.in);
    private SystemDelivery sistema;

    //construtor
    public Menu(SystemDelivery sistema){
        this.sistema=sistema;
    }

    public void iniciar(){
        int op;
        do{
            System.out.println("\n====== SISTEMA DELIVERY ======");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar restaurante");
            System.out.println("3. Cadastrar entregador");
            System.out.println("4. Criar novo pedido");
            System.out.println("5. Listar usuários");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            op= leitor.nextInt();
            leitor.nextLine();//limpa o buffer

            switch (op){
                case 1:
                    System.out.println(">opcao 1 selecionada");
                    sistema.cadastrarCliente(leitor);
                    break;
                case 2:
                    System.out.println(">opcao 2 selecionada");
                    sistema.cadastrarRestaurante(leitor);
                    break;
                case 3:
                    System.out.println(">opcao 3 selecionada");
                    sistema.cadastrarEntregador(leitor);
                    break;
                case 4:
                    System.out.println(">opcao 4 selecionada");
                    sistema.fazerPedido(leitor);
                    break;
                case 5:
                    System.out.println(">opcao 5 selecionada");
                    sistema.listarUsuarios();
                    break;
                case 6:
                    System.out.println(">opcao 6 selecionada");
                    System.out.println("encerrando o sistema...");
                    break;
                default:
                    System.out.println("opcao invalida");
            }

        }while(op!=6);
    }
}