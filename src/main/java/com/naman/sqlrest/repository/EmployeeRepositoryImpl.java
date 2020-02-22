/**
 * Author: Naman Jain
 * Created on 21/02/20
 */
package com.naman.sqlrest.repository;

import com.naman.sqlrest.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// JPA Query params: https://www.baeldung.com/jpa-query-parameters
// JPQL vs native query: https://stackoverflow.com/questions/25180597/named-query-or-native-query-or-query-which-one-is-better-in-performance-point-of


@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(long id) {
        Query query = entityManager.createQuery("SELECT e FROM Employee e where e.id = :id", Employee.class);
        return  (Employee) query.setParameter("id", id).getSingleResult();

        //return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        // Cannot pass an object with id already there to persist in the below object because that creates an conflct
        // with the auto-generated key.
        entityManager.persist(employee);
    }

    @Override
    public void deleteById(long id) {
//        Query query = entityManager.createQuery("DELETE FROM Employee e WHERE e.id = :id");
//        query.setParameter("id", id).executeUpdate();
        Employee employee = findById(id);
        entityManager.remove(employee);
    }
}
