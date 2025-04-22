package co.edu.poli.corte2.repositories.implementations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.poli.corte2.model.User;
import co.edu.poli.corte2.repositories.interfaces.IUserRepository;

public class UserRepository implements IUserRepository{

    private static final String FILE_PATH = "src/main/resources/users.json";
    private static List<User> users = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();
    
    //private static Map<String, User> users = new HashMap<>();
    private static UserRepository instance;

    public User getUser(String username, String password) throws Exception{
        try {
            users = objectMapper.readValue(
                new File(FILE_PATH),
                new TypeReference<List<User>>() {}
            );
        } catch (IOException e) {
            throw new Exception("Error al leer el archivo de usuarios", e);
        }

        return users.stream()
                    .filter(user -> user.getUserName().equals(username) &&
                                    user.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public UserRepository() {
        loadFromFile();
    }

    public void loadFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                users = objectMapper.readValue(file, new TypeReference<List<User>>() {
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
