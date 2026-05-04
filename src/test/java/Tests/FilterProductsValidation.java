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
        List <String> expectedNames = new ArrayList<>(productNames); //creates a new array expectedNames and copies all the names of ProductNames
        expectedNames.sort(Collections.reverseOrder()); // reverses the order of Names in expectedNames to descending order
        Assert.assertEquals(expectedNames,productNames,"Descending Filter for name failed"); // verifies whether the result shown by webpage matches the correct descending order
    }
    @Test
    public void priceFilterTest(){
        LoginPage lpg = new LoginPage(driver); //
        lpg.enterUserName("standard_user");
        lpg.enterPassword("secret_sauce");
        lpg.clickOnLoginButton();
        WebElement dropdown = driver.findElement(By.className("product_sort_container")); //find drop down option
        dropdown.click(); //click on dropdown
        WebElement lowToHighOption = driver.findElement(By.xpath("//option[@value='lohi']")); // locates the low to high dropdown option
        lowToHighOption.click(); // clicks on low to high option
        List<WebElement> products = driver.findElements(By.className("inventory_item_price")); // captures all the inventory item prices
        List <Double> productPrices = new ArrayList<>(); // creates an empty array list productPrices of type Double
        for(WebElement price : products){
            productPrices.add(Double.parseDouble(price.getText().replace("$",""))); // replaces "$" symbol with "",then converts text type to Double type and adds all prices to productPrices
        }
        List<Double> expectedPrices = new ArrayList<>(productPrices); //creates a new array list expectedPrices and copies all the values of productPrices to it.
        Collections.sort(expectedPrices); // sorts the expected prices values in ascending order i.e low to high
        Assert.assertEquals(productPrices, expectedPrices,"price sorting low - high failed"); // compares the product prices with expectedPrices, if they match then the test is successful
    }

}
