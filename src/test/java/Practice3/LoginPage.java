package Practice3;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends FileReader {

    WebDriver driver;
    SeleniumActions actions;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.actions=new SeleniumActions(driver);
        PageFactory.initElements(driver,this);
    }
    By email=By.xpath("");
    By password=By.xpath("");

    public void Email() throws IOException, ParseException {
        actions.sendData(email,FileReader.jsonReader("Email"));
    }
    public void Password() throws IOException, ParseException {
        actions.sendData(password,FileReader.jsonReader("Password"));
    }
}
