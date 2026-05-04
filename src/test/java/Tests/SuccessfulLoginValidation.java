package Tests;

import Pages.LoginPage;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulLoginValidation extends BaseClass {
    @Test
    public void loginTest(){
        LoginPage lpg = new LoginPage(driver);
        lpg.enterUserName("standard_user");
        lpg.enterPassword("secret_sauce");
        lpg.clickOnLoginButton();
        WebElement inventorycontainer = driver.findElement(By.id("inventory_container")); // find inventory container element using id
        Assert.assertTrue(inventorycontainer.isDisplayed(),"Not Logged in Yet"); // assertion to validate whether inventory container is being displayed or not, if it is displayed then it means that login is succesful

    }

}
