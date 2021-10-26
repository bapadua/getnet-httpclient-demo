package io.github.bapadua.getnet.services;

import io.github.bapadua.getnet.domain.cards.CardDTO;
import io.github.bapadua.getnet.domain.cards.CardTokenDTO;

public interface CardService {
    CardTokenDTO tokenize(CardDTO card);
}
