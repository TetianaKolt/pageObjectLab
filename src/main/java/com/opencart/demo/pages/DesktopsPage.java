package com.opencart.demo.pages;

import com.opencart.demo.components.DesktopComponents;
import com.opencart.demo.enums.SortBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DesktopsPage extends BasePage {

    private final By showingOnTheBottomTextLocator = By.xpath("//div[contains(text(),'Showing')]");
    private final By productContainerLocator = By.xpath("//div[@class='product-thumb']");
    private final By showQnttContainerLocator = By.id("input-limit");
    private final By sortByContainerLocator = By.id("input-sort");

    // SORT BY DROPDOWN
    //// Check the value in the "Sort By" dropdown by default
    public String getValueFromSortByOption() {
        Select select = new Select(getDriver().findElement(sortByContainerLocator));
        return select.getFirstSelectedOption().getText();
    }

    //// Change the value in the "Sort By" dropdown
    public DesktopsPage chooseSortByOption(SortBy value) {
        Select select = new Select(getDriver().findElement(sortByContainerLocator));
        select.selectByVisibleText(value.getValueName());
        return this;
    }

    // SHOW DROPDOWN
    //// Check the value in the "Show" dropdown by default
    public String getValueFromShowQnttOption() {
        Select select = new Select(getDriver().findElement(showQnttContainerLocator));
        return select.getFirstSelectedOption().getText();
    }

    //// Change the value in the "Show" dropdown
    public DesktopsPage chooseShowQnttOption(String value) {
        Select select = new Select(getDriver().findElement(showQnttContainerLocator));
        select.selectByVisibleText(value);
        return this;
    }

    // PRODUCTS LIST
    //// Get ALL products as list of DesktopComponents
    public List<DesktopComponents> getAllProducts() {
        List<DesktopComponents> products = new ArrayList<>();
        scroll(1000);
        List<WebElement> containers = findAll(productContainerLocator);
        for (WebElement container : containers) {
            DesktopComponents desktopComponents = new DesktopComponents(container);
            products.add(desktopComponents);
        }
        return products;
    }

    // GET THE TEXT ON THE BOTTOM OF THE PAGE (e.g. "Showing 1 to 12 of 12 (1 Pages)")
    public String getTextShownOnTheBottom() {
        scroll(8000);
        return getDriver().findElement(showingOnTheBottomTextLocator).getText();
    }



}
