package mdoer.springframework.spring6restmvc.services;

import mdoer.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(UUID id);

    Customer saveCustomer(Customer customer);
}
