package com.opencart.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BrandsPage extends BasePage {
    private final By brandsListLocator = By.xpath("//div[@id='product-manufacturer']//div[@class='col-sm-3']//a");

    public List<String> findAllBrandsNames() {
        List<String> actualBrandsList = new ArrayList<>();
        waitUntilClickable(brandsListLocator, 3);

        List<WebElement> brands = getDriver().findElements(brandsListLocator);

        for (WebElement el : brands) {
            actualBrandsList.add(el.getText());
        }

        Collections.sort(actualBrandsList);
        return actualBrandsList;
    }

}
