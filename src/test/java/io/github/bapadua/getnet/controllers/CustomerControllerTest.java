package io.github.bapadua.getnet.controllers;

import io.github.bapadua.getnet.config.OAuthToken;
import io.github.bapadua.getnet.services.impl.CustomerServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


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