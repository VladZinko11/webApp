package repository;


import model.User;

import java.util.List;

public interface UserRepositoryInterface  {

    User findById(int id);
    List<User> findAll();
    void delete(User user);
    void save(User user);
    User findByName(String userName);
}
