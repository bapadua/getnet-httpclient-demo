package io.github.bapadua.getnet.services;

import io.github.bapadua.getnet.domain.customers.CustomerResponseDTO;

public interface CustomerService {

    CustomerResponseDTO list(String page, String limit);
}
