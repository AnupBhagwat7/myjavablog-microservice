package in.myjavablog.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {

    @Id
    @SequenceGenerator(
            name = "cust_id_sequence",
            sequenceName = "cust_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cust_id_sequence"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
