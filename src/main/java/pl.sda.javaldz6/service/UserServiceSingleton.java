package pl.sda.javaldz6.service;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.sda.javaldz6.model.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope("singleton")
public class UserServiceSingleton implements UserService {
    private Logger log = Logger.getLogger(UserServiceSingleton.class);
    private List<User> users;

    @PostConstruct
    public void init() {
        users = new ArrayList<User>();
        log.info("Users singleton log init");
    }

    @PreDestroy
    public void close() {
        log.info("Users Singleton destroy bean");
    }

    public User getUserById(int index) {
        try {
            log.info("got user " + index);
            return users.get(index);
        } catch (NullPointerException ex) {
            log.error("Threw null pointer exception");
            return null;
        }
    }
    @Override
    public List<User> getAll(){
        return users;
    }
    @Override
    public void addUser(String name, int age) {
        users.add(new User(name, age));
    }


    @Override
    public User modifyUser(int index, User user) {
        User user1 = new User();
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        users.set(index, user1);
        return user1;
    }

    @Override
    public boolean deleteUser(int index) {
        if (users.get(index) != null) {
            users.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getUserByName(String lookUpValue) {
        return users.stream().filter(user -> user.getName().contains(lookUpValue)).collect(Collectors.toList());

    }
}
