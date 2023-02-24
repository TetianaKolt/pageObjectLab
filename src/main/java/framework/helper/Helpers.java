package framework.helper;

import com.github.javafaker.Faker;
import framework.components.Products;
import framework.pages.BasePage;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static framework.helper.FakeStringsHelper.generateScreenshotName;

public class Helpers {

    // Gets a list product names
    public static List<String> getNamesFromProductList(List<Products> actualProductsList) {
        List<String> actualProductNamesList = new ArrayList<>();
        for (Products dc : actualProductsList) {
            actualProductNamesList.add(dc.getProductName().toLowerCase());
        }
        return actualProductNamesList;
    }

    // GETS LIST OF STRINGS FROM LIST OF WEB ELEMENTS
    public static List<String> getStringsFromList(List<WebElement> listOfWebElements) {
        List<String> names = new ArrayList<>();
        for (WebElement we : listOfWebElements) {
            names.add(we.getText());
        }
        return names;
    }

    // Gets Prices from List of Web Elements
    public static List<Double> getPricesFromList(List<Products> actualProductsList) {
        List<Double> actualPricesList = new ArrayList<>();
        for (Products dc : actualProductsList) {
            actualPricesList.add(dc.getProductPriceCurrentAsDouble());
        }
        return actualPricesList;
    }


    //Finds product from the list by Name
    public static Products findProductByName(List<Products> listOfProducts, String nameToFind) {
        Products foundProduct = new Products();
        for (Products product : listOfProducts) {
            if (product.getProductName().equalsIgnoreCase(nameToFind)) {
                foundProduct = product;
            }
        }
        return foundProduct;
    }

    // Scroll
    public static void scroll(int pixels) {
        JavascriptExecutor jse = (JavascriptExecutor) BasePage.getDriver();
        jse.executeScript("window.scrollBy(0," + pixels + ")");
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) BasePage.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Make a screenshot
    @SneakyThrows
    public static void makeScreenShot() {
        File scrFile = ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,
                new File("/Users/AIM/IdeaProjects/pageObjectLab/src/test/resources/screenshots"
                        + new Faker().random().hex(10) + ".png"));
    }


    @Attachment(value = "{fileName}", type = "image/png")
    public static byte[] takeScreenShot(String fileName) {
        return ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}