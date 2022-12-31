package SmartBearTestCases.Order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CheckQuantityForSuitableValues {
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
        //Array for suitable values
        String[] testValuesPossible = {"1", "50", "100", "1000", Integer.toString(Integer.MAX_VALUE)};
        //Test Method for suitable values
        testMethodForSuitableValues(testValuesPossible, driver);
        driver.close();

    }

    private static void testMethodForSuitableValues(String[] testValuesPossible, WebDriver driver) throws InterruptedException {
        //Map for failed values
        Map<String, String> results = new HashMap<>();
        //Loop for test every values
        for (int i = 0; i < testValuesPossible.length; i++) {
            //Refresh the page
            driver.navigate().refresh();
            //Insert the possible value
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[1]/li[2]/input")).sendKeys(testValuesPossible[i]);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[1]/li[5]/input[2]")).click();
            Thread.sleep(2000);
            //Get total value
            double total = Double.parseDouble((driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[1]/li[5]/input[1]")).getAttribute("value")));
            try {
                //Check is it greater than zero
                boolean greaterThanZero = (total > 0) ;
                //Write to assert line
                Assert.assertEquals( greaterThanZero, true);

            } catch (AssertionError e) {
                //if assert fails write the failed values to the map
                results.put(testValuesPossible[i] , Double.toString(total) );
            }
        }
        System.out.println("Test for suitable Values");
        if (results.isEmpty())
            System.out.println("Test Completed.");
        else {
            System.out.println("Test Failed.");
        }
    }
}
