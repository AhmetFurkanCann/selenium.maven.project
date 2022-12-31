package SeleniumExercises_RahulShetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicPassword {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Hp\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/form/div/button[2]")).click();
        String wholeString= driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/form/p")).getText();
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/form/div/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("inputUsername")).sendKeys("afc");
        driver.findElement(By.name("inputPassword")).sendKeys(getPassword(wholeString));
        Thread.sleep(1000);
        driver.findElement(By.className("signInBtn")).click();
    }

    private static String getPassword(String wholeString) {
        int firstIndex= wholeString.indexOf("'");
        int lastIndex = wholeString.lastIndexOf("'");
        String password = wholeString.substring(firstIndex + 1 , lastIndex);
        return password;
    }
}
