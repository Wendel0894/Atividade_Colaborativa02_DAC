
package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Carrinho;
import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class CarrinhoDeCompras implements Carrinho{

    private List<Produto> produtos = new ArrayList<>();
    
    @Override
    public void adicionar(Produto produto) {
         
        this.produtos.add(produto);
        
    }

    @Override
    public List<Produto> listarProdutos() {
        
        return Collections.unmodifiableList(
                this.produtos
        );
        
    }

    @Remove
    @Override
    public void finalizarCarrinho() { 
        
        System.out.println("Produtos");
        
        for ( Produto produto : this.produtos ) {
                System.out.println("======Produto======");
                System.out.println("Id: " + produto.getId());
                System.out.println("Descrição: " + produto.getDescricao());
                System.out.println("Valor: " + produto.getValor());
                System.out.println("====================");
        }
        
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    
    
    
    
}
