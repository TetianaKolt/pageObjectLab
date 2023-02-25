package framework.components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
public class NavigationBar {

  private final WebElement desktops;
  private final WebElement laptopsAndNotebooks;
  private final WebElement components;
  private final WebElement tablets;
  private final WebElement software;
  private final WebElement phonesAndPDAs;
  private final WebElement cameras;
  private final WebElement MP3players;

  public NavigationBar(WebElement container) {
    this.desktops = container.findElement(
        By.xpath(".//ul[@class='nav navbar-nav']/li/a[contains(text(),'Desktops')]"));
    this.laptopsAndNotebooks = container.findElement(
        By.xpath(".//ul[@class='nav navbar-nav']/li/a[contains(text(),'Laptops & Notebooks')]"));
    this.components = container.findElement(
        By.xpath(".//ul[@class='nav navbar-nav']/li/a[contains(text(),'Components')]"));
    this.tablets = container.findElement(
        By.xpath(".//ul[@class='nav navbar-nav']/li/a[contains(text(),'Tablets')]"));
    this.software = container.findElement(
        By.xpath(".//ul[@class='nav navbar-nav']/li/a[contains(text(),'Software')]"));
    this.phonesAndPDAs = container.findElement(
        By.xpath(".//ul[@class='nav navbar-nav']/li/a[contains(text(),'Phones & PDAs')]"));
    this.cameras = container.findElement(
        By.xpath(".//ul[@class='nav navbar-nav']/li/a[contains(text(),'Cameras')]"));
    this.MP3players = container.findElement(
        By.xpath(".//ul[@class='nav navbar-nav']/li/a[contains(text(),'MP3 Players')]"));
  }
}
