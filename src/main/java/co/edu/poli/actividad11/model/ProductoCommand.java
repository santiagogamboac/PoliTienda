package co.edu.poli.actividad11.model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface ProductoCommand {

    /**
     * @return
     */
    public void execute();

    /**
     * @return
     */
    public void undo();

}