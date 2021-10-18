package services;

import Models.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerService {
    private static SessionFactory sessionFactory;
    private static Session session;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        CustomerService.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        CustomerService.session = session;
    }

    public static void init() {
    }

    public static List<Customer> getAllCustomers() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static Customer getCustomerByID(Customer customer){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root).where(builder.equal(root.get("customer_id"), customer.getCustomer_id()));
        return session.createQuery(query).getSingleResult();
    }
}