package com.opencart.demo.pages;

public class WelcomePage extends BasePage {

    public String getTitleName() {
       return getDriver().getTitle();
    }
}
