package ma.xproce.billingservice.web;

import ma.xproce.billingservice.entities.Bill;
import ma.xproce.billingservice.repository.BillRepository;
import ma.xproce.billingservice.repository.ProductItemRepository;
import ma.xproce.billingservice.service.CustomerRestClient;
import ma.xproce.billingservice.service.ProductRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillRestController(BillRepository billRepository, ProductRestClient productRestClient, CustomerRestClient customerRestClient, ProductItemRepository productItemRepository) {
        this.billRepository = billRepository;
        this.productRestClient = productRestClient;
        this.customerRestClient = customerRestClient;
        this.productItemRepository = productItemRepository;
    }
    @GetMapping("/bills/{id}")
    public Bill bill(@PathVariable Long id) {
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(productRestClient.findProductById(pi.getProductId()));
                });
        return bill;
    }
}
