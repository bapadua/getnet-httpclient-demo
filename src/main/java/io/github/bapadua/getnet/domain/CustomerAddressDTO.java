package io.github.bapadua.getnet.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressDTO {

    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;
    @JsonProperty("postal_code")
    private String postalCode;

}
