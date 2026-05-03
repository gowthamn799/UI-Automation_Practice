package Practice2;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends FileReader{
    WebDriver driver;
    SeleniumActions action;
    public LoginPage(WebDriver driver) {
      this.driver=driver;
      this.action=new SeleniumActions(driver);
      PageFactory.initElements(driver,this);
    }
    By email= By.xpath("");
    By password=By.xpath("");
    By login=By.xpath("");

    public void Email() throws IOException, ParseException {
        action.SendData(email,jsonReader("Email"));
    }
    public void Password() throws IOException, ParseException {
        action.SendData(password,jsonReader("password"));
    }
    public void login(){
        action.Click(login);
    }
}
