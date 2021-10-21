package io.github.bapadua.getnet.controllers;

import io.github.bapadua.getnet.domain.CustomerRequestDTO;
import io.github.bapadua.getnet.domain.customers.CustomerResponseDTO;
import io.github.bapadua.getnet.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerRequestDTO> saveCustomer(@RequestBody CustomerRequestDTO customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping
    public ResponseEntity<CustomerResponseDTO> listCustomers(
            @RequestParam(value = "page", defaultValue = "1") String page,
            @RequestParam(value = "limit", defaultValue = "10") String limit
    ) {
        return ResponseEntity.ok(customerService.list(page, limit));
    }
}
