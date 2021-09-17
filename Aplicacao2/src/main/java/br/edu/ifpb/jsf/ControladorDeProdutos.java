
package br.edu.ifpb.jsf;

import br.edu.ifpb.domain.AdicionarProduto;
import br.edu.ifpb.domain.AtualizarProduto;
import br.edu.ifpb.domain.ListaDeProdutos;
import br.edu.ifpb.domain.Produto;
import br.edu.ifpb.domain.RemoverProduto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ControladorDeProdutos implements Serializable{
    
    private Produto produto = new Produto(0, "", new BigDecimal(0));
    
    @Inject
    private AdicionarProduto addProduto;
    
    @Inject
    private RemoverProduto removeProduto;
    
    @Inject
    private AtualizarProduto updateProduto;
    
    @Inject
    private ListaDeProdutos listProdutos;

    
    public String remover(Produto produto) {
        
        this.removeProduto.removerProduto(produto);
        return "/Produto/list";
        
    }
     
    public String editar(Produto produto) {
        this.produto = produto;
        return "/Produto/edit?faces-redirect=true";
    }
    
    public String adicionar() {
        
        if ( this.produto.getId() > 0 ) { //edita
            
            this.updateProduto.atualizarProduto(this.produto);
            
        } else { //insere
            
            this.addProduto.adicionarProduto(this.produto);
            
        }
        
        
        this.produto = new Produto(0, "", new BigDecimal(0));
        return "/Produto/list?faces-redirect=true";
        
    }
    
    public List<Produto> listar() {
        return this.listProdutos.listarProdutos();
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
    
}
