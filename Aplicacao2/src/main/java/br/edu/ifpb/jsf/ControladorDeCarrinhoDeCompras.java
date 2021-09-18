
package br.edu.ifpb.jsf;

import br.edu.ifpb.domain.Carrinho;
import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Produto;
import br.edu.ifpb.domain.Venda;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ControladorDeCarrinhoDeCompras implements Serializable {
    
    @Inject
    private Carrinho carrinho;
    
    private Venda novaVenda = new Venda(new ArrayList<>());
   
    public String concluirCompra(){
        this.novaVenda = new Venda(new ArrayList<>());
        return "/Carrinho/carrinhoDeCompras?faces-redirect=true";
    }
    
    public String concluir() {
        
        this.carrinho.finalizarCarrinho();
        
        this.novaInstanciaDeCarrinho();
        return "/Venda/venda?faces-redirect=true";
        
    } 
    
    public String adicionar(Produto produto) {
       
        this.carrinho.adicionar(produto);
        this.novaVenda.setProdutosComprados(this.carrinho.listarProdutos());
        this.novaVenda.calculaTotal();
        
        return "/Carrinho/carrinhoDeCompras";
        
    }
    
    public List<Produto> listar() {
        return this.carrinho.listarProdutos();
    }
    
    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    private void novaInstanciaDeCarrinho() {
      
        this.carrinho = CDI.current()
                .select(Carrinho.class)
                .get();
        
    }

    public Venda getNovaVenda() {
        return novaVenda;
    }

    public void setNovaVenda(Venda novaVenda) {
        this.novaVenda = novaVenda;
    }

    
    
}
