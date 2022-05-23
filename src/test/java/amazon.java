import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class amazon {
    @Test
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://www.amazon.in/.");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0,3500)");
        driver.findElement(By.xpath("//div[normalize-space()='TV, Appliances, Electronics']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Televisions']")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'TV & Home Entertainment')]"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Samsung']")));
        driver.findElement(By.xpath("//span[text()='Price: High to Low']")).click();
        driver.findElement(By.xpath("//a[@id='s-result-sort-select_2']")).click();
        driver.findElement(By.xpath("//span[text()='Samsung 163 cm (65 inches) 4K Ultra HD Smart QLED TV QA65QN90AAKLXL (Black) (2021 Model)']")).click();
        Set<String> handle=driver.getWindowHandles();
        driver.switchTo().window(String.valueOf(handle));
        jse.executeScript("window.scrollTo(0,3500)");
        Assert.assertEquals("About this item","About this item");
    }
}
