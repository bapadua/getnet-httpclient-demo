package io.github.bapadua.getnet.services.impl;

import io.github.bapadua.getnet.config.OAuthToken;
import io.github.bapadua.getnet.domain.cards.CardDTO;
import io.github.bapadua.getnet.domain.cards.CardTokenDTO;
import io.github.bapadua.getnet.http.clients.GetNetCardsClient;
import io.github.bapadua.getnet.services.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final OAuthToken oAuthToken;
    private final GetNetCardsClient client;

    @Override
    public CardTokenDTO tokenize(final CardDTO card) {
        return client.tokenize(oAuthToken.accessToken(), card);
    }
}
