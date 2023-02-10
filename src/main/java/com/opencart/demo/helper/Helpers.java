package com.opencart.demo.helper;

import com.opencart.demo.components.DesktopComponents;

import java.util.List;

public class Helpers {

    public void sortProductList(List<String> actualProductsNamesList, List<DesktopComponents> actualProductsList) {
        for (DesktopComponents dc : actualProductsList) {
            actualProductsNamesList.add(dc.getProductName().toLowerCase());
        }
    }
}
