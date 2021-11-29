package io.github.bapadua.getnet.mappers;

import io.github.bapadua.getnet.domain.VaultStoreCardRequest;
import io.github.bapadua.getnet.domain.cards.CardDTO;
import io.github.bapadua.getnet.domain.cards.CardTokenDTO;
import io.github.bapadua.getnet.domain.request.CustomerCardRequest;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardDTO toDTO(final CustomerCardRequest request) {
        return CardDTO.builder()
                .cardNumber(request.getCardNumber())
                .build();
    }

    public VaultStoreCardRequest toRequest(final CustomerCardRequest request, final CardTokenDTO token) {
        return VaultStoreCardRequest.builder()
                .customerId(request.getCustomerId())
                .cardHolderName(request.getCardHolderName())
                .expirationMonth(request.getExpirationMonth())
                .expirationYear(request.getExpirationYear())
                .numberToken(token.getNumberToken())
                .build();
    }
}
