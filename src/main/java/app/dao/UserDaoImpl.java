package app.dao;

import app.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    private final EntityManagerFactory entityManagerFactory;

    public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManagerFactory.createEntityManager().createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        User returnedUser = entityManagerFactory.createEntityManager().merge(user);
        System.out.println("returnedUser in addUser method: " + returnedUser);
    }

    @Override
    public User getUserById(long id) {
        return entityManagerFactory.createEntityManager().getReference(User.class, id);
    }

    @Override
    public void deleteUserById(long id) {
        entityManagerFactory.createEntityManager().remove(this.getUserById(id));
    }
}
