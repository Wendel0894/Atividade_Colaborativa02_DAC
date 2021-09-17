
package br.edu.ifpb.jsf;

import br.edu.ifpb.domain.AtualizarCliente;
import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.ListaDeClientes;
import br.edu.ifpb.domain.NovoCliente;
import br.edu.ifpb.domain.RemoverCliente;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class ControladorDeClientes implements Serializable{
    
    private Cliente cliente = new Cliente(0, "", "");
    
    @Inject
    private NovoCliente novoCLiente;
    
    @Inject
    private ListaDeClientes listaDeClientes;

    @Inject
    private AtualizarCliente updateCliente;
    
    @Inject
    private RemoverCliente removeCliente;
    
    public String remover (Cliente cliente) {
        
        this.removeCliente.removerCliente(cliente);
        return "/Cliente/list";
        
    }
    
    public String editar(Cliente cliente) {
        this.cliente = cliente;
        return "/Cliente/edit?faces-redirect=true";
    }
    
    public String adicionar() {
        
        
        if ( this.cliente.getId() > 0 ) { //editar
            System.out.println("Editando");
            this.updateCliente.atualizarCliente(this.cliente);
            
        } else { // inserir
            System.out.println("Inserindo");
            this.novoCLiente.adicionarCliente(this.cliente);
            
        }
        
        this.cliente = new Cliente(0, "", "");
        return "/Cliente/list?faces-redirect=true";
        
    }
    
    public List<Cliente> listar() {
        return this.listaDeClientes.listarClientes();
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
}
