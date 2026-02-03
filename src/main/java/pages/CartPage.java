package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    protected WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver=driver;
    }
    private By cartItems = By.className("cart_item");
    private By cartItemName = By.className("inventory-item-name");
    private By removeBtn = By.xpath("//button[text()='Remove']");
    private By continueShopingBtn = By.id("continue-shopping");

    public int getcartCount(){
       return driver.findElements(cartItems).size();

    }
    public void gotoInventoryPage(){
        driver.findElement(continueShopingBtn).click();
    }
    public void removeItemfromCart(String productName){
        List<WebElement> items = driver.findElements(cartItems);

        for (WebElement item : items) {
            String name = item.findElement(By.className("inventory_item_name")).getText().trim();

            if (name.equalsIgnoreCase(productName.trim())) {
                item.findElement(removeBtn).click();
                break;
            }
        }
    }
    public boolean isProductInCart(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));

        List<WebElement> items = driver.findElements(cartItems);
        for (WebElement item : items) {
            String name = item.findElement(By.className("inventory_item_name")).getText().trim();
            if (name.equalsIgnoreCase(productName.trim())) {
                return true;
            }
        }
        return false;
    }

}
