
package br.edu.ifpb.domain;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ListaDeProdutos {
    
    @EJB
    private Produtos produtos;
    
    public List<Produto> listarProdutos(){
        
        return this.produtos.todosOsProdutos();
    
    }
    
}
