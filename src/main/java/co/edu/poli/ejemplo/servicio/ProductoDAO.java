package co.edu.poli.ejemplo.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.poli.ejemplo.modelo.Producto;
import co.edu.poli.ejemplo.modelo.ProductoAlimento;
import co.edu.poli.ejemplo.modelo.ProductoElectronico;

/**
 * 
 */
public class ProductoDAO implements ProductoRepository {

    private Connection conexion;

    public ProductoDAO() throws Exception {
        this.conexion = DatabaseConnection.getInstance().getConnection();
    }

    /**
     * @param t 
     * @return
     */
    public String create(Producto producto) {
        String sqlProducto = "INSERT INTO producto (id, descripcion, precio) VALUES (?, ?, ?)";
        try (PreparedStatement stmtProducto = conexion.prepareStatement(sqlProducto)) {
            stmtProducto.setString(1, producto.getId());
            stmtProducto.setString(2, producto.getDescripcion());
            stmtProducto.setDouble(3, producto.getPrecio());

            stmtProducto.executeUpdate();

            if (producto instanceof ProductoAlimento) {
                String sqlAlimento = "INSERT INTO producto_alimento (id, calorias) VALUES (?, ?)";
                try (PreparedStatement stmtAlimento = conexion.prepareStatement(sqlAlimento)) {
                    // stmtAlimento.setString(1, producto.getId());
                    // stmtAlimento.setInt(2, ((ProductoAlimento) producto).getCalorias());
                    // stmtAlimento.executeUpdate();
                }
            } else if (producto instanceof ProductoElectronico) {
                //String sqlElectronico = "INSERT INTO producto_electronico (id, garantia) VALUES (?, ?)";
                // try (PreparedStatement stmtElectronico = conexion.prepareStatement(sqlElectronico)) {
                //     stmtElectronico.setString(1, producto.getId());
                //     stmtElectronico.setInt(2, ((ProductoElectronico) producto).getVoltajeEntrada()());
                //     stmtElectronico.executeUpdate();
                // }
            }

            return "Producto agregado correctamente.";
        } catch (SQLException e) {
            return "Error al agregar producto: " + e.getMessage();
        }
    }

    /**
     * @return
     */
    public List<Producto> readAll() {
        List<Producto> productos = new ArrayList<>();

        String sqlProductoAlimento = "SELECT p.id, p.descripcion, p.precio, pa.calorias FROM producto p INNER JOIN producto_alimento pa ON p.id = pa.id";
        String sqlProductoElectronico = "SELECT p.id, p.descripcion, p.precio, pe.garantia FROM producto p INNER JOIN producto_electronico pe ON p.id = pe.id";

        try (Statement stmt = conexion.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(sqlProductoAlimento)) {
                while (rs.next()) {
                    productos.add(new ProductoAlimento(
                        rs.getString("id"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("calorias")
                    ));
                }
            }

            try (ResultSet rs = stmt.executeQuery(sqlProductoElectronico)) {
                while (rs.next()) {
                    productos.add(new ProductoElectronico(
                        rs.getString("id"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("garantia")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener productos: " + e.getMessage());
        }

        return productos;
    }

    public List<ProductoAlimento> readAllAlimentos() {
        List<ProductoAlimento> productos = new ArrayList<>();
        String sql = "SELECT p.id, p.descripcion, p.precio, pa.calorias FROM producto p INNER JOIN producto_alimento pa ON p.id = pa.id";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                productos.add(new ProductoAlimento(
                    rs.getString("id"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("calorias")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener productos alimento: " + e.getMessage());
        }

        return productos;
    }

    public List<ProductoElectronico> readAllElectronicos() {
        List<ProductoElectronico> productos = new ArrayList<>();
        String sql = "SELECT p.id, p.descripcion, p.precio, pe.garantia FROM producto p INNER JOIN producto_electronico pe ON p.id = pe.id";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                productos.add(new ProductoElectronico(
                    rs.getString("id"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("voltaje")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener productos electrónicos: " + e.getMessage());
        }

        return productos;
    }

    /**
     * @param id 
     * @return
     */
    public Producto read(String id) {
        String sql = "SELECT * FROM producto WHERE id = ?";
        Producto producto = null;

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                // if (rs.next()) {
                //     producto = new Producto(
                //         rs.getString("id"),
                //         rs.getString("descripcion"),
                //         rs.getDouble("precio")
                //     );
                // }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener producto: " + e.getMessage());
        }
        return producto;
    }

    /**
     * @param id 
     * @param t 
     * @return
     */
    public String update(String id, Producto producto) {
        String sqlProducto = "UPDATE producto SET descripcion = ?, precio = ? WHERE id = ?";
        try (PreparedStatement stmtProducto = conexion.prepareStatement(sqlProducto)) {
            stmtProducto.setString(1, producto.getDescripcion());
            stmtProducto.setDouble(2, producto.getPrecio());
            stmtProducto.setString(3, id);

            int filasProducto = stmtProducto.executeUpdate();

            if (producto instanceof ProductoAlimento) {
                String sqlAlimento = "UPDATE producto_alimento SET calorias = ? WHERE id = ?";
                try (PreparedStatement stmtAlimento = conexion.prepareStatement(sqlAlimento)) {
                    //stmtAlimento.setInt(1, ((ProductoAlimento) producto).getCalorias());
                    stmtAlimento.setString(2, id);
                    int filasAlimento = stmtAlimento.executeUpdate();
                    if (filasProducto > 0 && filasAlimento > 0) {
                        return "Producto alimento actualizado correctamente.";
                    }
                }
            } else if (producto instanceof ProductoElectronico) {
                //String sqlElectronico = "UPDATE producto_electronico SET garantia = ? WHERE id = ?";
                // try (PreparedStatement stmtElectronico = conexion.prepareStatement(sqlElectronico)) {
                //     stmtElectronico.setInt(1, ((ProductoElectronico) producto).getGarantia());
                //     stmtElectronico.setString(2, id);
                //     int filasElectronico = stmtElectronico.executeUpdate();
                //     if (filasProducto > 0 && filasElectronico > 0) {
                //         return "Producto electrónico actualizado correctamente.";
                //     }
                // }
            }

            if (filasProducto > 0) {
                return "Producto actualizado correctamente.";
            } else {
                return "Producto no encontrado.";
            }
        } catch (SQLException e) {
            return "Error al actualizar producto: " + e.getMessage();
        }
    }

    /**
     * @param id 
     * @return
     */
    public String delete(String id) {
        // String sql = "DELETE FROM producto WHERE id = ?";
        // try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        //     stmt.setString(1, id);
        //     int filas = stmt.executeUpdate();
        //     if (filas > 0) {
        //         return "Producto eliminado correctamente.";
        //     } else {
        //         return "Producto no encontrado.";
        //     }
        // } catch (SQLException e) {
             return "Error al eliminar producto: "; //+ e.getMessage();
        // }
    }

    /**
     * @param min 
     * @param max 
     * @return
     */
    public List<Producto> findByPriceRange(double min, double max) {
    	
       List<Producto> productos = readAll();
       
       return productos.stream()
       .filter(p -> p.getPrecio() >= min && p.getPrecio() <= max)
       .collect(Collectors.toList());    
    }

}