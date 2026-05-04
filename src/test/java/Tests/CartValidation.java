package Tests;

import Pages.LoginPage;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartValidation extends BaseClass {
    @Test
        public void cartTest(){
            LoginPage lpg = new LoginPage(driver);
            lpg.enterUserName("standard_user"); // enter username
            lpg.enterPassword("secret_sauce");  //enter password
            lpg.clickOnLoginButton(); // click on login button
            List <WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add to cart']")); //locates and stores all the 'Add to cart' button elements on WebElement variable addToCart
            int items = 3;  // initializes item variable to 3 so that we can click on 3 Add to cart buttons
            for(int i = 1; i<=items; i++){
                addToCart.get(i).click();  // clicks on first three Add to cart buttons individually on each loop
            }
            driver.findElement(By.className("shopping_cart_link")).click(); //clicks on shopping cart
            List<WebElement> cartItems = driver.findElements(By.className("inventory_item_name")); // gets all the items included in shopping cart
            int sizeOfCart = cartItems.size(); // gets the number of items included in shopping cart
            Assert.assertEquals(sizeOfCart,items,"Items are not added to cart in correct way"); //compares the number of items in cart with the number of add to cart buttons actually clicked, if they are same then the test is successful
        }
}
