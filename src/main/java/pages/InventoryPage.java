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
    private By twitterIcon = By.xpath("//a[@data-test=\"social-twitter\"]");
    private By facbookIcon = By.xpath("//a[@data-test=\"social-facebook\"]");
    private By linkedinIcon = By.xpath("//a[@data-test=\"social-linkedin\"]");
    private By backpackAddtocartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By boltTshirtAddtocartBtn = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By onesieaddTocartBtn = By.id("add-to-cart-sauce-labs-onesie");
    private By productNameLocator = By.className("inventory_item_name");
    private By inventoryItems = By.className("inventory_item");


    public InventoryPage(WebDriver driver){
        this.driver=driver;
    }
    public String getProductButtonText(String productName) {
        List<WebElement> items = driver.findElements(inventoryItems);
        for (WebElement item : items) {
            String name = item.findElement(productNameLocator).getText().trim();
            if (name.equalsIgnoreCase(productName.trim())) {
                return item.findElement(By.tagName("button")).getText().trim();
            }
        }
        return null; // if product not found
    }
    public void clickOnTwitterIcon(){
        driver.findElement(twitterIcon).click();
    }
    public void clickOnFacebookIcon(){
        driver.findElement(facbookIcon).click();
    }
    public void clickOnLinkedinIcon(){
        driver.findElement(linkedinIcon).click();
    }
    public void clickOnCartIcon(){
        driver.findElement(carticon).click();
    }
    public void addPackbacktocart(){
        driver.findElement(backpackAddtocartBtn).click();
    }
    public void addBoltTshirttocart(){
        driver.findElement(boltTshirtAddtocartBtn).click();
    }
    public void addonesietocart(){
        driver.findElement(onesieaddTocartBtn).click();
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public void switchToNewTab() {
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }
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
