package com.springlabs.lab11;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/springrest")
public class CustomerController {

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return Arrays.asList(
            new Customer(101, "John", "Doe", "jdjohn@gmail.com", "121-232-3435", 1467240235069L),
            new Customer(201, "Russ", "Smith", "russ@gmail.com", "343-545-2345", 1467240235069L),
            new Customer(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987", 1467240235069L)
        );
    }
}