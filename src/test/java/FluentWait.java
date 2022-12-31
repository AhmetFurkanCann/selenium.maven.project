import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait<W extends SearchContext> {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id='start'] button")).click();
        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                if (driver.findElement(By.cssSelector("[id = 'finish'] h4")).isDisplayed()) {
                    return driver.findElement(By.cssSelector("[id = 'finish'] h4"));
                } else {
                    return null;
                }
            }
        });
        System.out.println(driver.findElement(By.cssSelector("[id = 'finish'] h4")).getText());
    }
}
