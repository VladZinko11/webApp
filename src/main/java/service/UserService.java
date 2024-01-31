package service;

import exceptions.UserException;
import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public User findById(int id) throws UserException {
        User user = userRepository.findById(id);
        if (user.equals(null)) throw new UserException();
        return user;
    }

    public List<User> findAll() {
        List<User> list = userRepository.findAll();
        return list;
    }

    public String delete(User user) {
        String message;
        if (userRepository.findByName(user.getName())!=null) {
            userRepository.delete(user);
            message = "пользователь удален";
        } else message = "пользователь не найден";
        return message;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByName(String userName) {
        return userRepository.findByName(userName);
    }

    public boolean containsName(String userName) {
        return userRepository.findByName(userName) != null ? true : false;   }
}
