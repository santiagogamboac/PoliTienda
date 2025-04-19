package co.edu.poli.corte2.repositories.interfaces;

import co.edu.poli.corte2.model.User;

public interface IUserRepository {

    public User getUser(String username, String password) throws Exception;
    public void loadFromFile();
}
