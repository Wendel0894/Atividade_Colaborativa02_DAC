
package br.edu.ifpb.domain;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AtualizarProduto {
    
    @EJB
    private Produtos produtos;
    
    public void atualizarProduto(Produto produto) {
        this.produtos.atualizar(produto);
    }
    
}
