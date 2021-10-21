package io.github.bapadua.getnet.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressDTO implements Serializable {

    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;
    @NotBlank(message = "informe o CEP")
    @JsonProperty("postal_code")
    private String postalCode;

}
