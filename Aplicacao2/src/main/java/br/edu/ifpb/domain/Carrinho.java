
package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.List;

public interface Carrinho extends Serializable {
    
    public void adicionar(Produto produto);
    
    public List<Produto> listarProdutos();
    
    public void finalizarCarrinho();
    
}
