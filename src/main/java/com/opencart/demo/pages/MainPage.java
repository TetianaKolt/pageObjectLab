package com.opencart.demo.pages;

import com.opencart.demo.components.TopMenuComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MainPage extends BasePage {
    private final By mainPageTopMenuContainerLocator = By.id("top");
    private final By registerButton = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right show']//a[@class='dropdown-item' and text()='Register']");
    private final By brandsLocator = By.xpath("//li/a[contains(text(),'Brands')]");
    private final By desktopButtonLocator = By.xpath("//li/a[contains(text(),'Desktops')]/parent::li");
    private final By dropDownListSeeAllDesktopsLocator = By.xpath("//div[@class='dropdown-menu show']//a[@class='see-all']");


    public TopMenuComponents getTopMenu() {
        return new TopMenuComponents(getDriver().findElement(mainPageTopMenuContainerLocator));
    }

    public Actions getActions() {
        return new Actions(getDriver());
    }



    public MainPage clickMyAccountIcon() {
        getTopMenu().getMyAccountButton().click();
        return this;
    }

    public AccountRegisterPage clickRegisterButton() {
        getTopMenu().getMyAccountButton().findElement(registerButton).click();
        return new AccountRegisterPage();
    }

    public MainPage goToTheFooter() {
        scroll(900);
        return this;
    }

    public BrandsPage clickBrands() {
        waitUntilClickable(brandsLocator, 6);
        getDriver().findElement(brandsLocator).click();
        return new BrandsPage();
    }

    public MainPage hoverOverDesktops() {
        WebElement deskTopButton = getDriver().findElement(desktopButtonLocator);
        getActions().moveToElement(deskTopButton).build().perform();
        deskTopButton.click();
        return this;
    }

    public DesktopsPage clickOnShowAllDesktops() {
        WebElement dropDownListDesktops = getDriver().findElement(dropDownListSeeAllDesktopsLocator);
        waitUntilVisible(dropDownListSeeAllDesktopsLocator, 3);
        dropDownListDesktops.click();
        return new DesktopsPage();

    }

}
