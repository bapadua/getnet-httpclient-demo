package io.github.bapadua.getnet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRequestDTO implements Serializable {

    @JsonProperty("seller_id")
    private String sellerId;

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

    @JsonProperty("birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthDate;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("celphone_number")
    private String cellphoneNumber;

    private String email;

    private String observation;

    private CustomerAddressDTO address;

}
