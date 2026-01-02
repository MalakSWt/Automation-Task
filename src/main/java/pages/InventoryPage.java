package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    private By inventorytitle = By.xpath("//div[@class='app_logo']");
    private By carticon = By.xpath("//a[@class='shopping_cart_link']");
    private By inventoryitem = By.className("inventory_item");

    public InventoryPage(WebDriver driver){
        this.driver=driver;
    }
    public String inventorytile(){
        return driver.findElement(inventorytitle).getText();

    }
    public boolean carticondisplayed(){
        return driver.findElement(carticon).isDisplayed();
    }
    public int getinventoryitemscount(){
        List<WebElement> items = driver.findElements(inventoryitem);
        return items.size();
    }



}
