package ui;

import com.opencart.demo.pages.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class FooterTests extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test //Test #0
    public void testLabelsPresent() {
        List<String> expectedBrandsToSee = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm", "Sony");

        List<String> actualNames = mainPage.goToTheFooter()
                .clickBrands()
                .findAllBrandsNames();

        Assertions.assertThat(actualNames)
                .as("List of brands differs from expected")
                .containsExactlyElementsOf(expectedBrandsToSee);
    }
}
