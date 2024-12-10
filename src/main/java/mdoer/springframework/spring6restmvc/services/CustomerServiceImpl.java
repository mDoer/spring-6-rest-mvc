package mdoer.springframework.spring6restmvc.services;

import lombok.extern.slf4j.Slf4j;
import mdoer.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> customerMap;
    private List<String> customerNames = List.of("Customer1", "Customer2", "Customer3", "Customer4", "Customer5");

    public CustomerServiceImpl() {
        customerMap = new HashMap<>();
        this.customerNames.forEach(customerName -> {
            Customer newCustomer = Customer.builder()
                    .customerName(customerName)
                    .customerId(UUID.randomUUID())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            this.customerMap.put(newCustomer.getCustomerId(), newCustomer);
        });
    }

    @Override
    public List<Customer> getAllCustomers() {
        log.info("Get all customers");
        return new ArrayList<>(this.customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        log.info("Get customer by id: {}", id);
        return this.customerMap.get(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer customerSaved = Customer.builder()
                .customerId(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .createdAt(LocalDateTime.now())
                .build();
        this.customerMap.put(customerSaved.getCustomerId(), customerSaved);

        return customerSaved;
    }
}
