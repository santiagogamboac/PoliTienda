package co.edu.poli.corte2.model;

/**
 *
 */
public class PaymentMethod {

    private int id;

    private String type;

    private Boolean active;

    public PaymentMethod(int id, String type, Boolean active) {
        this.id = id;
        this.type = type;
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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
