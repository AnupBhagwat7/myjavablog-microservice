package in.myjavablog.customer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void testRegisterCustomer() throws Exception {

        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest("Anup", "Bhagwat", "anup.bhagwat7@gmail.com");

        Mockito.when(customerService.registerCustomer(Mockito.any())).thenReturn(Customer.builder().id(1).firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName()).email(customerRegistrationRequest.getEmail()).build());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customer").contentType(MediaType.APPLICATION_JSON)
                .content("{\r\n" + "\"id\":1,\r\n" + "\"firstName\":\"anup\",\r\n" + "\"lastName\":\"bhagwat\",\r\n" + "\"email\":\"anup.@gmail.com\"\r\n" + "}")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
