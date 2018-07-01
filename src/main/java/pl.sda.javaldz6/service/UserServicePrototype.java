package pl.sda.javaldz6.service;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.sda.javaldz6.model.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class UserServicePrototype implements UserService {
    private Logger log = Logger.getLogger(UserServicePrototype.class);
    private List<User> users;

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

    public User getUserById(int index) {
       try {
           return users.get(index);
       }catch (NullPointerException ex){
           log.error("Threw null pointer exception");
           return null;
        }
    }
    @PostConstruct
    public void init() {
        users = new ArrayList<User>();
        log.info("Users prototype log init");

    }
    @PreDestroy
    public void close() {
        log.info("Users prototype destroy bean");
    }

    public void addUser(String name, int age) {
        users.add(new User(name, age));
    }

    @Override
    public List<User> getUserByName(String lookUpValue) {
        return null;
    }
}
