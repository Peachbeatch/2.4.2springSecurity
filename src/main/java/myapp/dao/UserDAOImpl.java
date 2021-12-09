package myapp.dao;

import org.springframework.stereotype.Repository;
import myapp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {//SELECT users FROM User users
        return entityManager.createQuery("SELECT users FROM User users", User.class).getResultList();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(getById(id));
                /*createQuery("DELETE FROM User u where u.id = :id")
                .setParameter("id", id)
                .executeUpdate();*/
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserByName(String name) {//SELECT u FROM User u WHERE u.name=:name
        return entityManager.createQuery("FROM User WHERE name=:name", User.class)
                .setParameter("name", name).getSingleResult();
    }
}