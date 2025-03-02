package co.edu.poli.ejemplo.servicio;

import co.edu.poli.ejemplo.modelo.Cliente;


import java.util.*;

/**
 * 
 */
public interface IClienteDAO {

    /**
     * @param cliente 
     * @return
     */
    public String create (Cliente cliente);

    /**
     * @return
     */
    public List<Cliente> readAllCliente();

    /**
     * @param id 
     * @return
     */
    public Cliente readCliente(String id);

    /**
     * @param id 
     * @param cliente 
     * @return
     */
    public String updateCliente(String id, Cliente cliente);

    /**
     * @param id 
     * @return
     */
    public String deleteCliente(String id);

}