package pl.sda.javaldz6.service;

import pl.sda.javaldz6.model.User;

import java.util.List;

public interface UserService {
    public void addUser(String name, int age);
    public User getUserById(int index);
    public List<User> getAll();
    public User modifyUser(int index, User user);
    public boolean deleteUser(int index);
    public List<User> getUserByName(String lookUpValue);
    public void init();
    public void close();


}
