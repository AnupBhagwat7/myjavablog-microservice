package in.myjavablog.customer;

import in.myjavablog.clients.fraud.FraudCheckResponse;
import in.myjavablog.clients.fraud.FraudClient;
import in.myjavablog.clients.notifications.NotificationClient;
import in.myjavablog.clients.notifications.NotificationRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.client.RestTemplate;
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private ObjectProvider<FraudClient> fraudClient;

    @MockBean
    private ObjectProvider<NotificationClient> notificationClient;
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
        //Mockito.when(customerRepository.saveAndFlush(Mockito.any())).thenReturn(customer);
        //Mockito.when(restTemplate.getForObject(Mockito.any(),Mockito.any(),Mockito.anyInt())).thenReturn(new FraudCheckResponse());
        //Mockito.when(fraudClient.getObject().checkFraudCustomer(Mockito.anyInt())).thenReturn(Mockito.any(FraudCheckResponse.class));
        //Mockito.when(notificationClient.getObject().sendNotification(Mockito.any(NotificationRequest.class))).thenCallRealMethod();
        //Customer result = customerService.registerCustomer(customerRegistrationRequest);

        //Then
        //Assertions.assertEquals(customerRegistrationRequest.getFirstName(), result.getFirstName());
    }


}
