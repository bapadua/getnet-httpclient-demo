package io.github.bapadua.getnet.services.impl;

import io.github.bapadua.getnet.config.OAuthToken;
import io.github.bapadua.getnet.domain.cards.CardDTO;
import io.github.bapadua.getnet.domain.cards.CardTokenDTO;
import io.github.bapadua.getnet.http.clients.GetnetCardTokenizer;
import io.github.bapadua.getnet.services.CardTokenizeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardTokenizeServiceImpl implements CardTokenizeService {

    private final OAuthToken oAuthToken;
    private final GetnetCardTokenizer client;

    @Override
    public CardTokenDTO tokenize(final CardDTO card) {
        return client.tokenize(oAuthToken.accessToken(), card);
    }

}
