/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pronatec
 */
import com.google.gson.Gson;
import java.util.ArrayList;
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
@Path("meuwebservice")
public class MyApplicationController {

    private PessoaDao pessoaDao;

    public MyApplicationController() {
        pessoaDao = PessoaDao.getInstance();
    }
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */@GET
    @Path("ola")
    @Produces(MediaType.TEXT_PLAIN)
    public String olaMundo() {
        return "Olá mundo!";
    }

    // http://localhost:8084/ExemploCrudREST/meuwebservice/adicionar?nome=Leonardo
    @GET
    @Path("adicionar")
    public Response adicionar(@QueryParam("nome") String nome,
                            @QueryParam("idade") String idade){
        Pessoa pessoa = new Pessoa(nome,Integer.parseInt(idade));
        this.pessoaDao.adicionar(pessoa);     
        return Response.status(Status.OK).build();
    }

    // http://localhost:8084/ExemploCrudREST/meuwebservice/consultar
    @GET
    @Path("consultar")
    @Produces(MediaType.APPLICATION_JSON)
    public String consultar() {
         return new Gson().toJson(pessoaDao.recuperandoPessoas());

    }

    // http://localhost:8084/ExemploCrudREST/meuwebservice/remover?nome=Leonardo
    @DELETE
    @Path("remover")
    public Response remover(@QueryParam("nome") String nome,
                            @QueryParam("idade") int idade) {
        Pessoa pessoa = new Pessoa(nome,idade);
        this.pessoaDao.remover(pessoa);
        return Response.status(Status.OK).build();
    }
    @GET
    @Path("atualizar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@QueryParam("nome") String nome, @QueryParam("novoNome") String novoNome,
                            @QueryParam("nome") int idade, @QueryParam("novaIdade") int novaIdade){
        Pessoa p = new Pessoa(nome, idade);
        Pessoa novaPessoa = new Pessoa(novoNome,novaIdade);
        pessoaDao.getInstance().atualizar(novaPessoa);
        return Response.status(Status.OK).build();
   /* @POST
    @Path("atualizar")
    public Response atualizar(@QueryParam("nome") String nome,
                           @QueryParam("idade") int idade){
        Pessoa game = new Pessoa(nome, idade);
        pessoaDao.getInstance().atualizar(nome, idade);
        return Response.status(Status.OK).build();
    }*/ }}