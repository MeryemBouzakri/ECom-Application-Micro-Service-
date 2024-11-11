package org.meryem.customerservice.repository;

import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.meryem.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
