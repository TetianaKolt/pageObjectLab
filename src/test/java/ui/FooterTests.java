package ui;

import com.opencart.demo.pages.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

public class FooterTests extends BaseTest {

    @Test
    public void testLabelsPresent() {
        MainPage mainPage = new MainPage();
        List<String> expectedBrandsToSee = Arrays.asList("Apple","Canon","Hewlett-Packard","HTC","Palm","Sony");

       List<String> actualNames = mainPage.goToTheFooter()
               .clickBrands()
               .findAllBrandsNames();

        Assertions.assertThat(actualNames)
                .as("List of brands differs from expected").containsAll(expectedBrandsToSee);

    }
}
