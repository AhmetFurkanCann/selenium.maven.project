import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class e2e {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Hp\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("It is enabled");
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_btn_FindFlights\"]")).click();
    }
}
