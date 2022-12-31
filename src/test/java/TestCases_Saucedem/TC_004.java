package TestCases_Saucedem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TC_004 {
    public static void main(String[] args) {
        /*
        In this  test case, we are checking : when we click the button (price high-low),
        whether the product prices sorted descending order or not.
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Navigate to url
        driver.get("https://www.saucedemo.com/");

        //Enter valid username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        //click the (price high-low) button
        WebElement staticDropdown = driver.findElement(By.cssSelector("select.product_sort_container"));
        Select name = new Select(staticDropdown);
        name.selectByIndex(3);


        //take all the prices
        List<WebElement> prices = driver.findElements(By.cssSelector("div.inventory_item_price"));


        // Extract the "$" icon from the prices
        ArrayList<String> pricesW$ = without$(prices);


        // convert String to double
        ArrayList<Double> price = srtToDouble(pricesW$);

        //sort high to low price
        ArrayList<Double> sortedPrices = new ArrayList<>(price);
        Collections.sort(sortedPrices);
        Collections.reverse(sortedPrices);


        //Check whether prices and sortedPrices are equals.If not give alert message
        for (int i = 0; i < price.size(); i++) {
            if (!price.get(i).equals(sortedPrices.get(i))) {
                System.out.println("Products prices are not in descending order");
                break;
            }
        }

        //if prices and sorted prices are same the test will pass.Otherwise it fails.
        Assert.assertEquals(price, sortedPrices);
        System.out.println("The test has passed");

        //Quit from browser
        driver.quit();
    }

    public static ArrayList<Double> srtToDouble(ArrayList<String> pricesW$) {
        ArrayList<Double> price = new ArrayList<>();
        for (int i = 0; i < pricesW$.size(); i++) {
            price.add(Double.parseDouble(pricesW$.get(i)));

        }
        return price;
    }

    public static ArrayList<String> without$(List<WebElement> prices) {
        ArrayList<String> pricesW$ = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            String[] pricesWithout$ = prices.get(i).getText().split("\\$");
            pricesW$.add(pricesWithout$[1]);

        }
        return pricesW$;
    }


}