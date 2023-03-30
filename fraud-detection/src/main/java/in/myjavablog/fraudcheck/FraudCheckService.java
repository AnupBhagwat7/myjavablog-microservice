package in.myjavablog.fraudcheck;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private FraudCheckRepository fraudCheckRepository;

    public boolean  checkFraudCustomer(Integer customerId) {

        FraudCheck fraudCheck = fraudCheckRepository.save(FraudCheck.builder()
                .customerId(customerId)
                .isFraudCustomer(false)
                .created(LocalDateTime.now())
                .build());

        return false;
        //TODO - Fraud check logic
    }
}
