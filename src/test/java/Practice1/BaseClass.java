package Practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--headless=new");
        options.addArguments("--disabled-notification");
        driver=new ChromeDriver(options);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
