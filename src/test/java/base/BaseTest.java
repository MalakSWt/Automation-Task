package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage ;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    @BeforeMethod
    public void setup(){
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
