package test;

import base.BaseTest;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CartTests extends BaseTest {
    @Test
    public void verifyCartIEmpty() throws IOException, ParseException {
    loginPage.login("standard_user","secret_sauce");
    inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.getcartCount(),0,"The cart is not Empty");
    }
    @Test
    public void addToCartTest() throws IOException, ParseException, InterruptedException {
        loginPage.login("standard_user","secret_sauce");
        inventoryPage.addBoltTshirttocart();
        inventoryPage.addonesietocart();
        inventoryPage.addPackbacktocart();
        inventoryPage.clickOnCartIcon();

        SoftAssert softAssert = new SoftAssert();

        String[] expectedProducts = {
                "Sauce Labs Backpack",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Onesie"
        };

        for (String product : expectedProducts) {
            softAssert.assertTrue(
                    cartPage.isProductInCart(product),
                    "Missing product in cart: " + product
            );
        }

        softAssert.assertAll();


    }
    @Test
    public void removeFromCartTest() throws IOException, ParseException {
        loginPage.login("standard_user","secret_sauce");
        inventoryPage.addBoltTshirttocart();
        inventoryPage.addonesietocart();
        inventoryPage.addPackbacktocart();
        inventoryPage.clickOnCartIcon();
        cartPage.removeItemfromCart("Sauce Labs Bolt T-Shirt");
        cartPage.gotoInventoryPage();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                inventoryPage.getProductButtonText("Sauce Labs Bolt T-Shirt"),
                "Add to cart",
                "Removed product button did not change to 'Add to cart'"
        );

        softAssert.assertEquals(
                inventoryPage.getProductButtonText("Sauce Labs Backpack"),
                "Remove",
                "Backpack button should still be 'Remove'"
        );

        softAssert.assertEquals(
                inventoryPage.getProductButtonText("Sauce Labs Onesie"),
                "Remove",
                "Onesie button should still be 'Remove'"
        );

        softAssert.assertAll();

    }
}
