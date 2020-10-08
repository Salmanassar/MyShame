package hiber.dao;

import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getUserByCar(String model, int series);
}
