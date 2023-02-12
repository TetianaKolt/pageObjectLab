package com.opencart.demo.enums;

import lombok.Getter;

@Getter
public enum CurrencyList {
    EURO("€ Euro"),
    US_DOLLAR("$ US Dollar"),
    POUND_STERLING("£ Pound Sterling");

    private final String currency;

    CurrencyList(String currency) {
        this.currency = currency;
    }
}
