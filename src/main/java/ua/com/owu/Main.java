package ua.com.owu;

import ua.com.owu.entity.Room;
import ua.com.owu.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("okten");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user1 = new User("Sanya" , "Kozl");
        User user2 = new User("Roman" , "Root");
        Room room1 = new Room("1");
        Room room2 = new Room("2");

        List<User>users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        List<Room>rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);

        user1.setRooms(rooms);
        room1.setUserList(users);

        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(room1);
        entityManager.persist(room2);



        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
