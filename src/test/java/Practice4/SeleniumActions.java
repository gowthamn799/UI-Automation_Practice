package Practice4;

import io.cucumber.java.nl.Stel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumActions{
    WebDriver driver;
    WebDriverWait wait;
    String ParentWindow;
    public SeleniumActions(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void Click(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));
            ele.click();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void SendData(By locator, String data){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ele.clear();
            ele.click();
            ele.sendKeys(data);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public String  getText(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return ele.getText();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void CheckBox(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (!ele.isSelected()){
                ele.click();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void DropDown(By locator,String text){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select select=new Select(ele);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void MouseHover(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Actions actions=new Actions(driver);
            actions.moveToElement(ele).perform();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void SwitchToChildWindow(){
        try {
            wait.until(ExpectedConditions.numberOfWindowsToBe(1));
            ParentWindow=driver.getWindowHandle();
            for (String child:driver.getWindowHandles()){
                if (!child.equals(ParentWindow)){
                    driver.switchTo().window(child);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void SwitchToParentWindow(){
        driver.switchTo().window(ParentWindow);
    }
    public void SwitchToFrame(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.switchTo().frame(ele);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void SwitchToMainFrame(){
        driver.switchTo().defaultContent();
    }
}
