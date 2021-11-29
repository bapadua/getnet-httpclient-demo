package io.github.bapadua.getnet.http.clients;


import feign.Headers;
import io.github.bapadua.getnet.domain.VaultStoreCardRequest;
import io.github.bapadua.getnet.domain.VaultStoreCardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(url = "${getnet.endpoint}", name = "getnetcards")
public interface GetnetCard {

    @PostMapping(value = "/v1/cards",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    @Headers({"Content-Type: application/json", "Accept-Encoding: gzip"})
    VaultStoreCardResponse save(
            @RequestHeader("Authorization") String token,
            @RequestBody VaultStoreCardRequest card);

}