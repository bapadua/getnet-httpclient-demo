package io.github.bapadua.getnet.services.impl;

import io.github.bapadua.getnet.config.OAuthToken;
import io.github.bapadua.getnet.domain.CustomerRequestDTO;
import io.github.bapadua.getnet.domain.customers.CustomerResponseDTO;
import io.github.bapadua.getnet.http.clients.GetnetCustomerClient;
import io.github.bapadua.getnet.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final OAuthToken oAuthToken;
    private final GetnetCustomerClient customerClient;

    @Override
    public CustomerResponseDTO list(final String page, final String limit) {
        return customerClient.listCustomers(oAuthToken.accessToken(), oAuthToken.sellerId(), page, limit);
    }

    @Override
    public CustomerRequestDTO save(CustomerRequestDTO customer) {
        return customerClient.saveCustomer(setSeller(customer), oAuthToken.accessToken(), oAuthToken.sellerId());
    }

    public CustomerRequestDTO setSeller(CustomerRequestDTO customer) {
        customer.setSellerId(oAuthToken.sellerId());
        return customer;
    }
}
