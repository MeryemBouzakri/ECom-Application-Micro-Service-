package ma.xproce.billingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.xproce.billingservice.model.Customer;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billDate;
    private Long customerId;
    private BillStatus status;
    @OneToMany(mappedBy = "bill")
    private List <ProductItem>productItems;
    @Transient
    private Customer customer;
public double getTotal() {
    double somme = 0;
    for(ProductItem pi: productItems) {
        somme += pi.getAmount();
    }
    return somme;
}
}
