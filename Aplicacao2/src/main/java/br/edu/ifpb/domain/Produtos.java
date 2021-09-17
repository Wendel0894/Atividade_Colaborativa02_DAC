
package br.edu.ifpb.domain;

import java.util.List;

public interface Produtos {
    
    public void adicionar(Produto produto);
    
    public void atualizar(Produto produto);
    
    public void remover(Produto produto);
    
    public List<Produto> todosOsProdutos();
    
}
