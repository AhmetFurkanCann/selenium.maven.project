package SeleniumExercises_RahulShetty;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companion/");
        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,700)");

        //Thread.sleep(5000);
        //April 23
        driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();


        while (!driver.findElement(By.cssSelector("[class='flatpickr-current-month'] [class='cur-month']")).getText().contains("May")) {
            driver.findElement(By.cssSelector("[class='flatpickr-next-month']")).click();
        }


        List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
        //Grab common attribute//Put into list and iterate
        int count = driver.findElements(By.className("flatpickr-day")).size();

        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
            if (text.equalsIgnoreCase("21")) {
                driver.findElements(By.className("flatpickr-day")).get(i).click();
                break;
            }

        }
    }
}
