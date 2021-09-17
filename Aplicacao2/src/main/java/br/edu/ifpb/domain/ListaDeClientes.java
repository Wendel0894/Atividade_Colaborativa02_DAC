
package br.edu.ifpb.domain;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ListaDeClientes {
    
    @EJB
    private Clientes clientes;
    
    public List<Cliente> listarClientes() {
        
        return this.clientes.todosOsClientes();
        
    }
    
}
