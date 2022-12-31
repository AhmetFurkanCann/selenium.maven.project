package TestCases_Saucedem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TC_002 {
    public static void main(String[] args) {
         /*This test case checks whether the number on the cart icon (at the top right of the page)
         is compatible with the products which are added to cart or not.
        */

        //Set-up
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        //Navigate to url
        driver.get("https://www.saucedemo.com/");

        //Login Process
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Username: standard_user
        driver.findElement(By.name("password")).sendKeys("secret_sauce"); // Password : secret_sauce
        driver.findElement(By.id("login-button")).click();

        //Collect buttons in "buttons" list
        List<WebElement> buttons = driver.findElements
                (By.cssSelector("button[class='btn btn_primary btn_small btn_inventory']"));

        //Number of the products which are added to cart to compare with the number on the cart icon
        int numberOfTheProductsInTheCart = 0;

        //Loop for adding products to cart
        for (int i = 0; i < buttons.size() ; i++) {

            //Add one product to cart
            buttons.get(i).click();

            //Increase the number of the products which are added to cart
            numberOfTheProductsInTheCart++;

            //Get the number on the cart icon
            int numberOnTheCartIcon = Integer.parseInt(driver.findElement
                    (By.cssSelector("span[class='shopping_cart_badge']")).getText());

            /* Number of the products which are added to cart must be equal to
             number on the cart icon. Otherwise, test will fail.
            */
            Assert.assertEquals(numberOnTheCartIcon , numberOfTheProductsInTheCart);
        }

        System.out.println("Test passed");

        //Quit the browser
        driver.quit();
    }
}
