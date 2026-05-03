package Practice2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class BaseClass extends FileReader{

    public WebDriver driver;
    @AfterMethod
    public void setUP(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--headless=new");
        options.addArguments("--disable-notification");
        driver=new ChromeDriver(options);
        driver.navigate().to(configReader("Url"));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
