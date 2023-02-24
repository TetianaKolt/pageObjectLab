package framework.pages;

import framework.helper.Helpers;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

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
        log.info("Enter [first name] as [{}]", firstName);
        find(firstNameLocator).sendKeys(firstName);
        return this;
    }

    @Step("Enter last name {lastName}")
    public AccountRegisterPage enterLastName(String lastName) {
        log.info("Enter [last name] as [{}]", lastName);
        find(lastNameLocator).sendKeys(lastName);
        return this;
    }

    @Step("Enter email {email}")
    public AccountRegisterPage enterEmail(String email) {
        log.info("Enter [email] as [{}]", email);
        find(emailLocator).sendKeys(email);
        return this;
    }

    @Step("Enter password {password}")
    public AccountRegisterPage enterPassword(String password) {
        log.info("Enter [password] as [{}]", password);
        find(passwordLocator).sendKeys(password);
        return this;
    }

    @Step("Agree with privacy policy")
    public AccountRegisterPage agreeWithPrivacyPolicy() {
        Helpers.scroll(2000);
        waitUntilClickable(privacyPolicyCheckboxLocator, 4);
        log.info("Tick to [agree with privacy policy]");
        find(privacyPolicyCheckboxLocator).click();
        return this;
    }

    @Step("Click continue button")
    public WelcomePage clickContinue() {
        log.info("Click [continue button]");
        find(continueButtonLocator).click();
        return new WelcomePage();
    }

}
