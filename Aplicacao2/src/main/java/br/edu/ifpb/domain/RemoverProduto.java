
package br.edu.ifpb.domain;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RemoverProduto {
    
    @EJB
    private Produtos produtos;
    
    public void removerProduto(Produto produto) {
        
        this.produtos.remover(produto);
        
    }
    
}
