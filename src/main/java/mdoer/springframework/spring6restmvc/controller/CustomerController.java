package mdoer.springframework.spring6restmvc.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mdoer.springframework.spring6restmvc.model.Customer;
import mdoer.springframework.spring6restmvc.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Controller
@Slf4j
@RestController()
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedCustomer.getCustomerId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "{customerID}", method = RequestMethod.GET)
    public Customer getBCustomerByID(@PathVariable("customerID") UUID customerID) {
        log.info("getBCustomerByID called");
        return customerService.getCustomerById(customerID);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        log.debug("getAllCustomers - in controller");
        return customerService.getAllCustomers();
    }
}
