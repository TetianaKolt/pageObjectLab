package framework.pages;

import framework.components.Products;
import framework.enums.SortBy;
import framework.helper.Helpers;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class DesktopsPage extends BasePage {
    private final By showingOnTheBottomTextLocator = By.xpath("//div[contains(text(),'Showing')]");
    private final By productContainerLocator = By.xpath("//div[@class='product-thumb']");
    private final By showQuantityContainerLocator = By.id("input-limit");
    private final By sortByContainerLocator = By.id("input-sort");

    // SORT BY DROPDOWN
    //// Check the value in the "Sort By" dropdown by default
    @Step("Get value by default from [sort by] dropdown list")
    public String getValueFromSortByOption() {
        Select select = new Select(find(sortByContainerLocator));
        return select.getFirstSelectedOption().getText();
    }

    //// Change the value in the "Sort By" dropdown
    @Step("Change the value in the [Sort By] dropdown")
    public DesktopsPage chooseSortByOption(SortBy value) {
        log.info("Choose [Sort by] value as {}", value);
        Select select = new Select(find(sortByContainerLocator));
        select.selectByVisibleText(value.getValueName());
        return this;
    }

    // SHOW DROPDOWN
    //// Check the value in the "Show" dropdown by default
    @Step("Get value by default from [Show] dropdown list")
    public String getValueFromShowQuantityOption() {
        Select select = new Select(find(showQuantityContainerLocator));
        return select.getFirstSelectedOption().getText();
    }

    //// Change the value in the "Show" dropdown
    @Step("Choose quantity in [Show]")
    public DesktopsPage chooseShowQuantityOption(String value) {
        log.info("Choose [Show] value as {}", value);
        Select select = new Select(find(showQuantityContainerLocator));
        select.selectByVisibleText(value);
        return this;
    }

    // PRODUCTS LIST
    //// Get ALL products as list of Products
    @Step("Get all products from the page")
    public List<Products> getAllProducts() {
        log.info("Get all products");
        List<Products> products = new ArrayList<>();
        Helpers.scrollToElement(findAll(productContainerLocator).get(0));
        List<WebElement> containers = findAll(productContainerLocator);
        for (WebElement container : containers) {
            Products desktopComponents = new Products(container);
            products.add(desktopComponents);
        }
        return products;
    }

    // GET THE TEXT ON THE BOTTOM OF THE PAGE (e.g. "Showing 1 to 12 of 12 (1 Pages)")
    @Step("Get the text [Showing...] on the bottom")
    public String getTextShownOnTheBottom() {
        Helpers.scrollToElement(find(showingOnTheBottomTextLocator));
        log.info("Get the text [Showing...] on the bottom");
        return find(showingOnTheBottomTextLocator).getText();
    }
}
