package in.myjavablog.fraudcheck;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<FraudCheckResponse> checkFraudCustomer(@PathVariable Integer customerId){

        return ResponseEntity.ok(fraudCheckService.checkFraudCustomer(customerId));
    }
}
