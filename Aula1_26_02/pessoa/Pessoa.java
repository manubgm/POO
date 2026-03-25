class Pessoa {

    String nome;
    String endereco;
    String telefone;

    String pega_tel(){
        return telefone;
    }

    String pega_nome(){
        return nome;
    }

    String pega_end(){
        return endereco;
    }

    void alteraNome(String novoNome) {
        nome = novoNome;
    }

    void alteraEndereco(String novoEndereco) {
        endereco = novoEndereco;
    }

    void alteraTelefone(String novoTelefone) {
        telefone = novoTelefone;
    }


//função principal
public static void main(String[] args){
    Pessoa novo = new Pessoa();
    //intanciou

    //aleterando
    novo.alteraNome("manu");
    novo.alteraEndereco("rua das flores");
    novo.alteraTelefone("98435809348509");

    //imprime
    System.out.println("Nome: "+ novo.pega_nome());
    System.out.println("endereci: "+ novo.pega_end());
    System.out.println("numero: "+ novo.pega_tel());

}

}
