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

public class TC_003 {
    public static void main(String[] args) {
        /*
        In this  test case, we are checking: when we click the button (price low-high),
        whether the product prices sorted ascending order or not.
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        //Navigate to url
        driver.get("https://www.saucedemo.com/");

        //Enter valid username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        //click the (price low-high) button
        WebElement staticDropdown = driver.findElement(By.cssSelector("select.product_sort_container"));
        Select name = new Select(staticDropdown);
        name.selectByVisibleText("Price (low to high)");


        //Take all the prices to List
        List<WebElement> productsPrices = driver.findElements(By.cssSelector("div.inventory_item_price"));


        // Extract the "$" icon from the prices
        ArrayList<String> pricesW$ = without$(productsPrices);

        // Convert String to double
        ArrayList<Double> prices = strToDouble(pricesW$);

        //sort low to high price
        ArrayList<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);


        //Check whether prices and sortedPrices are equals.If not give alert message
        for (int i = 0; i < prices.size(); i++) {
            if (!prices.get(i).equals(sortedPrices.get(i))) {
                System.out.println("Products prices are not in ascending order");
                break;
            }
        }
        //if prices and sorted prices are same the test will pass.Otherwise it fails.
        Assert.assertEquals(prices, sortedPrices);
        System.out.println("The test has passed");

        //Quit from browser
        driver.quit();


    }

    public static ArrayList<Double> strToDouble(ArrayList<String> pricesW$) {
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
