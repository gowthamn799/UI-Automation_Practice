package utilities;

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
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void Click(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));
            ele.click();
        }catch (Exception e){
            throw new RuntimeException("Loacted element are not able click"+e.getMessage());
        }
    }
    public void SendData(By loactor,String data) {
        try {
            WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(loactor));
            ele.clear();
            ele.click();
            ele.sendKeys(data);
        } catch (Exception e) {
            throw new RuntimeException("located element are not able send the data" + e.getMessage());
        }
    }
    public String getText(By loactor){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(loactor));
            return ele.getText();
        }catch (Exception e){
            throw new RuntimeException("unable the get the text from the loacted element"+e.getMessage());
        }
    }
    public void DropDown(By loactor,String text){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(loactor));
            Select select=new Select(ele);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            throw new RuntimeException("unale to select the dropDown bcz it is notIn the select tag"+e.getMessage());
        }
    }
    public void MouseHover(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Actions actions=new Actions(driver);
            actions.moveToElement(ele).perform();
        } catch (Exception e) {
            throw new RuntimeException("unale to hover Element "+e.getMessage());
        }
    }
    public void switchToChildWindow(){
        try {
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            parentWindow=driver.getWindowHandle();
            for (String chidWindow:driver.getWindowHandles()){
                if (!chidWindow.equals(parentWindow)) {
                    driver.switchTo().window(chidWindow);
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("unable to switch the windows"+e.getMessage());
        }
    }
    public void switchToParentWindow(){
        driver.switchTo().window(parentWindow);
    }
    public void switchToFrame(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.switchTo().frame(ele);
        } catch (Exception e) {
            throw new RuntimeException("unable to switch to the frame"+e.getMessage());
        }
    }
    public void switchToMainFrame(){
        driver.switchTo().defaultContent();
    }
    public void checkBox(By locator){
        try {
            WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (!ele.isSelected()){
                ele.click();
            }
        } catch (Exception e) {
            throw new RuntimeException("unable to check the box"+e.getMessage());
        }
    }
}
