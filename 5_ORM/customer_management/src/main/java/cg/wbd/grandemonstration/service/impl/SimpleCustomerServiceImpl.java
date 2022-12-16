package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.query.QueryProducer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class SimpleCustomerServiceImpl implements CustomerService {
    private static List<Customer> customers;
    private static long autoIncreaseId = 0;
    private EntityManager entityManager = null;


    static {
        customers = asList(
                new Customer(autoIncreaseId++, "T", "t@codegym.vn", "Da Nang"),
                new Customer(autoIncreaseId++, "Nhat", "nhat@codegym.vn", "Quang Tri"),
                new Customer(autoIncreaseId++, "Trang", "trang@codegym.vn", "Ha Noi"),
                new Customer(autoIncreaseId++, "Nguyen Binh Son", "son@codegym.vn", "Sai Gon"),
                new Customer(autoIncreaseId++, "Dang Xuan Hoa", "hoa.dang@codegym.vn", "Da Nang")
        );
    }

    @Override
    public List<Customer> findAll() {
        String queryStr = "SELECT c FROM Customer AS c";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findOne(String id) {
        return null;
    }

    @Override
        public Customer findOne(Long id) {
            String queryStr = "SELECT c FROM Customer AS c WHERE c.id = :id";
            TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }

    @Override
    public Customer save(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try {
            SessionFactory sessionFactory = null;
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Customer origin = findOne(customer.getId());
            origin.setName(customer.getName());
            origin.setEmail(customer.getEmail());
            origin.setAddress(customer.getAddress());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return customers.stream()
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public boolean exists(Long id) {
        return customers.stream().anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return ids.stream()
                .map(this::findOne)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return customers.size();
    }

    @Override
    public void delete(Long id) {
        customers.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public void delete(Customer customer) {
        delete(customer.getId());
    }

    @Override
    public void delete(List<Customer> customers) {
        customers.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        customers = new ArrayList<>();
    }

    private Customer persist(Customer customer) {
        Customer clone = customer.clone();
        clone.setId(autoIncreaseId++);
        customers.add(clone);
        return clone;
    }

    private Customer merge(Customer customer) {
        Customer origin = findOne(customer.getId());
        origin.setName(customer.getName());
        origin.setEmail(customer.getEmail());
        origin.setAddress(customer.getAddress());
        return origin;
    }
}
