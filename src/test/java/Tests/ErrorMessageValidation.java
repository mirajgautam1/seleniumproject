package Tests;

import Pages.LoginPage;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidation extends BaseClass {
    @Test
        public void errorMessageTest(){
           LoginPage lpg = new LoginPage(driver);
           lpg.enterUserName("invaliduser");
           lpg.enterPassword("secret");
           lpg.clickOnLoginButton();
           WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")); // find errorMessage element
            Assert.assertTrue(errorMessage.isDisplayed(),"Error message is not displayed"); // tests whether that errorMessage element is visible or not
        }
}
