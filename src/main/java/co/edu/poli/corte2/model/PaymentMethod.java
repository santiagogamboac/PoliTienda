package co.edu.poli.corte2.model;

/**
 *
 */
public class PaymentMethod {

    private int id;

    private String name;

    private Boolean active;

    public PaymentMethod() {

    }

    public PaymentMethod(int id, String name, Boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
