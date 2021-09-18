
package br.edu.ifpb.domain;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class LocalizarProdutos {
    
    @EJB
    private Produtos produtos;
    
    public List<Produto> localizar(String descricao) {
        return this.produtos.localizarProdutosPorDescricao(descricao);
    }
    
 
}
