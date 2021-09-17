
package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Clientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;


@Stateless
public class ClientesEmJDBC implements Clientes {

    
    private Connection connection;
        
    
    public ClientesEmJDBC() throws SQLException {
        
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                "jdbc:postgresql://host-banco:5432/atividade2",
                "wendel","123"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
   
    
    @Override
    public void adicionar(Cliente cliente) {
        
        try {
            
            PreparedStatement statement = connection
                    .prepareStatement(
                            "INSERT INTO Cliente (Nome, Cpf) VALUES (?, ?)"
            );
            
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.executeUpdate();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void remover(Cliente cliente) {
        
        try {
            
            System.out.println("ID do cliente a ser removido: " + cliente.getId());
            
            PreparedStatement statement = connection
                    .prepareStatement(
                            "DELETE FROM Cliente WHERE Id = ?"
            );
            
            statement.setInt(1, cliente.getId());
            statement.executeUpdate();
            
            System.out.println("Removeu");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Cliente> todosOsClientes() {
       
        try {
            
            List<Cliente> clientes = new ArrayList<>();
            
            ResultSet result = connection
                    .prepareStatement(
                            "SELECT * FROM Cliente"
            ).executeQuery();
            
            while ( result.next() ) {
                
               clientes.add(
                       criarCliente(result)
               );
                
            }
            
            return clientes;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
        
    }
    
    public Cliente criarCliente(ResultSet result) throws SQLException{
        
        int id = result.getInt("Id");
        String nome = result.getString("Nome");
        String Cpf = result.getString("Cpf");
        return new Cliente(id, nome, Cpf);
        
    }

    @Override
    public void atualizar(Cliente cliente) {
       
        try {
            
            PreparedStatement statement =connection
                    .prepareStatement(
                            "UPDATE Cliente SET Nome = ?, Cpf = ? WHERE Id = ?"
            );
            
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setInt(3, cliente.getId());
            statement.executeUpdate();
            
            System.out.println("Atualizou");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
