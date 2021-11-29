package io.github.bapadua.getnet.services.impl;

import io.github.bapadua.getnet.config.OAuthToken;
import io.github.bapadua.getnet.domain.VaultStoreCardResponse;
import io.github.bapadua.getnet.domain.cards.CardTokenDTO;
import io.github.bapadua.getnet.domain.request.CustomerCardRequest;
import io.github.bapadua.getnet.mappers.CardMapper;
import io.github.bapadua.getnet.services.CardTokenizeService;
import io.github.bapadua.getnet.services.VaultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VaultServiceImpl implements VaultService {

    private final OAuthToken oAuthToken;
    private final CardTokenizeService cardTokenizeService;
    private final CardVaultServiceImpl cardVaultService;
    private final CardMapper mapper;

    @Override
    public VaultStoreCardResponse save(final CustomerCardRequest request) {
        return cardVaultService.saveCard(mapper.toRequest(request, tokenizeCard(request)));
    }

    private CardTokenDTO tokenizeCard(final CustomerCardRequest request) {
        return cardTokenizeService.tokenize(mapper.toDTO(request));
    }
}
