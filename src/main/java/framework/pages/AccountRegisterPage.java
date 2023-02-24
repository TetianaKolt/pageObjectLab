package framework.pages;

import framework.helper.Helpers;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Log4j2
public class AccountRegisterPage extends BasePage {

    private final By firstNameLocator = By.id("input-firstname");
    private final By lastNameLocator = By.id("input-lastname");
    private final By emailLocator = By.id("input-email");
    private final By passwordLocator = By.id("input-password");
    private final By privacyPolicyCheckboxLocator = By.xpath("//input[@type='checkbox']");
    private final By continueButtonLocator = By.xpath("//button[@type='submit']");


    @Step("Enter first name {firstName}")
    public AccountRegisterPage enterFirstName(String firstName) {
        find(firstNameLocator).sendKeys(firstName);
        return this;
    }

    @Step("Enter first name {lastName}")
    public AccountRegisterPage enterLastName(String lastName) {
        find(lastNameLocator).sendKeys(lastName);
        return this;
    }

    @Step("Enter email {email}")
    public AccountRegisterPage enterEmail(String email) {
        find(emailLocator).sendKeys(email);
        return this;
    }

    @Step("Enter password {password}")
    public AccountRegisterPage enterPassword(String password) {
        find(passwordLocator).sendKeys(password);
        return this;
    }

    @Step("Agree with privacy policy")
    public AccountRegisterPage agreeWithPrivacyPolicy() {
        WebElement checkBoxPrivacyPolicy = find(privacyPolicyCheckboxLocator);
        Helpers.scrollToElement(checkBoxPrivacyPolicy);
        waitUntilVisible(privacyPolicyCheckboxLocator, 5);
        waitUntilClickable(privacyPolicyCheckboxLocator, 6);
        try {
            checkBoxPrivacyPolicy.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            checkBoxPrivacyPolicy.click();
        }
        return this;
    }

    @Step("Click continue button")
    public WelcomePage clickContinue() {
        find(continueButtonLocator).click();
        return new WelcomePage();
    }

}
