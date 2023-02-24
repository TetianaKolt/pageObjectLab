package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public abstract class BasePage {

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }


    protected WebElement find(By locator) {
        return getDriver().findElement(locator);
    }
    public static List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    public void clickOnWebElement(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", webElement);
    }

    public void hoverOverElement(By locator) {
        WebElement element = find(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    protected WebElement waitUntilClickable(By locator, int seconds) {
        return new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitUntilVisible(By locator, int seconds) {
        return new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected WebElement waitUntilEnabled(By locator,By childLocator, int seconds) {
        return new WebDriverWait(getDriver(),3).until(ExpectedConditions.presenceOfNestedElementLocatedBy(locator,childLocator));
    }
    protected WebElement waitUntilPresent (By locator, int seconds) {
        return new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitUntilPageIsLoaded(){
        ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete");
    }



}
