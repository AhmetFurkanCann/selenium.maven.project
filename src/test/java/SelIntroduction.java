import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Hp\\Desktop\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://rahulshettyacademy.com/");
        //String title = driver.getTitle();
        //System.out.println(title);
        //System.out.println(driver.getCurrentUrl());
        //driver.close();
        // System.setProperty("webdriver.gecko.driver" , "C:\\Users\\Hp\\Desktop\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //driver.get("https://rahulshettyacademy.com/");
        //String title = driver.getTitle();
        //System.out.println(title);
        //System.out.println(driver.getCurrentUrl());
        //driver.close();
        System.setProperty("webdriver.edge.driver" , "C:\\Users\\Hp\\Desktop\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/");
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
}
