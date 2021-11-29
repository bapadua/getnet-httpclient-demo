package io.github.bapadua.getnet.http.clients;


import feign.Headers;
import io.github.bapadua.getnet.domain.cards.CardDTO;
import io.github.bapadua.getnet.domain.cards.CardTokenDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(url = "${getnet.endpoint}", name = "getnettokenizer")
public interface GetnetCardTokenizer {

    @PostMapping(value = "/v1/tokens/card",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    @Headers({"Content-Type: application/json", "Accept-Encoding: gzip"})
    CardTokenDTO tokenize(
            @RequestHeader("Authorization") String token,
            @RequestBody CardDTO card);

}