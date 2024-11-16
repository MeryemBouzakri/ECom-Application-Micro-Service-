package ma.xproce.billingservice.service;

import ma.xproce.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping(path = "/api/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/api/customers")
    PagedModel<Customer> getAllCustomers();


}
