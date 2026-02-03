package test;

import base.BaseTest;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.io.IOException;

public class InventoryTest extends BaseTest {
    @Test
    public void inventorytest() throws IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.inventorytile(),"Swag Labs","Page title mismatch");
        Assert.assertTrue(inventoryPage.carticondisplayed(),"Cart icon not displayed");
        Assert.assertEquals(inventoryPage.getinventoryitemscount(),6,"Incorrect number of products displayed");

    }
    @Test
    public void TwitterIconTest() throws IOException, ParseException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnTwitterIcon();
        inventoryPage.switchToNewTab();

        Assert.assertTrue(inventoryPage.getUrl().contains("x.com"),"You are in a wrong page");

    }
    @Test
    public void FacebookIconTest() throws IOException, ParseException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnFacebookIcon();
        inventoryPage.switchToNewTab();

        Assert.assertTrue(inventoryPage.getUrl().contains("facebook"),"You are in a wrong page");

    }
    @Test
    public void LinkedinIconTest() throws IOException, ParseException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnLinkedinIcon();
        inventoryPage.switchToNewTab();

        Assert.assertTrue(inventoryPage.getUrl().contains("linkedin"),"You are in a wrong page");

    }
}
