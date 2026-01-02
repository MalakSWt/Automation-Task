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
}
