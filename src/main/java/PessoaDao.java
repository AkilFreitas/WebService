/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pronatec
 */
public class PessoaDao {

    private static PessoaDao instance;
    
    private final List<Pessoa> pessoas = new ArrayList<>();

    public PessoaDao() {
    }
    
    public static PessoaDao getInstance(){
        if(instance == null){
            instance = new PessoaDao();
        }
        return instance;
    }

    public void adicionar(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }
    
     public boolean atualizar(Pessoa pessoa){
        for(int i=0;i<this.pessoas.size();i++){
            if(this.pessoas.get(i).nome==pessoa.nome)
                this.pessoas.set(i,pessoa);
             if(this.pessoas.get(i).idade==pessoa.idade)
                this.pessoas.set(i,pessoa);
                return true;
        }
        
        return false;
    }
   /*public boolean atualizar(String nome,int idade){
        this.pessoas.put(nome,idade);
        return true;
    }*/
     public String consutar(String nome){
         String a = "";
        for(Pessoa pessoa : this.pessoas){
           a = "Nome: "+ pessoa.nome + " / Idade: " +  pessoa.idade;
        }
        return a;
     }
    public boolean remover(Pessoa pessoa){
        this.pessoas.remove(pessoa);
        return true;
    }
    
    public List<Pessoa> recuperandoPessoas() {
        return this.pessoas;
    }
}