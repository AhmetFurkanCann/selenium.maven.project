package TestCases_Saucedem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class TC_009 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

        driver.findElement(By.name("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        driver.findElement(By.id("about_sidebar_link")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"entry-3qDFahnypj1KkiORyU1Zyh\"]/div/div/div/div[1]/div/h1")).getText(), "DEVELOP WITH CONFIDENCE");

        driver.quit();
    }
}
