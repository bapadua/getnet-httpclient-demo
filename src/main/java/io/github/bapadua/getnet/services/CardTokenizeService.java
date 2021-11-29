package io.github.bapadua.getnet.services;

import io.github.bapadua.getnet.domain.cards.CardDTO;
import io.github.bapadua.getnet.domain.cards.CardTokenDTO;

public interface CardTokenizeService {

    CardTokenDTO tokenize(CardDTO card);
}
