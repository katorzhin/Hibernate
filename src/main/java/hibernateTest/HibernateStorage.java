package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class HibernateStorage {

    private SessionFactory sessionFactory;

    public HibernateStorage() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    //CRUD
    public void createCat(Cat cat) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cat);
        transaction.commit();
        session.close();
    }

    public Cat getCatById(int id) {
        Cat cat = null;

        Session session = sessionFactory.openSession();
        cat = session.get(Cat.class, id);
        session.close();

        return cat;
    }

    public void updateCat(Cat cat) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(cat);
        transaction.commit();
        session.close();

    }

    public void deleteCat(Cat cat) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cat);
        transaction.commit();
        session.close();
    }

    public List<Cat> getAllCats() {
        List<Cat> result = null;

        Session session = sessionFactory.openSession();
        result = session.createQuery("from Cat", Cat.class).list();

        session.close();
        return result;
    }
    public List<Cat> search(String catName){
        List<Cat> result = null;
        Session session = sessionFactory.openSession();

        String sqlQuery = "select id,cat_name,weight,sex from Cat where cat_name like '%"+catName+"%'";
        result = session.createNativeQuery(sqlQuery,Cat.class).list();

//        String hqlQuery = "from Cat c where c.catName like '%"+catName+"%'";
//        result = session.createQuery(hqlQuery,Cat.class).list();

        session.close();
        return result;
    }

    public static void main(String[] args) {
        HibernateStorage storage = new HibernateStorage();

        //List<Cat> cats = storage.search("Л");
        /*add record into table
        cat.setCatName("Мася");
        cat.setWeight(3);
        cat.setSex(true);
        cat.setOwnerId(3);
        new HibernateStorage().createCat(cat);*/
        //     Cat cat = new HibernateStorage().getCatById(4);

    }
}
