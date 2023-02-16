package com.opencart.demo.pages;

import org.openqa.selenium.By;

public class WelcomePage extends BasePage {

    public String getTitleName() {
       return getDriver().getTitle();
    }
}
