package io.github.bapadua.getnet.controllers;

import io.github.bapadua.getnet.domain.cards.CardDTO;
import io.github.bapadua.getnet.domain.cards.CardTokenDTO;
import io.github.bapadua.getnet.services.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardTokenDTO> tokenize(final @RequestBody CardDTO card) {
        log.info("tokenizando cartão: {}", card.getCardNumber().substring(0, 4));
        return ResponseEntity.ok(cardService.tokenize(card));
    }

}
