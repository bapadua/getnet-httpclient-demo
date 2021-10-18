package io.github.bapadua.getnet.http.clients;


import feign.Headers;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import io.github.bapadua.getnet.config.CoreFeignConfiguration;
import io.github.bapadua.getnet.domain.request.GetnetToken;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@FeignClient(url = "${getnet.endpoint}", name = "getnet", configuration = CoreFeignConfiguration.class)
public interface GetNetClient {

    @PostMapping(value = "/auth/oauth/v2/token?scope=oob&grant_type=client_credentials", consumes = APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    GetnetToken oauthToken(
            @RequestHeader("Authorization") String basic
    );

    class Configuration {

        @Bean
        Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
            return new SpringFormEncoder(new SpringEncoder(converters));
        }
    }
}