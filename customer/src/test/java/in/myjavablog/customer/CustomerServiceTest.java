package in.myjavablog.customer;

import in.myjavablog.clients.fraud.FraudCheckResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private RestTemplate restTemplate;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest("Anup", "Bhagwat", "anup.bhagwat7@gmail.com");
        customer = Customer.builder()
                .id(1)
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail()).build();

    }

    @Test
    public void testRegisterCustomerSuccess() {

        //Given
        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest("Anup", "Bhagwat", "anup.bhagwat7@gmail.com");

        //When
        Mockito.when(customerRepository.saveAndFlush(Mockito.any())).thenReturn(customer);
        Mockito.when(restTemplate.getForObject(Mockito.any(),Mockito.any(),Mockito.anyInt())).thenReturn(new FraudCheckResponse());
        Customer result = customerService.registerCustomer(customerRegistrationRequest);

        //Then
        Assertions.assertEquals(customerRegistrationRequest.getFirstName(), result.getFirstName());
    }


}
