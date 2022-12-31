package SmartBearTestCases.Order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CheckQuantityForUnsuitableValues {
    public static void main(String[] args) throws InterruptedException {
        //Login Process
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.findElement(By.xpath("/html/body/form/div[3]/input[1]")).sendKeys("Tester");
        driver.findElement(By.xpath("/html/body/form/div[3]/input[2]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/form/div[3]/input[3]")).click();
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/ul/li[3]/a")).click();
        //Until here pretest conditions
        //Array for unsuitable values
        String[] testValuesNotPossible = {"abc", "*/", "a12", " 0.5", "12a", "-12", Integer.toString(Integer.MIN_VALUE)};
        //Test Method for unsuitable values
        testMethodForUnSuitableValues(testValuesNotPossible, driver);
        driver.close();
    }
    private static void testMethodForUnSuitableValues(String[] testValuesNotPossible, WebDriver driver) throws InterruptedException {
        //Map for failed values
        Map<String, String> results = new HashMap<>();
        //Loop for test every values
        for (int i = 0; i < testValuesNotPossible.length; i++) {
            //Refresh the page
            driver.navigate().refresh();
            //Insert the possible value
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[1]/li[2]/input")).sendKeys(testValuesNotPossible[i]);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[1]/li[5]/input[2]")).click();
            Thread.sleep(2000);
            try {
                Assert.assertEquals( driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[1]/li[2]/span[2]")).getText(), "Quantity must be greater than zero.");

            } catch (AssertionError e) {
                //if assert fails write the failed values to the map
                results.put(testValuesNotPossible[i] , "Failed" );
            }
        }
        System.out.println("Test for unsuitable Values");
        if (results.isEmpty())
            System.out.println("Test Completed.");
        else {
            System.out.println("Test Failed.");
        }
    }
}
