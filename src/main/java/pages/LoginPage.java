package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.text.Utilities;
import java.io.IOException;

public class LoginPage {
    private WebDriver driver;
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginbtn = By.id("login-button");


    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void login(String user, String pass) throws IOException, ParseException {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginbtn).click();
    }
}
