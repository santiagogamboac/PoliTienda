package co.edu.poli.corte2.model;

/**
 * Clase que almacena los usuarios del sistema
 */
public class User {

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * Identificador único de usuario
     */
    private int id;

    /**
     * Nombre de usuario
     */
    private String userName;

    /**
     * Clave del usuario
     */
    private String password;

    /**
     * Perfil que desempeña
     */
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String userName, String password, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

}