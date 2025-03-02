package co.edu.poli.ejemplo.servicio;

import java.util.*;

/**
 * 
 */
public interface ICrudDAO <T>{

    /**
     * @param t 
     * @return
     */
    public String create(T t);

    /**
     * @return
     */
    public List<T> readAll();

    /**
     * @param id 
     * @return
     */
    public T read(String id);

    /**
     * @param id 
     * @param t 
     * @return
     */
    public String update(String id, T t);

    /**
     * @param id 
     * @return
     */
    public String delete(String id);

}