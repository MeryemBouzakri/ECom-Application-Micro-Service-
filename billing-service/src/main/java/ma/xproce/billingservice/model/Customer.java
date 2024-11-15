package ma.xproce.billingservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Customer {
    private Long id;
    private String Name;
    private String email;
}
