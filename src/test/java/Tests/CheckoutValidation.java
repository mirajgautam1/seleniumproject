package Tests;

import Pages.LoginPage;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class CheckoutValidation extends BaseClass {
    @Test
    public void checkOutTest(){
        LoginPage lpg = new LoginPage(driver);
        lpg.enterUserName("standard_user");
        lpg.enterPassword("secret_sauce");
        lpg.clickOnLoginButton();
        List<WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add to cart']")); //locates all the add to cart button options
        int items = 2;
        for(int i = 1; i<=items; i++){
            addToCart.get(i).click(); // clicks on first two add to cart buttons
        }
        driver.findElement(By.className("shopping_cart_link")).click(); // locates shopping cart and clicks on it
        WebElement checkOutButton = driver.findElement(By.id("checkout")); //locates checkout button
        checkOutButton.click(); //clicks on checkout
        WebElement firstName = driver.findElement(By.id("first-name")); // locates first-name field
        firstName.sendKeys("Miraj"); //enters first name
        WebElement lastName = driver.findElement(By.id("last-name")); //locates last name field
        lastName.sendKeys("Gautam"); //enters last name
        WebElement zipCode = driver.findElement(By.id("postal-code")); //locates postal code field
        zipCode.sendKeys("3360"); // enters postal code
        WebElement continueButton = driver.findElement(By.id("continue")); //locates continue button
        continueButton.click(); //clicks on continue button
        WebElement finishButton = driver.findElement(By.id("finish")); //locates finish button
        finishButton.click(); //clicks on finish button
        WebElement thankYouPage = driver.findElement(By.id("checkout_complete_container")); //locates the checkout complete container element
        Assert.assertTrue(thankYouPage.isDisplayed(),"Order Unsuccessful"); // tests whether the checkout successful container is displaying or not, if it is displaying then the checkout is successful
    }
}
