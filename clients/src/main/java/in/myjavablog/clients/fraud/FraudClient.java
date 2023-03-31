package in.myjavablog.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraudcheck")
public interface FraudClient {

    @GetMapping("/api/v1/fraudcheck/{customerId}")
    FraudCheckResponse checkFraudCustomer(@PathVariable(value = "customerId") Integer customerId);

}
