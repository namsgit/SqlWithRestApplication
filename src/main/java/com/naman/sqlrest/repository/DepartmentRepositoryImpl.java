/**
 * Author: Naman Jain
 * Created on 22/02/20
 */
package com.naman.sqlrest.repository;

import com.naman.sqlrest.entity.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public abstract class DepartmentRepositoryImpl implements DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Department getDepartmentByName(String departmentName) {
        Query query = entityManager.createQuery(
                "SELECT e FROM Department e where e.departmentName = :departmentName", Department.class);

        return (Department) query.setParameter("departmentName", departmentName).getSingleResult();

    }
}
