package academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

import java.io.IOException;
import java.util.List;

public class ValidateNavigationBarTest extends base {
    public WebDriver driver;
    LandingPage lp;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        lp = new LandingPage(driver);
    }

    @Test
    public void printAllLinksTitle() throws IOException {

        List<WebElement> allLinks = lp.getAllLinks();
        for (int i = 0; i < allLinks.size(); i++) {
            System.out.println(allLinks.get(i).getText());
        }
    }

    @Test
    public void printAllHeaderLinksTitle() throws IOException {

        System.out.println(lp.getHeader_css_Contact().getText());

    }

    @Test
    public void is_Contact_Present_NavigationBar() throws IOException {

        System.out.println(lp.getHeader_css_Contact().getText());
        Assert.assertTrue(lp.getHeader_css_Contact().isDisplayed());


    }
    @AfterTest
    public void teardown(){
        driver.close();
    }

}
