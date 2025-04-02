package co.edu.poli.ejemplo.modelo;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface Envio {

    /**
     * @return
     */
    public double calcularCosto();

    /**
     * @return
     */
    public int obtenerTiempoEntrega();

    /**
     * @return
     */
    public String procesarEnvio();

}