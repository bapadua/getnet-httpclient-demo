package io.github.bapadua.getnet.domain.cards;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO implements Serializable {

    @JsonProperty("card_number")
    private String cardNumber;
    
}
