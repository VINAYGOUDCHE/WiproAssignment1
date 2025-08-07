package com.springlabs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExternalServiceApplication {

    private int failureCount = 0;

    public static void main(String[] args) {
        SpringApplication.run(ExternalServiceApplication.class, args);
    }

    @GetMapping("/delivery/status")
    public String getStatus() {
        // This simulates a failing service.
        // It fails for the first 3 calls to open the circuit breaker.
        if (failureCount < 3) {
            failureCount++;
            throw new RuntimeException("Simulating external service failure.");
        }
        return "Delivery status: Your package is on its way!";
    }
}