package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage {

    public WebDriver driver;

    By signin = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");
    By title=By.cssSelector(".text-center>h2");
    By headerNavBar =By.className("navbar-right");

    //By links=By.tagName("a");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLogin() {
        driver.findElement(signin).click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public List<WebElement> getAllLinks() {

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        return allLinks;
    }



    public WebElement getHeader_css_Contact(){
        return driver.findElement(headerNavBar);
    }
}
