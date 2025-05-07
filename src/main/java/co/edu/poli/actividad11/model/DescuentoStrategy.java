package co.edu.poli.actividad11.model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface DescuentoStrategy {

    /**
     * @param total 
     * @return
     */
    public double aplicarDescuento(double total);

}