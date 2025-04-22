package co.edu.poli.corte2.repositories.implementations;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.poli.corte2.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SupplierRepository {

    private static final String JSON_FILE_PATH = "/suppliers.json";
    public static List<Supplier> proveedoresDTO = new ArrayList<>();

    // Método para cargar todos los proveedores desde el JSON
    public List<Supplier> cargarProveedores() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = SupplierRepository.class.getResourceAsStream(JSON_FILE_PATH);
            JsonNode root = mapper.readTree(is);
            JsonNode proveedoresNode = root.get("proveedores");

            for (JsonNode provNode : proveedoresNode) {
                int id = provNode.get("id").asInt();
                String nombre = provNode.get("nombre").asText();
                String email = provNode.get("email").asText();

                // Crear DTO del proveedor
                Supplier dto = new Supplier(id, nombre, email);
                proveedoresDTO.add(dto);
            }
        } catch (Exception e) {
            System.err.println("Error al cargar proveedores desde JSON: " + e.getMessage());
            e.printStackTrace();
        }

        return proveedoresDTO;
    }

    // Método para cargar solo los nombres de los proveedores (útil para ComboBox)
    public ObservableList<String> cargarNombresProveedores() {
        ObservableList<String> nombres = FXCollections.observableArrayList();
        List<Supplier> proveedores = cargarProveedores();

        for (Supplier dto : proveedores) {
            nombres.add(dto.getName());
        }

        return nombres;
    }

}
