package pl.sda.javaldz6.service;

import pl.sda.javaldz6.model.User;

import java.util.List;

public class UserRestService implements UserService{
    public UserRestService() {
        super();
    }

    @Override
    public void addUser(String name, int age) {

    }

    @Override
    public User getUserById(int index) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User modifyUser(int index, User user) {
        return null;
    }

    @Override
    public boolean deleteUser(int index) {
        return false;
    }

    @Override
    public List<User> getUserByName(String lookUpValue) {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public void close() {

    }
}
