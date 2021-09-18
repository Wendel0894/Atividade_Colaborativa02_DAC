
package br.edu.ifpb.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    
    private BigDecimal valorTotal = new BigDecimal(0);
    private List<Produto> produtosComprados = new ArrayList<>();

    public Venda(List<Produto> produtosComprados) {
    
        this.produtosComprados = produtosComprados;
        
    }
    

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto> getProdutosComprados() {
        return produtosComprados;
    }

    public void setProdutosComprados(List<Produto> produtosComprados) {
        this.produtosComprados = produtosComprados;
    }
    
    public void calculaTotal () {
        
        int total = 0 ;
        
         total = this.produtosComprados
                .stream()
                .map(
                    produto -> produto
                       .getValor()
                       .intValueExact())
                       .reduce(total, Integer::sum
                );
        
        this.setValorTotal(new BigDecimal(total));
        
    }

  
}
