package co.edu.poli.corte2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import co.edu.poli.corte2.repositories.implementations.SupplierRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SupplierFactory {

    private List<Supplier> cache;
    // Caché de proveedores (estado compartido)
    private static final Map<String, Supplier> supplierCache = new HashMap<>();
    private static final TreeSet<Integer> supplierIds = new TreeSet<>();
    public static SupplierRepository supplierRepository = new SupplierRepository();

    // Método para inicializar el repositorio
    public static void setSupplierRepository(SupplierRepository repository) {
        supplierRepository = repository;
    }

    public Supplier getSupplierById(int id) {
        if (cache == null) {
            cache = supplierRepository.cargarProveedores(); // Asegúrate de que esté cargada
        }
        for (Supplier s : cache) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // Método que necesitas agregar:
    public List<Supplier> getAllSuppliers() {
        if (cache == null) {
            // Si la caché está vacía, carga los datos desde el repositorio
            cache = supplierRepository.cargarProveedores();
        }
        return cache;
    }

    public static Supplier getSupplier(String name, String email) {
        if (!supplierCache.containsKey(name)) {
            int id = supplierIds.isEmpty() ? 1 : supplierIds.last() + 1;
            Supplier newSupplier = new Supplier(id, name, email);
            supplierCache.put(name, newSupplier);
            supplierIds.add(id);
        }
        return supplierCache.get(name);
    }

    public static Supplier getSupplierByName(String name) {
        return supplierCache.get(name);
    }

    public static ObservableList<String> getSupplierNames() {
        ObservableList<String> names = FXCollections.observableArrayList();
        names.addAll(supplierCache.keySet());
        return names;
    }

    /**
     * Inicializa la caché de proveedores con datos del repositorio
     *
     * @param suppliers Lista de proveedores a cargar en caché
     */
    public static void initializeCache(List<Supplier> suppliers) {
        for (Supplier supplier : suppliers) {
            supplierCache.put(supplier.getName(), supplier);
        }
    }

    /**
     * Verifica si un proveedor existe en la caché
     *
     * @param name Nombre del proveedor a verificar
     * @return true si existe, false si no
     */
    public static boolean supplierExists(String name) {
        return supplierCache.containsKey(name);
    }

    public static int getUltimoIdProveedor() {
        return supplierIds.isEmpty() ? 0 : supplierIds.last();
    }

    public static int getTotalSuppliers() {
        return supplierCache.size();
    }

    /**
     * Limpia la caché de proveedores
     */
    public static void clearCache() {
        supplierCache.clear();
    }
}
