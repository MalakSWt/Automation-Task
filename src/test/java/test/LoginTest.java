package test;


import base.BaseTest;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataDriven;

import java.io.IOException;


public class LoginTest extends BaseTest {

        @Test
        public void validlogin() throws IOException, ParseException {
            LoginPage loginPage = new LoginPage(driver);
            String username = DataDriven.jsonReader("Valid Login","username","src/test/java/testData/testData.json");
            String password = DataDriven.jsonReader("Valid Login","password","src/test/java/testData/testData.json");
            loginPage.login(username,password);
            String url = driver.getCurrentUrl();
            Assert.assertTrue(url.contains("inventory.html"));
        }
        @Test
        public void invalidlogin() throws IOException, ParseException {
            LoginPage loginPage = new LoginPage(driver);
            String username = DataDriven.jsonReader("Invalid Login","username","src/test/java/testData/testData.json");
            String password = DataDriven.jsonReader("Invalid Login","password","src/test/java/testData/testData.json");
            loginPage.login(username,password);
            WebElement msg = driver.findElement(By.xpath("//h3[@data-test='error']"));
            Assert.assertTrue(msg.getText().contains("Username and password do not match"));
        }
    @Test
    public void emptylogin() throws IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
        String username = DataDriven.jsonReader("Valid Login","username","src/test/java/testData/testData.json");

        loginPage.login(username,"");
        WebElement msg = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertTrue(msg.getText().contains("Password is required"));
    }

            }