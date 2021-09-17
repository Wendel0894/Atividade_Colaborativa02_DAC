
package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.List;


public interface Clientes extends Serializable{
    
    public void adicionar(Cliente cliente);
    
    public void remover(Cliente cliente);
    
    public List<Cliente> todosOsClientes();
    
    public void atualizar(Cliente cliente);
    
}
