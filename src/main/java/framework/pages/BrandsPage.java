package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Log4j2
public class BrandsPage extends BasePage {
    private final By brandsListLocator = By.xpath("//div[@id='product-manufacturer']//div[@class='col-sm-3']//a");

//    @Step ("Find all [BRANDS]]")
    public List<String> findAllBrandsNames() {
        List<String> actualBrandsList = new ArrayList<>();
        waitUntilClickable(brandsListLocator, 3);
//        log.info("Get list of [all brands]");
        List<WebElement> brands = findAll(brandsListLocator);

        for (WebElement el : brands) {
            actualBrandsList.add(el.getText());
        }
//        log.info("Sort all brands in [ascending order]");
//        Collections.sort(actualBrandsList);
        return actualBrandsList;
    }

}
