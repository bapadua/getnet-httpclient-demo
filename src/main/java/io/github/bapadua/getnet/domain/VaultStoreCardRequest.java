package io.github.bapadua.getnet.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaultStoreCardRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("number_token")
    private String numberToken;

    @JsonProperty("cardholder_name")
    private String cardHolderName;

    @JsonProperty("expiration_month")
    private String expirationMonth;

    @JsonProperty("expiration_year")
    private String expirationYear;

    @JsonProperty("customer_id")
    private String customerId;
}
