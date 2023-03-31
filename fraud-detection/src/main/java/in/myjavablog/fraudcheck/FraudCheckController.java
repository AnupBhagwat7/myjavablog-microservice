package in.myjavablog.fraudcheck;

import in.myjavablog.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/fraudcheck")
@AllArgsConstructor
public class FraudCheckController {

    private FraudCheckService fraudCheckService;

    @GetMapping("{customerId}")
    public FraudCheckResponse checkFraudCustomer(@PathVariable(value = "customerId") Integer customerId) {

        boolean fraudCheckResponse = fraudCheckService.checkFraudCustomer(customerId);
        return new FraudCheckResponse(fraudCheckResponse);
    }
}
