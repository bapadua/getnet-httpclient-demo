package io.github.bapadua.getnet.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransactionEnum {
    FULL("A vista");

    private String description;

}
