package io.github.bapadua.getnet.services;

import io.github.bapadua.getnet.domain.VaultStoreCardResponse;
import io.github.bapadua.getnet.domain.request.CustomerCardRequest;

public interface VaultService {
    VaultStoreCardResponse save(CustomerCardRequest request);
}
