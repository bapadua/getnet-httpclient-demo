package io.github.bapadua.getnet.controllers;

import io.github.bapadua.getnet.config.OAuthToken;
import io.github.bapadua.getnet.domain.CustomerRequestDTO;
import io.github.bapadua.getnet.factory.ScenarioFactory;
import io.github.bapadua.getnet.services.impl.CustomerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Mock
    OAuthToken oAuthToken;

    CustomerServiceImpl customerService;

    @Autowired
    MockMvc mockMvc;

//    @Test
//    @DisplayName("Deve gravar um usuario")
//    public void shouldSaveAnCustomer() throws Exception {
//
//        CustomerRequestDTO request = ScenarioFactory.validCustomerRequest();
//        String requestJson = ScenarioFactory.validCustomerRequestJson();
//
//        mockMvc.perform(post("/api/v1/customer")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestJson))
//                .andExpect(status().isOk());
//
//        verify(customerService).save(any());
//    }

}