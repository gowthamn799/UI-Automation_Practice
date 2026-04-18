package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass extends FileReader {

    public static WebDriver driver;
    @BeforeTest
    public void setUp(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("--headless=new");
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver(options);
        driver.navigate().to(configReader("Url"));
        driver.manage().deleteAllCookies();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
