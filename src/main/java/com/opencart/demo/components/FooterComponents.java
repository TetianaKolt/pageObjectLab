package com.opencart.demo.components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class FooterComponents {
    private final List<WebElement> informationList;
    private final List<WebElement> customerServiceList;
    private final List<WebElement> extrasList;
    private final List<WebElement> myAccountList;

    public FooterComponents(WebElement container) {
        this.informationList = container.findElements(By.xpath(".//div[@class='col-sm-3'][1]/ul[@class='list-unstyled']"));
        this.customerServiceList = container.findElements(By.xpath(".//div[@class='col-sm-3'][2]/ul[@class='list-unstyled']"));
        this.extrasList = container.findElements(By.xpath(".//div[@class='col-sm-3'][3]/ul[@class='list-unstyled']"));
        this.myAccountList = container.findElements(By.xpath(".//div[@class='col-sm-3'][4]/ul[@class='list-unstyled']"));
    }
}
