package framework.enums;

import lombok.Getter;

@Getter
public enum CurrencyListEnums {
    EURO("€ Euro"),
    US_DOLLAR("$ US Dollar"),
    POUND_STERLING("£ Pound Sterling");

    private final String currency;
    CurrencyListEnums(String currency) {
        this.currency = currency;
    }
}
