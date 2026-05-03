package Practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumActions {
    WebDriver driver;
    WebDriverWait wait;
    String parentWindow;

    public SeleniumActions(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void Click(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));
            ele.click();
        } catch (Exception e) {
            throw new RuntimeException("Unable to click the element"+e.getMessage());
        }
    }
    public void SendData(By locator,String data){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ele.clear();
            ele.click();
            ele.sendKeys(data);
        } catch (Exception e) {
            throw new RuntimeException("Unable to send data to element"+e.getMessage());
        }
    }
    public String  getText(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return ele.getText();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get the text from element"+e.getMessage());
        }
    }
    public void checkBox(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (!ele.isSelected()){
                ele.click();
            }
        } catch (Exception e) {
            throw new RuntimeException("check box already selected"+e.getMessage());
        }
    }
    public void dropDown(By locator,String text){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select sel=new Select(ele);
            sel.selectByVisibleText(text);
        } catch (Exception e) {
            throw new RuntimeException("Unable to select the dropDown of element"+e.getMessage());
        }
    }
    public void SwitchToChildWindow(){
        try {
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            parentWindow=driver.getWindowHandle();
            for (String child:driver.getWindowHandles()) {
                if (!child.equals(parentWindow)) {
                    driver.switchTo().window(child);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("unable to switch to child window"+e.getMessage());
        }
    }
    public void SwitchToParentWindow(){
        driver.switchTo().window(parentWindow);
    }
    public void SwitchToFrame(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.switchTo().frame(ele);
        } catch (Exception e) {
            throw new RuntimeException("unable to switch to frame"+e.getMessage());
        }
    }
    public void SwitchToMainFrame(){
        driver.switchTo().defaultContent();
    }
    public void MouseHover(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Actions actions=new Actions(driver);
            actions.moveToElement(ele).perform();
            actions.build();
        } catch (Exception e) {
            throw new RuntimeException("unable to do the mouse hover action"+e.getMessage());
        }
    }
}
