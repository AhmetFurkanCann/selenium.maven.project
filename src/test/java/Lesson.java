import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Lesson {
    public static void main(String[] args) {
        System.setProperty("webDriver.chrome.driver", "C:\\Users\\Hp\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));
        //Get Product Names
        ArrayList<String> productsNames = new ArrayList<>();
        for (WebElement l : products
        ) {
            productsNames.add(l.getText());
        }
        //Chose
        List<WebElement> buttonLink = driver.findElements(By.xpath("//button[text()='Add to cart']"));

        for (WebElement button : buttonLink) {
            button.click();
        }
        //navigate to sepet
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        List<WebElement> productsBuy = driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));
        //Get Product Names
        ArrayList<String> productsBuyNames = new ArrayList<>();
        for (WebElement l : productsBuy
        ) {
            productsBuyNames.add(l.getText());
        }
        Assert.assertEquals(checkAllProduct(productsNames, productsBuyNames), true);
        System.out.println("Test passed!Loy");
        driver.close();


    }

    private static boolean checkAllProduct(ArrayList<String> productsNames, ArrayList<String> productsBuyNames) {

        //check contains
        for (String str : productsNames
        ) {
            if (!productsBuyNames.contains(str)) {
                return false;
            }
        }
        return true;

    }
}
