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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRequestDTO implements Serializable {

    @NotBlank(message = "Informe o id do vendedor")
    @JsonProperty("seller_id")
    private String sellerId;

    @NotBlank(message = "Informe o id do cliente")
    @JsonProperty("customer_id")
    @Size(min = 5, message = "O customer id é invalido")
    private String customerId;

    @NotBlank(message = "Informe o primeiro nome")
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank(message = "Informe o sobrenome")
    @JsonProperty("last_name")
    private String lastName;

    @NotBlank(message = "Informe tipo do documento")
    @JsonProperty("document_type")
    private String documentType;

    @NotBlank(message = "Informe numero")
    @JsonProperty("document_number")
    private String documentNumber;

    @NotNull(message = "Informe a data de nascimento")
    @JsonProperty("birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthDate;

    @NotBlank(message = "Informe o telefone")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotBlank(message = "Informe o celular")
    @JsonProperty("celphone_number")
    private String cellphoneNumber;

    @NotBlank(message = "Informe o email")
    private String email;

    private String observation;

    private transient CustomerAddressDTO address;

}
