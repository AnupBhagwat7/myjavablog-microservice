package in.myjavablog.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

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
        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
        Customer result = customerService.registerCustomer(customerRegistrationRequest);

        //Then
        Assertions.assertEquals(1, result.getId());
    }


}
