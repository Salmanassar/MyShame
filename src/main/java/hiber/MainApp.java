package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        Car audi = new Car("audi", 4);
        Car bmw = new Car("bmw", 6);
        Car mercedes = new Car("mercedes", 5);
        Car volvo = new Car("volvo", 3);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        user1.setCar(audi);
        userService.add(user1);

        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        user2.setCar(bmw);
        userService.add(user2);

        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        user3.setCar(mercedes);
        userService.add(user3);

        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        user4.setCar(volvo);
        userService.add(user4);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car model = " + user.getCar().getModel());
            System.out.println("Car series = " + user.getCar().getSeries());
            System.out.println();
        }
        context.close();
    }
}
