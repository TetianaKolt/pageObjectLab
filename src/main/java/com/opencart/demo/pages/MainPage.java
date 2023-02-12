package com.opencart.demo.pages;

import com.opencart.demo.components.NavigationBar;
import com.opencart.demo.components.Products;
import com.opencart.demo.components.TopMenuComponents;
import com.opencart.demo.enums.CurrencyList;
import com.opencart.demo.helper.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public class MainPage extends BasePage {
    private final By mainPageTopMenuContainerLocator = By.id("top");
    private final By navigationBarLocator = By.id("menu");
    private final By registerButton = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right show']//a[@class='dropdown-item' and text()='Register']");
    private final By brandsLocator = By.xpath("//li/a[contains(text(),'Brands')]");
    private final By desktopButtonLocator = By.xpath("//li/a[contains(text(),'Desktops')]/parent::li");
    private final By dropDownListSeeAllDesktopsLocator = By.xpath("//div[@class='dropdown-menu show']//a[@class='see-all']");
    private final By productContainerLocator = By.xpath("//div[@class='product-thumb']");

    public TopMenuComponents getTopMenu() {
        return new TopMenuComponents(getDriver().findElement(mainPageTopMenuContainerLocator));
    }
    public NavigationBar getNavigationBar() {
        return new NavigationBar(getDriver().findElement(navigationBarLocator));
    }

    public Actions getActions() {
        return new Actions(getDriver());
    }

    // Click "My Account" button
    public MainPage clickMyAccountIcon() {
        getTopMenu().getMyAccountButton().click();
        return this;
    }

    // Click the "Register" button
    public AccountRegisterPage clickRegisterButton() {
        getTopMenu().getMyAccountButton().findElement(registerButton).click();
        return new AccountRegisterPage();
    }

    // Move down to the footer on the MainPage
    public MainPage goToTheFooter() {
        scroll(900);
        return this;
    }

    // Go to the "Brands" page
    public BrandsPage clickBrands() {
        waitUntilClickable(brandsLocator, 6);
        find(brandsLocator).click();
        return new BrandsPage();
    }

    // Hover over "Desctops" to see the dropdown list
    public MainPage hoverOverDesktops() {
        WebElement deskTopButton = find(desktopButtonLocator);
        getActions().moveToElement(deskTopButton).build().perform();
        deskTopButton.click();
        return this;
    }

    // Click "Show all desktops"
    public DesktopsPage clickOnShowAllDesktops() {
        WebElement dropDownListDesktops = find(dropDownListSeeAllDesktopsLocator);
        waitUntilVisible(dropDownListSeeAllDesktopsLocator, 3);
        dropDownListDesktops.click();
        return new DesktopsPage();

    }

    // Check the currency by Default
    public String checkCurrencySymbolChangeIfNot(Enum<CurrencyList> defaultSymbol) {
        String actualSymbol = getTopMenu().getCurrencySymbol();
        if (!actualSymbol.equals(defaultSymbol.name())) {
            getTopMenu().getCurrency().click();
            chooseCurrency(defaultSymbol);
        }
        return actualSymbol;
    }

    // Choose currency in the top menu dropdown list
    public MainPage chooseCurrency(Enum<CurrencyList> currencyEnum) {
        List<WebElement> currencyList = getTopMenu().getCurrencyList();
        for (WebElement cl : currencyList) {
            if (cl.getText().equals(currencyEnum.name())) {
                cl.click();
            }
        }
        return this;
    }

    // PRODUCTS LIST
    //// Get ALL products as list of Products
    public List<Products> getAllProducts() {
        List<Products> products = new ArrayList<>();
        scroll(400);
        List<WebElement> containers = findAll(productContainerLocator);
        for (WebElement container : containers) {
            Products desktopComponents = new Products(container);
            products.add(desktopComponents);
        }
        return products;
    }

    // Find product by name and click
    public ProductPage findProductByNameClick(List<Products> products, String nameToSearch) {
        Products productToCheck = Helpers.findProductByName(products, nameToSearch);
        scroll(900);
        waitUntilPresent(productContainerLocator,4);
        waitUntilClickable(productContainerLocator,4);
        productToCheck.getProductImage().click();
        return new ProductPage();
    }

}
