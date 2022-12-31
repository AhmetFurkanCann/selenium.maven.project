package SmartBearTestCases.ViewAllOrders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class DeleteAllOrdersControl {
    public static void main(String[] args) throws InterruptedException {
        //Login Process
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Hp\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.findElement(By.xpath("/html/body/form/div[3]/input[1]")).sendKeys("Tester");
        driver.findElement(By.xpath("/html/body/form/div[3]/input[2]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/form/div[3]/input[3]")).click();
        //Click CheckAll Button
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/p/a[1]")).click();
        Thread.sleep(2000);
        //Until here pretest conditions
        //Click Delete Selected Button
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/input")).click();
        //Check for is user in correct page
        Assert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Default.aspx");
        //Check for "List of orders is empty. In order to add new order use this link" expression can be seen on screen
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[2]")).getText(), "List of orders is empty. In order to add new order use this link.");

        driver.close();
    }
}
