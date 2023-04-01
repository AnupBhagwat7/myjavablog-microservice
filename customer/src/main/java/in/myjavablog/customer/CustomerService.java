package in.myjavablog.customer;

import in.myjavablog.clients.fraud.FraudCheckResponse;
import in.myjavablog.clients.fraud.FraudClient;
import in.myjavablog.clients.notifications.NotificationClient;
import in.myjavablog.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    private RestTemplate restTemplate;
    //private FraudClient fraudClient;

    @Autowired
    private ObjectProvider<FraudClient> fraudClient;

    @Autowired
    private ObjectProvider<NotificationClient> notificationClient;
    public Customer registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail())
                .build();

        //Check if email is valid
        //Check if email is already taken
        customerRepository.saveAndFlush(customer);
        /*restTemplate.getForObject("http://fraudcheck/api/v1/fraudcheck/{customerId}"
                , FraudCheckResponse.class
                ,customer.getId());*/

        //Call fraud detection service using Feign client
        FraudCheckResponse fraudCheckResponse =fraudClient.getObject().checkFraudCustomer(customer.getId()); //checkFraudCustomer(customer.getId());

        log.info("Fraud check response for Customer {} ",customer.getId() +" is {} : ",fraudCheckResponse.getIsFraudCustomer());

        //Send Notification
        NotificationRequest notificationRequest = NotificationRequest.builder()
                .message("Welcome ,"+ customer.getEmail() +" from Myjavablog")
                .sender("Myjavablog")
                .sent_to_email(customer.getEmail())
                .sent_to_customerid(customer.getId())
                .sentAt(LocalDateTime.now())
                .build();

        notificationClient.getObject().sendNotification(notificationRequest);

        return customer;

    }
}
