package co.edu.poli.ejemplo.servicio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ejemplo.modelo.Cliente;

/**
 * 
 */
public class ClienteDAO implements ICrudDAO<Cliente> {

	private final Connection conexion;
    /**
     * Default constructor
     * @throws Exception 
     */
    public ClienteDAO() throws Exception {
    	this.conexion = DatabaseConnection.getInstance().getConnection();
    }

    public String create(Cliente cliente) {
    	
    	 String sql = "INSERT INTO cliente (id, nombre) VALUES (?, ?)";
         try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
             stmt.setString(1, cliente.getId());  
             stmt.setString(2, cliente.getNombre());
     
             stmt.executeUpdate();
             return "Cliente agregado correctamente.";
             
         } catch (SQLException e) {
            return "Error al agregar cliente: " + e.getMessage();
         }     
    }

    public List<Cliente> readAll() {
   
    	  List<Cliente> clientes = new ArrayList<>();
          String sql = "SELECT * FROM cliente";
          try (Statement stmt = conexion.createStatement();
               ResultSet rs = stmt.executeQuery(sql)) {
              while (rs.next()) {
                  clientes.add(new Cliente(
                          rs.getString("id"),
                          rs.getString("nombre")                       
                  ));
              }
          } catch (SQLException e) {
              System.out.println("Error al obtener clientes: " + e.getMessage());
          }
          return clientes;
    }

    public Cliente read(String id) {

    	String sql = "SELECT * FROM cliente WHERE id = ?";
        Cliente cliente = null;

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, id); 
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) { 
                    cliente = new Cliente(
                        rs.getString("id"),
                        rs.getString("nombre")
                    );
                }
            }
        } catch (SQLException e) {
          System.out.println("Error al obtener clientes: " + e.getMessage());
      }
      return cliente;
    }
   
    public String update(String id, Cliente cliente) {
    	String sql = "UPDATE Cliente SET nombre = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());            
            stmt.setString(2, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) { 
               return("Cliente actualizado correctamente.");
            } else {
                return("Cliente no encontrado.");
            }
        } catch (SQLException e) {
            return("Error al actualizar cliente: " + e.getMessage());
        }              
    }

    public String delete(String id) {
    	String sql = "DELETE FROM Cliente WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                return "Cliente eliminado correctamente.";
            } else {
            return"Cliente no encontrado.";
            }
        } catch (SQLException e) {
           return"Error al eliminar cliente: " + e.getMessage();
        }
    
    }
}