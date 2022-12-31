package SmartBearTestCases.ViewAllOrders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CheckDoAllEditButtonWork {
    public static void main(String[] args) {
        //Login Process
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Hp\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.findElement(By.xpath("/html/body/form/div[3]/input[1]")).sendKeys("Tester");
        driver.findElement(By.xpath("/html/body/form/div[3]/input[2]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/form/div[3]/input[3]")).click();
        //Until here pretest conditions
        //CheckDoAllEditButtonWork
        checkDoAllEditButtonWork(driver);


    }
    private static void checkDoAllEditButtonWork(WebDriver driver) {
        //Fill the array with editButtonElements
        List<WebElement> editButtonsArray = driver.findElements(By.xpath("//input[@type='image']"));
        //Loop for Checking Do All Edit Button Work
        for (WebElement editButton:editButtonsArray
        ) {
            editButton.click();
            Assert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Default.aspx");
            driver.navigate().back();
        }

    }
}
