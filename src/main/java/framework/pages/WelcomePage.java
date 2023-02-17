package framework.pages;

public class WelcomePage extends BasePage {

    public String getTitleName() {
       return getDriver().getTitle();
    }
}
