package TestCases_Saucedem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class TC_008 {
    public static void main(String[] args) {
        // this test case check logging out
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

        driver.findElement(By.id("react-burger-menu-btn")).click();

        driver.findElement(By.id("logout_sidebar_link")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        System.out.println("passed");
        driver.quit();


    }
}
