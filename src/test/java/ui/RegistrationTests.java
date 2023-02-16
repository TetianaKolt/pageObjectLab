package ui;

import com.opencart.demo.helper.FakeStringsHelper;
import com.opencart.demo.pages.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static com.opencart.demo.helper.FakeStringsHelper.*;

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
                        .clickContinuePass()
                        .isRedirectedToWelcomePage()
                        .getTitleName();

        Assertions.assertThat(actualMessage)
                .as("You are not redirected to Welcome page")
                .isEqualTo("Welcome");

    }
}
