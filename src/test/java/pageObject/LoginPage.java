package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumActions;

public class LoginPage {

    WebDriver driver;
    SeleniumActions actions;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.actions=new SeleniumActions(driver);
        PageFactory.initElements(driver,this);
    }
    By loginButton =By.xpath("//a[text()='Log in']");
    By email=By.xpath("//input[@id='Email']");

    By password=By.xpath("//input[@id='Password']");
    By rememberMe=By.xpath("//input[@value='true']");

    By submittButton=By.xpath("//input[@value='Log in']");

    public void setLoginButton(){
        actions.Click(loginButton);
    }
    public void setEmail(String Email){
      actions.SendData(email,Email);
    }
    public void setPassword(String Password){
       actions.SendData(password,Password);
    }
    public void setRememberMe(){
       actions.checkBox(rememberMe);
    }
    public void setSubmittButton(){
        actions.Click(submittButton);
    }

}
