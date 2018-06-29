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


@Path("meuwebservice")
public class MyApplicationController {
    
    static PessoaDao pessoaDao;
    
    public MyApplicationController(){
        
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
    //http://localhost:8080/WebService/meuwebservice/remover?nome=junior?idade=15
    @DELETE
    @Path("remover")
    public Response delete(@QueryParam("id") String id){
        PessoaDao.getInstance().remover(id);
        return Response.status(Status.OK).build();
    }
    
 /*    @POST
    @Path("atualizar")
    public Response update(@QueryParam("id") String id,
                           @QueryParam("name") String name, 
                           @QueryParam("price") double price,
                           @QueryParam("description") String description){
        Pessoa pessoas = new Pessoa(name,price,description);
        PessoaDao.getInstance().alterar(id, pessoas);
        return Response.status(Status.OK).build();
    }*/
    
 //http://localhost:8084/ExemploCrudREST/meuwebservice/consultar
    @GET
    @Path("Buscar")
    public String buscar() {
        return this.pessoaDao.recuperandoPessoas().toString();

   }
    


}