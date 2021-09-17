
package br.edu.ifpb.domain;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AtualizarCliente {
    
    @EJB
    private Clientes clientes;
    
    public void atualizarCliente(Cliente cliente) {
        
        this.clientes.atualizar(cliente);
        
    }
    
}
