package SmartBearTestCases.Order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CheckingCardButtonsItCanBeSelectedMoreThanOnce {
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
        //Select All Card Buttons
        selectAllCardButtons(driver);
        //Control Is More Than One Radio Button Selected
        Assert.assertEquals(isMoreThanOneRadioButtonSelected(driver), true);
        driver.close();
    }

    private static boolean isMoreThanOneRadioButtonSelected(WebDriver driver) {
        //Put all radio buttons of cards into the list
        List<WebElement> radioArray = driver.findElements(By.xpath("//input[@type='radio']"));
        //Count how many button are selected
        int count = 0;
        for (WebElement radio:radioArray
        ) {
            if (radio.isSelected()){
                count++;
            }
        }
        // return result
        return (count != 1) ? false : true ;
    }

    private static void selectAllCardButtons(WebDriver driver) {
        //Select All Card Buttons
        List<WebElement> radioArray = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement radio:radioArray
        ) {
            radio.click();
        }
    }
}
