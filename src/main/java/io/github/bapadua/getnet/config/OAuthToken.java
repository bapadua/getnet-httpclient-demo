package io.github.bapadua.getnet.config;

import io.github.bapadua.getnet.domain.request.GetnetToken;
import io.github.bapadua.getnet.http.clients.GetNetClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Base64;

@Slf4j
@Configuration
@RequiredArgsConstructor
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@EnableCaching
@EnableScheduling
public class OAuthToken {

    private final int EXPIRE_TIME = 1000 * 60 * 60;

    @Value("${getnet.oauth.client-id}")
    private String clientId;
    @Value("${getnet.oauth.client-secret}")
    private String clientSecret;
    @Value("${getnet.oauth.seller-id}")
    private String sellerId;

    private final GetNetClient client;

    public String accessToken() {
        return String.format("Bearer %s", token().getToken());
    }

    public String sellerId() {
        return token().getSellerId();
    }

    @Cacheable("token")
    public GetnetToken token() {
        log.info("Authenticating on Getnet");
        return setExpire(client.oauthToken(getBasic(clientId, clientSecret)));
    }

    @CacheEvict(allEntries = true, cacheNames = {"token"})
    @Scheduled(fixedRate = EXPIRE_TIME)
    public void cacheEvict() {
        log.info("Removing expired token");
    }

    private GetnetToken setExpire(final GetnetToken token) {
        return GetnetToken.builder()
                .expire(token.getExpire())
                .expireAt(LocalDateTime.now().plusSeconds(token.getExpire()))
                .token(token.getToken())
                .sellerId(sellerId)
                .build();
    }

    String getBasic(final String clientId, final String clientSecret) {
        return String.format("Basic %s", Base64
                .getEncoder()
                .encodeToString(String.format("%s:%s", clientId, clientSecret).getBytes()));
    }

}
