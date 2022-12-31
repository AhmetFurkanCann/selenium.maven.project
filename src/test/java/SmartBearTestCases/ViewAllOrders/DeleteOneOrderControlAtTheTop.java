package SmartBearTestCases.ViewAllOrders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class DeleteOneOrderControlAtTheTop {
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
        //Select one order (At the top)
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[2]/td[1]/input")).click();
        //Keep the names and products of top two elements to check is it still exist
        String nameAndProductOfTheTopElementBeforeDelete =driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[2]/td[2]")).getText() + "," +
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[2]/td[3]")).getText() ;
        String nameAndProductOfTheTopSecondElementBeforeDelete =driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[3]/td[2]")).getText() + "," +
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[3]/td[3]")).getText() ;
        //Click Delete Selected Button
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/input")).click();
        //Take the name and product of the top element after delete
        String nameAndProductOfTheTopElementAfterDelete =driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[2]/td[2]")).getText() + "," +
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[2]/td[3]")).getText() ;
        //Check element which is second before deletion become first after deletion
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[2]/td[2]")).getText() + "," +
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[2]/td[3]")).getText() , nameAndProductOfTheTopSecondElementBeforeDelete);
        driver.close();
    }
}
