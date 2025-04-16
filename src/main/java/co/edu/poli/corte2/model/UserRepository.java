package co.edu.poli.corte2.model;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    
    private static Map<String, User> users = new HashMap<>();
    private static UserRepository instance;

    static {
        users.put("admin", new User(1, "admin", "Adm1234", "ADMIN"));
        users.put("juan", new User(2, "juan", "soyjuan", "USER"));
    }

    public static User getUser(String username, String password) throws Exception{
        try {
            User usuario = users.get(username);
            if(usuario.getUserName().equals(username) && usuario.getPassword().equals(password)){
                return users.get(username);
            }else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }
}
