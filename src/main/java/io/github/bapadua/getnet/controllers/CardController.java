package io.github.bapadua.getnet.controllers;

import io.github.bapadua.getnet.domain.VaultStoreCardResponse;
import io.github.bapadua.getnet.domain.request.CustomerCardRequest;
import io.github.bapadua.getnet.services.VaultService;
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

    private final VaultService service;

    @PostMapping
    public ResponseEntity<VaultStoreCardResponse> save(@RequestBody CustomerCardRequest request) {
        return ResponseEntity.ok(service.save(request));
    }
}
