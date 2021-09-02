package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
    public WebDriver driver;
    public Properties properties;

    public WebDriver initializeDriver() throws IOException {

        properties=new Properties();
        FileInputStream fileinputstream=new FileInputStream("src\\main\\java\\resources\\data.properties");

        //my property file is responsible to pull the values from data.proerties, so there is a method to give knowledge and
        //will pass fileinputstream

        properties.load(fileinputstream);
        String browserName=properties.getProperty("browser");
        String url=properties.getProperty("url");

        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();

        }

        else if(browserName.equals("firefox")) {}
        else if(browserName.equals("IE")) {}

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;
    }
}
