package Practice4;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class loginPage extends FileReader {
    WebDriver driver;
    SeleniumActions actions;
    public loginPage(WebDriver driver){
        this.driver=driver;
        this.actions=new SeleniumActions(driver);
    }
    By email=By.xpath("");
    By password=By.xpath("");

    public void Email() throws IOException, ParseException {
        actions.SendData(email,jsonReader("Email"));
    }
    public void Password() throws IOException, ParseException {
        actions.SendData(password,jsonReader("Password"));
    }
}
