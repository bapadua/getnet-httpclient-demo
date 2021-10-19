package io.github.bapadua.getnet.controllers;

import io.github.bapadua.getnet.config.OAuthToken;
import io.github.bapadua.getnet.domain.request.GetnetToken;
import io.github.bapadua.getnet.http.clients.GetNetClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    OAuthToken token;

    @GetMapping
    public ResponseEntity<GetnetToken> test() {

//        return ResponseEntity.ok(client.oauthToken(basic));
        return ResponseEntity.ok(token.getToken());
    }
}
