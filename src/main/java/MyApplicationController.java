
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
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
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String olaMundo() {
        return "Vai Ney";
    }

    

}
