package academy;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


public class ValidateTitleTest extends base {
    public WebDriver driver; //assigned to local copy so that test run in sequential mode also
    LandingPage lp;
    public static Logger log= LogManager.getLogger(ValidateTitleTest.class);
    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

        driver.get(properties.getProperty("url"));
        log.info("Navigated to Home Page");

    }

    @Test
    public void basePageNavigation() throws IOException {

        //comparing the title
        lp=new LandingPage(driver);
        Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
        log.info("Successfully validated text message");
    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
}
