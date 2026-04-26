package Practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;

public class SeleniumActions {
    WebDriver driver;
    WebDriverWait wait;
    String parentWindow;

    public SeleniumActions(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public void Click(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));
            ele.click();
        }catch (Exception e){
            throw new RuntimeException("unable to click on the located Element"+e.getMessage());
        }
    }
    public void SendData(By locator,String data){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ele.clear();
            ele.click();
            ele.sendKeys(data);
        } catch (Exception e) {
            throw new RuntimeException("unable to send data to located Element "+e.getMessage());
        }
    }
    public void CheckBox(By locator){
        WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            if (!ele.isSelected()){
                ele.click();
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to check the located element "+e.getMessage());
        }
    }
    public void MouseHover(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Actions actions=new Actions(driver);
            actions.moveToElement(ele).perform();
            actions.doubleClick();
        } catch (Exception e) {
            throw new RuntimeException("Unable to hover and double on the located element "+e.getMessage());
        }
    }
    public void DropDown(By locator,String data){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select select=new Select(ele);
            select.selectByVisibleText(data);
        } catch (Exception e) {
            throw new RuntimeException("Unable to select the dropdown located element "+e.getMessage());
        }
    }
    public void SwitchToChildWindow(){
        try {
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            parentWindow=driver.getWindowHandle();
            for (String childWindow:driver.getWindowHandles()){
                if (!parentWindow.equals(childWindow)){
                    driver.switchTo().window(childWindow);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("unable to switch to child Window"+e.getMessage());
        }
    }
    public void SwitchToParentWindow(){
        driver.switchTo().window(parentWindow);
    }
    public void SwitchToFrame(By locator){
        try {
            WebElement ele= (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
            driver.switchTo().frame(ele);
        } catch (Exception e) {
            throw new RuntimeException("unale to switch to frame"+e.getMessage());
        }
    }
    public void SwitchToMainFrame(){
        driver.switchTo().defaultContent();
    }
    public String GetText(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return ele.getText();
        } catch (Exception e) {
            throw new RuntimeException("unable to get the text from located element"+e.getMessage());
        }
    }
}
