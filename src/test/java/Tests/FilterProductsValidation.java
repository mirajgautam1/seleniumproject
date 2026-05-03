package Tests;

import Pages.LoginPage;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterProductsValidation extends BaseClass {
    @Test
    public void descendingOrderTest(){
        LoginPage lpg = new LoginPage(driver);
        lpg.enterUserName("standard_user");
        lpg.enterPassword("secret_sauce");
        lpg.clickOnLoginButton();
        WebElement dropdown = driver.findElement(By.className("product_sort_container")); //find drop down option
        dropdown.click(); //click on dropdown
        WebElement descOption = driver.findElement(By.xpath("//option[@value='za']")); //find the opton for descending "za" order
        descOption.click(); // click on descending 'za' option
        List<WebElement> products = driver.findElements(By.className("inventory_item_name")); // captures all the inventory products
        List <String> productNames = new ArrayList<>(); // create a new array productNames to store the Names of products
        for(WebElement product : products){
            productNames.add(product.getText()); // adds name of each product element in productNames array
        }
        List <String> expectedNames = new ArrayList<>(productNames); //creates a new array expectedNames and copies all the names of ProducNames
        expectedNames.sort(Collections.reverseOrder()); // reverses the order of Names in expectedNames to descending order
        Assert.assertEquals(expectedNames,productNames,"Descending Filter for name failed"); // verifies whether the result shown by webpage matches the correct descending order
    }
    @Test
    public void priceFilterTest(){
        LoginPage lpg = new LoginPage(driver);
        lpg.enterUserName("standard_user");
        lpg.enterPassword("secret_sauce");
        lpg.clickOnLoginButton();
        WebElement dropdown = driver.findElement(By.className("product_sort_container")); //find drop down option
        dropdown.click(); //click on dropdown
        WebElement lowToHighOption = driver.findElement(By.xpath("//option[@value='lohi']"));
        lowToHighOption.click();
        List<WebElement> products = driver.findElements(By.className("inventory_item_price"));
        List <Double> productPrices = new ArrayList<>();
        for(WebElement price : products){
            productPrices.add(Double.parseDouble(price.getText().replace("$","")));
        }
        List<Double> expectedPrices = new ArrayList<>(productPrices);
        Collections.sort(expectedPrices);
        Assert.assertEquals(productPrices, expectedPrices,"price sorting low - high failed");
    }

}
