package com.opencart.demo.pages;

import org.openqa.selenium.By;

public class AccountRegisterPage extends BasePage {

    private final By firstNameLocator = By.id("input-firstname");
    private final By lastNameLocator = By.id("input-lastname");
    private final By emailLocator = By.id("input-email");
    private final By passwordLocator = By.id("input-password");
    private final By privacyPolicyCheckboxLocator = By.xpath("//input[@type='checkbox']");
    private final By continueButtonLocator = By.xpath("//button[@type='submit']");


    public AccountRegisterPage enterFirstName(String firstName) {
        getDriver().findElement(firstNameLocator).sendKeys(firstName);
        return this;
    }

    public AccountRegisterPage enterLastName(String lastName) {
        getDriver().findElement(lastNameLocator).sendKeys(lastName);
        return this;
    }

    public AccountRegisterPage enterEmail(String email) {
        getDriver().findElement(emailLocator).sendKeys(email);
        return this;
    }

    public AccountRegisterPage enterPassword(String password) {
        getDriver().findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public AccountRegisterPage agreeWithPrivacyPolicy() {
        scroll(2000);
        waitUntilClickable(privacyPolicyCheckboxLocator, 3);
        find(privacyPolicyCheckboxLocator).click();
        return this;
    }

    public AccountRegisterPage clickContinueFail() {
        find(continueButtonLocator).click();
        return this;
    }

    public AccountRegisterPage clickContinuePass() {
        find(continueButtonLocator).click();
        return this;
    }

    public WelcomePage isRedirectedToWelcomePage() {
        return new WelcomePage();
    }
}
