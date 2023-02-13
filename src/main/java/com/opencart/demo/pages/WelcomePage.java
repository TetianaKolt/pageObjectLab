package com.opencart.demo.pages;

import org.openqa.selenium.By;

public class WelcomePage extends BasePage {
    private final By titleNameLocator = By.xpath("//title");

    public String getTitleName() {
        if (find(titleNameLocator).getText().contains("Welcome")) {
            return find(titleNameLocator).getAttribute("title");
        }
        return null;
    }
}
