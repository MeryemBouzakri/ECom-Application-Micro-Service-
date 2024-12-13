package ma.xproce.billingservice.repository;

import ma.xproce.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    @RestResource(path="/bycustomerId")
    List<Bill> findByCustomerId(@Param("customerId") long customerId);
}
