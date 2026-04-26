package testPacks;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import utilities.BaseClass;

import java.io.IOException;

public class LoginTestCase extends BaseClass {

    @Test(groups = {"smoke"})
    public void Login() throws IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setLoginButton();
        loginPage.setEmail(jsonReader("userName"));
        loginPage.setPassword(jsonReader("password"));
        loginPage.setRememberMe();
        loginPage.setSubmittButton();
    }
    @Test(groups = {"sanity"})
    public void test2(){
        System.out.println("Sanity is running");
    }

}
