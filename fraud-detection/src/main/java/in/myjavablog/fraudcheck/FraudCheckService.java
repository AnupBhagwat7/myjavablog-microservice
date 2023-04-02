package in.myjavablog.fraudcheck;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class FraudCheckService {

    private FraudCheckRepository fraudCheckRepository;

    public boolean  checkFraudCustomer(Integer customerId) {

        FraudCheck fraudCheck = fraudCheckRepository.save(FraudCheck.builder()
                .customerId(customerId)
                .isFraudCustomer(false)
                .created(LocalDateTime.now())
                .build());

        log.info("Fraud check result for customer {} ", customerId +" is {} ", fraudCheck.getIsFraudCustomer());
        return false;
        //TODO - Fraud check logic
    }
}
