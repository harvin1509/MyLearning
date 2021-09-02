package academy;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


public class HomePageTest extends base {
//Need to call methods written in Base class, we will use Inheritance

    public WebDriver driver;
    LandingPage lp;
    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();

    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String Username, String Password) throws IOException {

        driver.get(properties.getProperty("url"));
        // Creating object to that class and invoke methods of it

        lp = new LandingPage(driver);

        LoginPage loginPage = lp.getLogin();
        loginPage.getEmail().sendKeys(Username);
        loginPage.getPassword().sendKeys(Password);

        loginPage.Submit().click();

    }
    @AfterTest
    public void teardown(){
        driver.close();
    }

    @DataProvider
    public Object[][] getData() {
        // rows stands for how many different data types test should run
        // column stands for how many values per each test
        Object[][] data = new Object[2][2];
        // 0th row
        data[0][0] = "haru@gmail.com";
        data[0][1] = "password";
        // 1st row
        data[1][0] = "bhupi@gmail.com";
        data[1][1] = "bhupi";

        return data;
    }



}
