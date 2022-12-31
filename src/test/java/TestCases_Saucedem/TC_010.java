package TestCases_Saucedem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class TC_010 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

        driver.findElement(By.name("login-button")).click();

        driver.findElement(By.cssSelector("button[data-test='add-to-cart-sauce-labs-backpack']")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        driver.findElement(By.id("shopping_cart_container")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("LOY");

        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("LOYLOY");

        driver.findElement(By.name("postalCode")).sendKeys("2022");

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        Assert.assertEquals(driver.findElement(By.xpath("(//h2[normalize-space()='THANK YOU FOR YOUR ORDER'])[1]")).getText(), "THANK YOU FOR YOUR ORDER");

        System.out.println("Passed");

        driver.quit();
    }
}
