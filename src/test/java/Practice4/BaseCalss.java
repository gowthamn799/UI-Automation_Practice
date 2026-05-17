package Practice4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseCalss extends FileReader{
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--headless=new");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notification");
        driver=new ChromeDriver(options);
        driver.navigate().to(configReader("Url"));
        driver.manage().deleteAllCookies();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
