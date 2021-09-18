
package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Produto;
import br.edu.ifpb.domain.Produtos;
import java.math.BigDecimal;
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
public class ProdutosEmJDBC implements Produtos {
    
     private Connection connection;
        
    
    public ProdutosEmJDBC() throws SQLException {
        
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                "jdbc:postgresql://host-banco:5432/atividade2",
                "wendel","123"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutosEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }

    @Override
    public void adicionar(Produto produto) {
        
         try {
             PreparedStatement statement = connection
                     .prepareStatement(
                             "INSERT INTO Produto (Descricao, Valor) VALUES (?, ?)"
             );
             
             statement.setString(1, produto.getDescricao());
             statement.setInt(2, produto.getValor().intValueExact());
             statement.executeUpdate();
             
             
         } catch (SQLException ex) {
             Logger.getLogger(ProdutosEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

    @Override
    public void atualizar(Produto produto) {
        
         try {
             
             PreparedStatement statement = connection
                     .prepareStatement(
                             "UPDATE Produto SET Descricao = ?, Valor = ? WHERE Id = ?"
             );
             
             statement.setString(1, produto.getDescricao());
             statement.setInt(2, produto.getValor().intValueExact());
             statement.setInt(3, produto.getId());
             statement.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(ProdutosEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

    @Override
    public void remover(Produto produto) {

         try {
             PreparedStatement statement = connection
                     .prepareStatement(
                             "DELETE FROM Produto WHERE Id = ?"
             );
             
             statement.setInt(1, produto.getId());
             statement.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(ProdutosEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

    @Override
    public List<Produto> todosOsProdutos() {
       
         try {
             
             List<Produto> produtos = new ArrayList<>();
             
             ResultSet result = (ResultSet) connection.prepareStatement(
                     "SELECT * FROM Produto"
             ).executeQuery();
             
             while ( result.next() ) {
                 produtos.add(
                         criarProduto(result)
                 );
             }
              
             return produtos;
             
             } catch (SQLException ex) {
                Logger.getLogger(ProdutosEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
                return Collections.EMPTY_LIST;
             }
        
    }
    
    public Produto criarProduto(ResultSet result) throws SQLException {
        
        int id = result.getInt("Id");
        String descricao = result.getString("Descricao");
        BigDecimal valor = new BigDecimal(result.getInt("Valor"));
        return new Produto(id, descricao, valor);
        
    }

    @Override
    public List<Produto> localizarProdutosPorDescricao(String descricao) {
        
         try {
             
             List<Produto> produtos = new ArrayList<>();
             
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM Produto WHERE Descricao = ?"
             );
             
             statement.setString(1, descricao);
             statement.executeQuery();
             
             ResultSet result = statement.getResultSet();
             
             while ( result.next() ) {
                 produtos.add(
                         criarProduto(result)
                 );
             }
             
             return produtos;
             
         } catch (SQLException ex) {
             Logger.getLogger(ProdutosEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
             return Collections.EMPTY_LIST;
         }
        
    }
    
}
