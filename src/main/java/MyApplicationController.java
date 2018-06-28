
//import com.google.gson.Gson;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status; 
/**
 * Root resource (exposed at "myresource" path)
 */
/*
Pronto, como eu tinha dito, esse path aqui (que vem
depois do caminho da aplicação (vide @ApplicationPath)
é o caminho que eu dou pra chegar nessa classe, que,
como instruído abaixo, produz um texto ("Olá Mundo").
Você acessa essa resposta, no meu caso, pelo endereço:
http://localhost:8084/webService/meuwebservice
Ou seja, http://localhost:8084/webService é o projeto,
o "/" (webService"/"meuwebservice) o caminho da aplicação
que definimos lá no @ApplicationPath, e o "meuwebservice"
é o retorno do método olaMundo(), que é executado pois
definimos o caminho "meuwebservice" para esta classe
abaixo.
*/
@Path("meuwebservice")
public class MyApplicationController {
    
    PessoaDao pessoaDao;
    
    public MyApplicationController(){
        pessoaDao = new PessoaDao();
    }
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
    //http://localhost:8080/WebService/meuwebservice/ola
       @GET
    @Path("ola")
    @Produces(MediaType.TEXT_PLAIN)
    public String olaMundo() {
        return "Olá mundo!";
    }
    
   //http://localhost:8080/WebService/meuwebservice/adicionar?nome=junior?idade=15
    @GET
    @Path("adicionar")
    public Response adicionar(@QueryParam("nome") String nome, 
                              @QueryParam("idade") int idade){
        Pessoa pessoa = new Pessoa(nome);
        this.pessoaDao.adicionar(pessoa);
        return Response.status(Status.OK).build();
        
    }
    @DELETE
    @Path("delete")
    public Response delete(@QueryParam("nome") String nome){
          Pessoa pessoa = new Pessoa(nome);
        pessoaDao.getInstance().remover(pessoa);
        return Response.status(Status.OK).build();
    }
    
// http://localhost:8084/ExemploCrudREST/meuwebservice/consultar
    @GET
    @Path("Buscar")
    public String buscar() {
        return this.pessoaDao.recuperandoPessoas().toString();

    }
    

}