package com.opencart.demo.enums;

import lombok.Getter;

@Getter
public enum SortBy {
    DEFAULT("Default"),
    NAME_A_Z("Name (A - Z)"),
    NAME_Z_A("Name (Z - A)"),
    PRICE_LOW_HIGH("Price (Low > High)"),
    PRICE_HIGH_LOW("Price (High > Low)"),
    RATING_HIGHEST("Rating (Highest)"),
    RATING_LOWEST("Rating (Lowest)"),
    MODEL_A_Z("Model (A - Z)"),
    MODEL_Z_A("Model (Z - A)");

    private final String valueName;

    SortBy(String valueName) {
    this.valueName=valueName;
    }
}
