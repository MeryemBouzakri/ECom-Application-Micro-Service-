package ma.xproce.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.sql.Date;

@Projection(name = "fullBill", types =Bill.class )

public interface BillProjection {
    Long getId();
    Date getCreatedAt();
    Long getCustomerId();
    BillStatus getStatus();

}
