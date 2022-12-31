package TestCases_Saucedem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TC_007 {
    public static void main(String[] args) {
        //this test check whether sum of prices are calculated or not.

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        //Navigate to url and login

        driver.get("https://www.saucedemo.com/");

        WebElement userNameBox = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userNameBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");
        loginButton.click();

        // take all product prices with class name


        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

        //get text from price elements as a string to ArrayList


        ArrayList<String> textOfPrices = new ArrayList<>();


        for (WebElement p : prices
        ) {
            String s = p.getText().substring(1);
            textOfPrices.add(s);


        }

        // convert String to double and calculate

        double sumOfPrices = 0;

        for (int i = 0; i < textOfPrices.size(); i++) {
            double p = Double.parseDouble(textOfPrices.get(i));
            sumOfPrices += p;


        }
        //click all products add to chart button

        List<WebElement> buttonLink = driver.findElements(By.xpath("//button[text()='Add to cart']"));

        for (WebElement button : buttonLink) {
            button.click();
        }
        //navigate to chart
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
// click on checkout button
        driver.findElement(By.cssSelector("#checkout")).click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='postal-code']"));

        WebElement continueButton = driver.findElement(By.id("continue"));
//fill the blanks and then click continue button
        firstName.sendKeys("sadasd");
        lastName.sendKeys("asfad");
        zipCode.sendKeys("dfadasda");
        continueButton.click();

        // get text of items total without tax

        String textOfTotal = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
        String s = textOfTotal.substring(13);

        double total = Double.parseDouble(s);


// check whether true or not
        Assert.assertEquals(sumOfPrices, total);

        System.out.println("passed");
        driver.quit();


    }

}
