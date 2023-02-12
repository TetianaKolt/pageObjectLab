package ui;

import com.opencart.demo.pages.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {
    private String firstName = "Jane";
    private String lastName = "Doe";
    private String pass = "1234janeDoe";
    private String email = "forspam.jane.doe@gmail.com";


    @Test //Test #1
    public void checkIfRedirectedToWelcomePage() {

        MainPage mainPage = new MainPage();

        String actualMessage =
                mainPage.clickMyAccountIcon()
                        .clickRegisterButton()
                        .enterFirstName(firstName)
                        .enterLastName(lastName)
                        .enterEmail(email)
                        .enterPassword(pass)
                        .agreeWithPrivacyPolicy()
                        .clickContinuePass()
                        .isRedirectedToWelcomePage()
                        .getTitleName();

        Assertions.assertThat(actualMessage)
                .as("You are not redirected to Welcome page").isNotNull();

    }
}
