package ui;

import static framework.helper.FakeStringsHelper.generateFakeEmail;
import static framework.helper.FakeStringsHelper.generateFakeFirstName;
import static framework.helper.FakeStringsHelper.generateFakeLastName;
import static framework.helper.FakeStringsHelper.generateFakePassword;

import framework.pages.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test //Test #1
  public void checkIfRedirectedToWelcomePage() {
    String actualMessage =
        mainPage.clickMyAccountIcon()
            .clickRegisterButton()
            .enterFirstName(generateFakeFirstName())
            .enterLastName(generateFakeLastName())
            .enterEmail(generateFakeEmail())
            .enterPassword(generateFakePassword())
            .agreeWithPrivacyPolicy()
            .clickContinue()
            .getTitleName();

    Assertions.assertThat(actualMessage)
        .as("You are not redirected to Welcome page")
        .isEqualTo("Welcome");

  }
}
