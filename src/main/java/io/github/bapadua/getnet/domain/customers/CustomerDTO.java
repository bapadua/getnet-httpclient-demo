package io.github.bapadua.getnet.domain.customers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO implements Serializable {

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("document_type")
    private String documentType;

    @JsonProperty("document_number")
    private String documentNumber;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("celphone_number")
    private String cellphoneNumber;

    private String email;
}
