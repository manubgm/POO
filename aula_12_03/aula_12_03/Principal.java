package aula_12_03;
import java.util.Scanner;

interface Collection {
    int MAXIMUM = 500;
    void add(int obj);
    int find(int obj);
    int currentCount();

 }
 //lembrando interface é um conjunto de metos sem corpo

class My_Vector implements Collection{
//declaracoes iniciais
    private int[] dados = new int[MAXIMUM];//criando o array
    private int contador =0;

//preciso implementar todos os métodos da interface    
    public void add(int obj){
        if(contador<MAXIMUM){
            dados[contador]= obj;
            contador++;
        }
    }

    public int find(int obj){
        for(int i=0;i<contador;i++){
            if(dados[i]==obj)return i;
        }
        return -1;
    }

    public int currentCount(){
        return contador;
    }
}

class MyLinkedList implements Collection{
    //declaracoes iniciais 
    //dessa vez ao inves de vetor vamos usar uma lista encadeada
    //usarei uma classe para isso
    private class No{
        int valor;
        No proximo;

        No(int valor){
            this.valor = valor;//construtor do nó, garante que assim que criado ele  ja tenha um valor
            this.proximo = null;//construtor do nó, garante que ja rceba o endereço null assim que criado
        }
    }

    private No inicio = null;//primeiro no 
    private int contador=0;


    //implementando os metodos de collection
    public void add(int obj){
       if(contador<MAXIMUM){
        No novoNo = new No(obj);
        if(inicio==null){
            inicio = novoNo;//se ta vazia, NOvoNo é o primeiro
        }else{  
            No atual = inicio;//inicia a busca pelo primeiro no
            while(atual.proximo!=null){//enqunto tiver um proximo
                 atual = atual.proximo;//pula pro proximo
            }
        atual.proximo=novoNo;//o ultimo no aponta para o novo (que acabou de ser inserido)
        }
       contador++;
        } 
    }
    public int find(int obj){
        No atual = inicio;
        int count =0;

        while(atual!=null){
            if(atual.valor==obj)return count;
            atual = atual.proximo;
            count++;
        }
        return -1;
    }
    public int currentCount(){
        return contador;
    }
} 

//executando

public class Principal{
    static Scanner leitor = new Scanner(System.in);//nao vai precisar ficar definindo em todas as subclasses


    public static void  main(String[] args){
        
        System.out.println("1. Testanto My_vector:");
        Collection colecao = new My_Vector();   //declarar a variavel como o nome da interface
        testar(colecao);

        System.out.println("2. Testando MyLinkedList:");
        colecao = new MyLinkedList();
        testar(colecao);

       
    }

    public static int menu(){
        System.out.println("-----Menu----");
        System.out.println("1. Adicionar item");
        System.out.println("2.Total de itens: ");
        System.out.println("3. Pesquisar posição");
        System.out.println("4. Sair");
        /*int opcao;
        Scanner leitor = new Scanner(System.in);
        opcao= leitor.nextInt();
        return opcao;*/

        return leitor.nextInt();

    }

    public static void testar(Collection c){
        
        int op;
        do{
            
         op = menu();
            switch(op){
                case 1:
                    System.out.println(">insira um int na lista");
                    int valor = leitor.nextInt();
                    c.add(valor);
                    System.out.println("adicionado");
                    break;
                case 2:
                    System.out.println("ha " + c.currentCount()+" itens na lista");
                    break;
                case 3:
                    System.out.println(">insira um int para procurar a posicao");
                    
                    int busca= leitor.nextInt();
                    int posicao = c.find(busca);
                    if(posicao!=-1){
                        System.out.println("valor encontrado na posicao "+ posicao+1);
                    }else{
                        System.out.println("valor nao encontrado ");
                    }
                    break;  
                default:
                    System.out.println("opcao invalida");
            }
            System.out.println("encerrando");
    }while(op!=4);
    }

}
