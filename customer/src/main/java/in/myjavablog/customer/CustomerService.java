package in.myjavablog.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;
    public Customer registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail())
                .build();

        //Check if email is valid
        //Check if email is already taken
        customerRepository.saveAndFlush(customer);
        restTemplate.getForObject("http://fraudcheck/api/v1/fraudcheck/{customerId}"
                ,FraudCheckResponse.class
                ,customer.getId());

        return customer;

        //Send Notification
    }
}
