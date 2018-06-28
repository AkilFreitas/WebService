/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 *
 * @author pronatec
 */
public class PessoaDao {

    private static PessoaDao instance;
    
    private ArrayList<Pessoa> pessoas;

    PessoaDao() {
        this.pessoas = new ArrayList<Pessoa>();
    }
    
    public static PessoaDao getInstance(){
        if(instance == null)
            instance = new PessoaDao();
        
        return instance;
    }

    public void adicionar(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }
    
   /* public boolean atualizar(String nome, int idade){
        this.pessoas.put(nome,idade);
        return true;
    }
    */
    public void substituir(Pessoa pessoa) {
        for (Pessoa c : this.pessoas) {
            if (c.getNome().equals(pessoa.getNome())) {
                c.setNome(pessoa.getNome());
            }
        }
    }

   /* public boolean remover(String nome, int idade) {
      this.pessoas.remove(nome);
         this.pessoas.remove(idade);
        return true;
    }*/
    public boolean remover(String id){
        this.pessoas.remove(id);
        return true;
    }

    /*public boolean atualizar(String id, Pessoa pessoa){
        this.pessoas.put(id,pessoa);
        return true;
    }
    */
    
      public void alterar(Pessoa pessoa) {
        for (Pessoa c : this.pessoas) {
            if (c.getNome().equals(pessoa.getNome())) {
                c.setNome(pessoa.getNome());
            }
        }
    }
    //public void alterar(Pessoa pessoa) {
      //  for (Pessoa c : this.pessoas) {
        //    if (c.getNome().equals(pessoa.getNome())) {
          //      c.setNome(pessoa.getNome());
           // }
        //}
    //}

    public ArrayList<Pessoa> recuperandoPessoas() {
        return this.pessoas;
    }
}