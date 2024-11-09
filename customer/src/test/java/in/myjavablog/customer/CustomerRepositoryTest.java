package in.myjavablog.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager testEntityManager;
    private Customer customer;

    @BeforeEach
    public void setUp(){
        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest("Anup", "Bhagwat", "anup.bhagwat7@gmail.com");
        customer = Customer.builder()
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail()).build();

        testEntityManager.persist(customer);
    }

    @Test
    public void saveTest(){

        Customer c = customerRepository.save(customer);

        Assertions.assertEquals(customer.getFirstName() , c.getFirstName());
        Assertions.assertNotNull(c);
    }

    @Test
    public void testFindById(){

        Optional<Customer> customer1 = customerRepository.findById(2);

        Assertions.assertEquals(customer.getId() , customer1.get().getId());
    }

}
