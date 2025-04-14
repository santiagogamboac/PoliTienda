package co.edu.poli.corte2.model;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    
    private static Map<String, User> users = new HashMap<>();

    static {
        users.put("admin", new User(1, "admin", "Adm1234", "ADMIN"));
        users.put("juan", new User(2, "juan", "soyjuan", "USER"));
    }

    public static User getUser(String username, String password) throws Exception{
        try {
            return users.get(username);
        } catch (Exception e) {
            return null;
        }
    }
}
