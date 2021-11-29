package io.github.bapadua.getnet.services;

import io.github.bapadua.getnet.domain.VaultStoreCardRequest;
import io.github.bapadua.getnet.domain.VaultStoreCardResponse;

public interface CardVaultService {
    VaultStoreCardResponse saveCard(VaultStoreCardRequest card);
}
