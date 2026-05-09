package Practice3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class SeleniumActions extends FileReader{

    WebDriver driver;
    WebDriverWait wait;
    String parentWindow;

    public SeleniumActions(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void Click(By locator){
        WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));
        ele.click();
    }
    public void sendData(By locator,String data){
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ele.clear();
        ele.click();
        ele.sendKeys(data);
    }
    public String getText(By locator){
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return ele.getText();
    }
    public void checkBox(By locator){
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (!ele.isSelected()){
            ele.click();
        }
    }
    public void dropDown(By locator,String text){
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select sel=new Select(ele);
        sel.selectByVisibleText(text);
    }
    public void mouseHover(By locator){
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Actions actions=new Actions(driver);
        actions.moveToElement(ele).perform();
    }
    public void SwitchToChildWindow(){
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        parentWindow=driver.getWindowHandle();
        for (String child:driver.getWindowHandles()){
            if (!child.equals(parentWindow)){
                driver.switchTo().window(child);
            }
        }
    }
    public void SwitchToParentWindow(){
        driver.switchTo().window(parentWindow);
    }
    public void SwitchToFrmae(By locator){
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.switchTo().frame(ele);
    }
    public void SwitchToMainFrame(){
        driver.switchTo().defaultContent();
    }
}

