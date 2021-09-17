
package br.edu.ifpb.domain;

import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class NovoCliente {
    
    @EJB
    private Clientes clientes;
    
    public void adicionarCliente(Cliente cliente) {
        
        Objects.requireNonNull(cliente, "O cliente não pode ser nulo.");
        
        this.clientes.adicionar(cliente);
        
    }
    
    
    
}
