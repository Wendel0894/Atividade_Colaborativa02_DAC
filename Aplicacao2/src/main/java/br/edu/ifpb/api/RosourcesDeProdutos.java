
package br.edu.ifpb.api;

import br.edu.ifpb.domain.ListaDeProdutos;
import br.edu.ifpb.domain.LocalizarProdutos;
import br.edu.ifpb.domain.Produto;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("produtos") // locahost:8080/atividade2/api/produtos
@Produces(MediaType.APPLICATION_JSON)
public class RosourcesDeProdutos {
    
    @Inject
    private ListaDeProdutos produtos;
    
    @Inject
    private LocalizarProdutos searchProdutos;
    
    @GET
    public List<Produto> listar () { //Lista de produtos
        return this.produtos.listarProdutos();
    }
    
    @GET
    @Path("{descricao}")
    public Response localizarProdutosPorDescricao(@PathParam("descricao") String descricao) {
        
        List<Produto> produtos = this.searchProdutos.localizar(descricao);
        
        return Response.ok()
                .entity(produtos)
                .build();
        
    }
    
    
    
}
