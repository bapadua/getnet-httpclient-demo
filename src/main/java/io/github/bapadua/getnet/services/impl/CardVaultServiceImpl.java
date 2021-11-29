package io.github.bapadua.getnet.services.impl;


import io.github.bapadua.getnet.config.OAuthToken;
import io.github.bapadua.getnet.domain.VaultStoreCardRequest;
import io.github.bapadua.getnet.domain.VaultStoreCardResponse;
import io.github.bapadua.getnet.http.clients.GetnetCard;
import io.github.bapadua.getnet.services.CardVaultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardVaultServiceImpl implements CardVaultService {

    private final OAuthToken oAuthToken;
    private final GetnetCard client;

    @Override
    public VaultStoreCardResponse saveCard(final VaultStoreCardRequest card) {
        return client.save(oAuthToken.accessToken(), card);
    }
}
