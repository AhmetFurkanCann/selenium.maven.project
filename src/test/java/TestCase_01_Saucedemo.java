import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TestCase_01_Saucedemo {
    public static void main(String[] args) {
        /*This test case checks the texts of all buttons after click.
          We expect that texts of all buttons to turn "REMOVE" after click.
        */

        //Set-up
        System.setProperty("webDriver.chrome.driver", "C:\\Users\\Hp\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        //Navigate to url
        driver.get("https://www.saucedemo.com/");

        //Login Process
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Username: standard_user
        driver.findElement(By.name("password")).sendKeys("secret_sauce"); // Password : secret_sauce
        driver.findElement(By.id("login-button")).click();

        //Collect buttons in "buttonsBeforeClick" list
        List<WebElement> buttonsBeforeClick = driver.findElements(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory']"));

        //Click all buttons
        for (WebElement button : buttonsBeforeClick
        ) {
            button.click();
        }

        //Collect buttons after clicking all
        List<WebElement> buttonsAfterClick = driver.findElements(By.cssSelector("button[class='btn btn_secondary btn_small btn_inventory']"));

        //Loop for checking texts of all buttons after click all. Every iteration checks one of them.
        for (int i = 0; i < buttonsAfterClick.size(); i++) {

            //Get the text on the button
            String textAfterClick = buttonsAfterClick.get(i).getText();

            //Text must be "Remove". Otherwise, test will fail.
            Assert.assertEquals(textAfterClick, "REMOVE");
        }

        System.out.println("Test passed");

        //Quit the browser
        driver.quit();
    }
}
