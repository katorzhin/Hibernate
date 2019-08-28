package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


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

    public void updateCat(Cat cat){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(cat);
        transaction.commit();
        session.close();

    }
    public void deleteCat(Cat cat){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cat);
        transaction.commit();
        session.close();
    }

    public static void main(String[] args) {
        HibernateStorage storage = new HibernateStorage();
        Cat cat = storage.getCatById(4);

        storage.deleteCat(cat);

        /*add record into table
        cat.setCatName("Мася");
        cat.setWeight(3);
        cat.setSex(true);
        cat.setOwnerId(3);
        new HibernateStorage().createCat(cat);*/
   //     Cat cat = new HibernateStorage().getCatById(4);
        System.out.println(cat);
    }
}
