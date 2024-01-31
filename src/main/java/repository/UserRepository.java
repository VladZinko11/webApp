package repository;

import config.ConfigHibernate;
import jakarta.persistence.NoResultException;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository implements UserRepositoryInterface {
    SessionFactory sessionFactory = ConfigHibernate.getSessionFactory();

    @Override
    public User findById(int id) {
        User user;
        String hql = "from User where id = :id";
        try (Session session = sessionFactory.openSession()) {
            user = session.createQuery(hql, User.class).setParameter("id", id).getSingleResult();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list;
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("from User", User.class).list();
        }
        return list;
    }

    @Override
    public void delete(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        }
    }

    @Override
    public void save(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
    }

    @Override
    public User findByName(String userName) {
        String sql = "from User where name = :username";
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery(sql, User.class);
            query.setParameter("username", userName);
            User user = query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }
}