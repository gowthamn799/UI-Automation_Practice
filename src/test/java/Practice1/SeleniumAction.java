package Practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumAction {

    WebDriver driver;
    WebDriverWait wait;
    String parentWindow;
    public SeleniumAction(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void Click(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));
            ele.click();
        }catch (Exception e){
            throw new RuntimeException("Unable to click the Element "+e.getMessage());
        }
    }
    public void SendData(By loaLocator,String data){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(loaLocator));
            ele.clear();
            ele.click();
            ele.sendKeys(data);
        } catch (Exception e) {
            throw new RuntimeException("Unable to send Data to Element "+e.getMessage());
        }
    }
    public String GetText(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return ele.getText();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get the text from Element"+e.getMessage());
        }
    }
    public void checkBox(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (!ele.isSelected()){
                ele.click();
            }
        } catch (Exception e) {
            throw new RuntimeException("unable to click on checkbox "+e.getMessage());
        }
    }
    public void mouseHover(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Actions actions=new Actions(driver);
            actions.moveToElement(ele).perform();
            actions.contextClick(ele);
        } catch (Exception e) {
            throw new RuntimeException("unable to mouseHover action "+e.getMessage());
        }
    }
    public void dropDown(By locator,String data){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select select=new Select(ele);
            select.selectByVisibleText(data);
        } catch (Exception e) {
            throw new RuntimeException("unable to select the dropDown "+e.getMessage());
        }
    }
    public void SwitchToChildWindow(){
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        parentWindow=driver.getWindowHandle();
        for (String childWindow:driver.getWindowHandles()){
            if (!childWindow.equals(parentWindow)){
                driver.switchTo().window(childWindow);
            }
        }
    }
    public void SwitchToParentWindow(){
        driver.switchTo().window(parentWindow);
    }
    public void SwitchToFrame(By locator){
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.switchTo().frame(ele);
    }
    public void SwitchToMainFrame(){
        driver.switchTo().defaultContent();
    }
}
