
package br.edu.ifpb.domain;

import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdicionarProduto {
    
    @EJB
    private Produtos produtos;
    
    public void adicionarProduto(Produto produto) {
        
        Objects.requireNonNull(produto, "O produto não pode ser nulo.");
        
        this.produtos.adicionar(produto);
        
    }
    
}
