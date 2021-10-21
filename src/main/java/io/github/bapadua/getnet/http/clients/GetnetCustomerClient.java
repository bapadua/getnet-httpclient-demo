package io.github.bapadua.getnet.http.clients;


import feign.Headers;
import io.github.bapadua.getnet.domain.CustomerRequestDTO;
import io.github.bapadua.getnet.domain.customers.CustomerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(url = "${getnet.endpoint}", name = "getnetCustomer")
public interface GetnetCustomerClient {

    @PostMapping(value = "/v1/customers", consumes = APPLICATION_FORM_URLENCODED_VALUE)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @ResponseStatus(HttpStatus.OK)
    Object saveCustomer(
            @RequestBody @Valid CustomerRequestDTO request,
            @RequestHeader("Authorization") String token,
            @RequestHeader("seller_id") String sellerId
    );

    @GetMapping(value = "/v1/customers", consumes = APPLICATION_JSON_VALUE)
    @Headers({"Content-Type: application/json"})
    @ResponseStatus(HttpStatus.OK)
    CustomerResponseDTO listCustomers(
            @RequestHeader("Authorization") String token,
            @RequestHeader("seller_id") String sellerId,
            @RequestParam(value = "page", defaultValue = "1") String page,
            @RequestParam(value = "limit", defaultValue = "10") String limit
    );
}