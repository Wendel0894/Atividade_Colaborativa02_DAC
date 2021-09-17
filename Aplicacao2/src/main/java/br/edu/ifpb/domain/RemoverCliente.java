
package br.edu.ifpb.domain;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RemoverCliente {
    
    @EJB
    private Clientes clientes;
    
    public void removerCliente(Cliente cliente) {
        
        this.clientes.remover(cliente);
        
    }
    
}
